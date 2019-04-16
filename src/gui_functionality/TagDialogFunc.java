package src.gui_functionality;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import src.extensions.Tag;
import src.gui_swing.TagDialog;

public class TagDialogFunc {
	
	private JButton addTagBtn = new JButton();
	private JTable table = new JTable();
	private JTextField tagNameTxt = new JTextField();
	private JTextField tresholdTxt = new JTextField();
	private int counter = 0;
	private ArrayList<Tag> tags = new ArrayList<>();
	private static File tagsFile = new File("tags.txt");
	
	
	public TagDialogFunc(TagDialog td){
		
		addTagBtn = td.getAddTagBtn();
		table = td.getTagDialogTable();
		tagNameTxt = td.getNameTxtField();
		tresholdTxt = td.getTresholdTxtField();
		
		addTagBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String tagName = tagNameTxt.getText();
				String treshold = tresholdTxt.getText();
				
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				try{
				Tag tag = new Tag(tagName, Integer.parseInt(treshold));
				tags.add(tag);
				}catch(NumberFormatException ex){
					JOptionPane.showMessageDialog(td, "Threshold must be a number!");
					return;
				}
				model.addRow(new String[]{Integer.toString(++counter), tagName, treshold});
				tagNameTxt.setText("");
				tresholdTxt.setText("");
				writeTagsToFile();
			}
		});
		
	}
	
	private void writeTagsToFile() {

		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(tagsFile, true));

			for (Tag t : tags) {
					bw.write(t.toString());
				
			}
			bw.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}

	public ArrayList<Tag> getTags() {
		return tags;
	}

}
