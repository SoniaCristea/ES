package src.gui_functionality;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import src.extensions.DocumentFolder;
import src.gui_swing.FolderDialog;
import src.util.FileSearcher;

public class FolderDialogFunc {

	private JCheckBox considerSubfoldersCB = new JCheckBox();
	private JTextField folderNameTxt = new JTextField();
	private JButton addFolderBtn = new JButton();
	private JTable table = new JTable();

	private ArrayList<DocumentFolder> folders;
	private int counter = 0;
	private File selectedFolder;
	private boolean subfoldersConsidered;
	private static File folderFile = new File("folders.txt");
	

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
				System.out.println(str);
				String folderName = str.substring(str.lastIndexOf('\\') + 1, str.length());

				folderNameTxt.setText(folderName + " - " + str);

				DocumentFolder folder = new DocumentFolder(folderName, str, subfoldersConsidered);
				if (!folders.contains(folder)) {
					folders.add(folder);
					FileSearcher fileSearcher = new FileSearcher();
					if (subfoldersConsidered) {
						fileSearcher.searchInFolderRecursively(str);
					} else {
						fileSearcher.searchInFolder(str);
					}
					folder.setFiles(fileSearcher.getTxtFiles());
			
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					model.addRow(new String[] { Integer.toString(++counter), folderName });
					writeFoldersToFile();
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

	public ArrayList<DocumentFolder> getFolders() {
		return folders;
	}

	private void writeFoldersToFile() {

		BufferedWriter bw = null;
		
		try {
			bw = new BufferedWriter(new FileWriter(folderFile, true));
			
			for(DocumentFolder doc : folders) {
				bw.write(doc.toString());
			}
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
