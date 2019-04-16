package src.gui_functionality;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class ListOfTagsDialogFunc {
	private JButton addTagBtn = new JButton();
	private JTable table = new JTable();
	private int counter = 0;
	private ArrayList<Tag> tags = new ArrayList<>();
	private TagDialogFunc tdf;
	private UserAssignDialogFunc udf;
	
	
	public ListOfTagsDialogFunc(ListOfTagsDialog f,TagDialog td,UserAssignDialog ud){
		
		addTagBtn = f.getAddTagBtn();
		table = f.getTagDialogTable();
		this.tdf=td.getTdf();
		this.udf=ud.getUdf();
		
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		tags = tdf.getTags();
		
		for(Tag t:tags){
			model.addRow(new String[] { Integer.toString(++counter), t.getName(),t.getThreshold()+""});
		}
		
		addTagBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int index = table.getSelectedRow();
				if(index < 0) {
					JOptionPane.showMessageDialog(f, "No row selected!");
					return;
				}
				String t=(String) table.getModel().getValueAt(index, 1);
				Tag tag=getTagByName(t);
				
				for(DocumentFolder folder:udf.getFolders()){
					for(Document file: folder.getFiles()){
						if((file.getPath()).equals(udf.getFilePath())){
							file.addUserTag(tag);
							file.setUserClassified(true);
							System.out.println(file.toString());
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

	public Tag getTagByName(String t){
		for(Tag tag:tags){
			if(t.equals(tag.getName()))
				return tag;
		}
		return null;
	}
}
