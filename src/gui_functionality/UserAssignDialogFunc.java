package src.gui_functionality;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import src.extensions.Document;
import src.extensions.DocumentFolder;
import src.extensions.Tag;
import src.gui_swing.FolderDialog;
import src.gui_swing.ListOfTagsDialog;
import src.gui_swing.TagDialog;
import src.gui_swing.UserAssignDialog;
import src.util.FileSearcher;

public class UserAssignDialogFunc {
//	private JCheckBox considerSubfoldersCB = new JCheckBox();
//	private JTextField folderNameTxt = new JTextField();
	private JButton addFolderBtn = new JButton();
	private JTable table = new JTable();

	private ArrayList<DocumentFolder> folders;
	private int counter = 0;
	private File selectedFolder;
	private boolean subfoldersConsidered;
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
//			String str = selectedFolder.toString();
//			System.out.println(str);
//			String folderName = str.substring(str.lastIndexOf('\\') + 1, str.length());

//			folderNameTxt.setText(folderName + " - " + str);

//			DocumentFolder folder = new DocumentFolder(folderName, str, subfoldersConsidered);
//			if (!folders.contains(folder)) {
//				folders.add(folder);
//				FileSearcher fileSearcher = new FileSearcher();
//				if (subfoldersConsidered) {
//					fileSearcher.searchInFolderRecursively(str);
//				} else {
//					fileSearcher.searchInFolder(str);
//				}
//				folder.setFiles(fileSearcher.getTxtFiles());
//		
//				DefaultTableModel model = (DefaultTableModel) table.getModel();
//				model.addRow(new String[] { Integer.toString(++counter), folderName });
//			}

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
