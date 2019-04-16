package src.gui_functionality;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import src.extensions.Tag;
import src.gui_swing.FilesForTagDialog;
import src.gui_swing.FolderDialog;
import src.gui_swing.TagDialog;
import src.gui_swing.TagsForFileDialog;

public class TagsForFileDialogFunc {
	private JButton addFolderBtn = new JButton();
	private JTable table = new JTable();

	private ArrayList<Tag> tags;
	private int counter = 0;
	private FolderDialogFunc f;
	private TagDialogFunc td;
	private String tagName;

public TagsForFileDialogFunc(TagsForFileDialog fd,FolderDialog f,TagDialog td) {

	this.f = f.getFdf();
	this.td=td.getTdf();
	addFolderBtn = fd.getAddFolderBtn();
	table = fd.getTable();
	tags = new ArrayList<>();
	tagName="";

	init();

	addFolderBtn.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			int index = table.getSelectedRow();
			if(index < 0) {
				JOptionPane.showMessageDialog(fd, "No row selected!");
				return;
			}

			tagName=(String) table.getModel().getValueAt(index, 1);
			new FilesForTagDialog(fd,td);
		//	ListOfTagsDialog ltd= new ListOfTagsDialog(fd,td);

		}

	});

}



	public void init() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		
		tags=td.getTags();
		
		for(Tag t: tags){
			model.addRow(new String[] { Integer.toString(++counter), t.getName() });
		}
}



	public DefaultTableModel getTableModel(){
		return (DefaultTableModel) table.getModel();
	}
	public ArrayList<Tag> getTags() {
		return tags;
	}



	public String getTagName() {
		return tagName;
	}
}
