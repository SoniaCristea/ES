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
import javax.swing.table.DefaultTableModel;

import src.extensions.Document;
import src.extensions.DocumentFolder;
import src.extensions.Tag;
import src.gui_swing.ListOfTagsDialog;
import src.gui_swing.TagDialog;
import src.gui_swing.UserAssignDialog;
import src.util.Classifier;

public class ListOfTagsDialogFunc {
	private JButton addTagBtn = new JButton();
	private JButton deleteTagBtn = new JButton();
	private JTable table = new JTable();
	private int counter = 0;
	private ArrayList<Tag> tags = new ArrayList<>();
	private TagDialogFunc tdf;
	private UserAssignDialogFunc udf;
	private static File files = new File("files.txt");

	public ListOfTagsDialogFunc(ListOfTagsDialog f, TagDialog td, UserAssignDialog ud) {

		addTagBtn = f.getAddTagBtn();
		deleteTagBtn = f.getBtnDelete();
		table = f.getTagDialogTable();
		this.tdf = td.getTdf();
		this.udf = ud.getUdf();

		DefaultTableModel model = (DefaultTableModel) table.getModel();
		tags = tdf.getTags();

		for (Tag t : tags) {
			model.addRow(new String[] { Integer.toString(++counter), t.getName(), t.getThreshold() + "" });
		}

		addTagBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int index = table.getSelectedRow();
				if (index < 0) {
					JOptionPane.showMessageDialog(f, "No row selected!");
					return;
				}
				String t = (String) table.getModel().getValueAt(index, 1);
				Tag tag = getTagByName(t);
				
				BufferedWriter bw = null;
				try {
					bw = new BufferedWriter(new FileWriter(files, false));
				} catch (IOException e1) {
					System.out.println(e1.getMessage());
				}

				for (DocumentFolder folder : udf.getFolders()) {
					for (Document file : folder.getFiles()) {
						if ((file.getPath()).equals(udf.getFilePath())) {
							file.addUserTag(tag);
							file.setUserClassified(true);
							tag.addFile(file);
							if ( file.isUserClassified()) {
								try {
									bw.write(file.toString());
								} catch (IOException e1) {
									System.out.println(e1.getMessage());
								}
							}
							System.out.println("File after assignment " + file.toString());
							Classifier c = new Classifier(tdf);
							c.addDictionaryToTag(tag, file);
							// System.out.println(tag.toString());
						}
					}
				}

				try {
					bw.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				udf.getTableModel().fireTableDataChanged();
			}
		});

		deleteTagBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int index = table.getSelectedRow();
				if (index < 0) {
					JOptionPane.showMessageDialog(f, "No row selected!");
					return;
				}
				String t = (String) table.getModel().getValueAt(index, 1);
				Tag tag = getTagByName(t);

				for (DocumentFolder folder : udf.getFolders()) {
					for (Document file : folder.getFiles()) {
						if ((file.getPath()).equals(udf.getFilePath())) {
							if(file.getTags().contains(tag)){
								file.removeTag(tag);
								file.setUserClassified(true);
								tag.removeFile(file);
								Classifier c = new Classifier(tdf);
								c.removeDictionaryFromTag(tag, file);
							}else{
								JOptionPane.showMessageDialog(f, "This tag is not asigned to file!");
							}
							System.out.println("File after assignment " + file.toString());
						}
					}
				}

				udf.getTableModel().fireTableDataChanged();
			}
		});

	}

	public ArrayList<Tag> getTags() {
		return tags;
	}

	public Tag getTagByName(String t) {
		for (Tag tag : tags) {
			if (t.equals(tag.getName()))
				return tag;
		}
		return null;
	}
}
