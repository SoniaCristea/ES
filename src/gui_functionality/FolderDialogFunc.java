package gui_functionality;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.JTextField;

import gui_swing.FolderDialog;

public class FolderDialogFunc {
	
	private FolderDialog fd;
	private JCheckBox considerSubfoldersCB = new JCheckBox();
	private JTextField folderNameTxt = new JTextField();
	private JButton addFolderBtn = new JButton();
	private JTable table = new JTable();
	
	public FolderDialogFunc(FolderDialog fd){
		
		this.fd = fd;
		
		considerSubfoldersCB = fd.getConsiderSubfoldersCB();
		folderNameTxt = fd.getFolderNameTxt();
		addFolderBtn = fd.getAddFolderBtn();
		table = fd.getTable();
		
		//TODO
	}

}
