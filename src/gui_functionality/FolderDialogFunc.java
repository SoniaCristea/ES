package gui_functionality;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import extensions.Document;
import extensions.DocumentFolder;
import gui_swing.FolderDialog;

public class FolderDialogFunc {

	private JCheckBox considerSubfoldersCB = new JCheckBox();
	private JTextField folderNameTxt = new JTextField();
	private JButton addFolderBtn = new JButton();
	private JTable table = new JTable();

	private ArrayList<Document> folders;
	private int counter = 0;
	private File selectedFolder;
	private boolean subfoldersConsidered;

	public FolderDialogFunc(FolderDialog fd) {

		considerSubfoldersCB = fd.getConsiderSubfoldersCB();
		folderNameTxt = fd.getFolderNameTxt();
		addFolderBtn = fd.getAddFolderBtn();
		table = fd.getTable();
		folders = new ArrayList<>();

		if (considerSubfoldersCB.isSelected()) {
			subfoldersConsidered = true;
		} else {
			subfoldersConsidered = false;
		}

		addFolderBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				createChooser(fd);
				String str = selectedFolder.toString();
				String folderName = str.substring(str.lastIndexOf('\\') + 1, str.length());

				folderNameTxt.setText(folderName + " - " + str);
				Document doc = new Document(folderName, str, subfoldersConsidered);
				if (!folders.contains(doc)) {
					folders.add(doc);
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					model.addRow(new String[] { Integer.toString(++counter), folderName });
				}

				
			}
		});
		

	}


	private void createChooser(FolderDialog fd) {

		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setCurrentDirectory(new File("."));
		fileChooser.setDialogTitle("Choose folder");
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		fileChooser.setAcceptAllFileFilterUsed(false);

		if (fileChooser.showOpenDialog(fd) == JFileChooser.APPROVE_OPTION) {
			selectedFolder = fileChooser.getSelectedFile();
		} else if (fileChooser.showOpenDialog(fd) == JFileChooser.CANCEL_OPTION) {
			fileChooser.setVisible(false);
		}
	}

	public ArrayList<Document> getFolders() {
		return folders;
	}

}
