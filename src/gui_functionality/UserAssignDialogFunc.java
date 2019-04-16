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
import src.gui_swing.FolderDialog;
import src.gui_swing.ListOfTagsDialog;
import src.gui_swing.TagDialog;
import src.gui_swing.UserAssignDialog;

public class UserAssignDialogFunc {
	private JButton addFolderBtn = new JButton();
	private JTable table = new JTable();

	private ArrayList<DocumentFolder> folders;
	private int counter = 0;
	private FolderDialogFunc f;
	private TagDialogFunc td;
	private String filePath;

public UserAssignDialogFunc(UserAssignDialog fd,FolderDialog f,TagDialog td) {

	this.f = f.getFdf();
	this.td=td.getTdf();
	addFolderBtn = fd.getAddFolderBtn();
	table = fd.getTable();
	folders = new ArrayList<>();
	filePath="";

	init();

	addFolderBtn.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			int index = table.getSelectedRow();
			if(index < 0) {
				JOptionPane.showMessageDialog(fd, "No row selected!");
				return;
			}

			filePath=(String) table.getModel().getValueAt(index, 1);
			new ListOfTagsDialog(fd,td);

		}

	});

}



	public void init() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		
		folders=f.getFolders();
		for(DocumentFolder ff: folders){
			for(Document d:ff.getFiles()){
				String s="";
				for(Tag t : d.getTags()){
					s+=t.getName()+" ";
				}
				
				String userTag="";
				for(Tag t : d.getUserSelectedTags()){
					userTag+=t.getName()+" ";
				}
				model.addRow(new String[] { Integer.toString(++counter), d.getPath(), s, userTag });
				
			}
		}
}



	public DefaultTableModel getTableModel(){
		return (DefaultTableModel) table.getModel();
	}
	public ArrayList<DocumentFolder> getFolders() {
		return folders;
	}



	public String getFilePath() {
		return filePath;
	}
}
