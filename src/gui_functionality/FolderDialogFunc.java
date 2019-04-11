package gui_functionality;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import extensions.DocumentFolder;
import gui_swing.FolderDialog;

public class FolderDialogFunc {
	
	private FolderDialog fd;
	private int counter = 0;
	private JCheckBox considerSubfoldersCB = new JCheckBox();
	private JTextField folderNameTxt = new JTextField();
	private JButton addFolderBtn = new JButton();
	private JTable table = new JTable();
	private boolean considerSubfolders = false;
	private ArrayList<DocumentFolder> folders;
	
	public FolderDialogFunc(FolderDialog fd){
		
		this.fd = fd;
		
		considerSubfoldersCB = fd.getConsiderSubfoldersCB();
		folderNameTxt = fd.getFolderNameTxt();
		addFolderBtn = fd.getAddFolderBtn();
		table = fd.getTable();
		folders = new ArrayList<>();
		
		if (considerSubfoldersCB.isSelected()){
			considerSubfolders = true;
		}else{
			considerSubfolders = false;
		}
		
		addFolderBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String folderName = folderNameTxt.getText();
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				DocumentFolder folder = new DocumentFolder(folderName);
				folders.add(folder);
				model.addRow(new String[]{Integer.toString(counter), folderName});
				counter++;
				folderNameTxt.setText("");
				
			}
		});
		
	}

}
