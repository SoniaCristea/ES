package src.gui_functionality;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
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
				Tag tag = new Tag(tagName, Integer.parseInt(treshold));
				tags.add(tag);
				model.addRow(new String[]{Integer.toString(++counter), tagName, treshold});
				tagNameTxt.setText("");
				tresholdTxt.setText("");
			}
		});
		
	}

	public ArrayList<Tag> getTags() {
		return tags;
	}

}
