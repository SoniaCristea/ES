package src.gui_functionality;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import src.extensions.Document;
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
					classify(folder);
			
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

	public ArrayList<DocumentFolder> getFolders() {
		return folders;
	}

	private void classify(DocumentFolder folder) {
		ArrayList<Document> list = folder.getFiles();
		ArrayList<String> words=initReadWords();

		for (Document d : list) {
			Scanner lineScanner = null;
			BufferedWriter writer=null;
			try {
				lineScanner = new Scanner(new File(d.getPath()));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			while (lineScanner.hasNextLine()) {
				Scanner wordScanner = new Scanner(lineScanner.nextLine());
				String sentence="";
				while (wordScanner.hasNext()) {
					String s = wordScanner.next();
					s=removePunctuation(s);
					if(!words.contains(s)){
						try {
							writer = new BufferedWriter(new FileWriter("temp.txt"));
							sentence+=s+" ";
							writer.write(sentence);
						//	System.out.println(s);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				try {
					writer.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	//read from file words.txt the words to be removed 
	private ArrayList<String> initReadWords() {
		ArrayList<String> words = new ArrayList<>();
		Scanner lineScanner = null;
		try {
			lineScanner = new Scanner(new File("words.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while (lineScanner.hasNextLine()) {
			Scanner wordScanner = new Scanner(lineScanner.nextLine());
			while (wordScanner.hasNext()) {
				String s = wordScanner.next();
				words.add(s);
				//System.out.println(s);
			}
		}
		return words;
	}
	
	public static String removePunctuation(String word) {
		String[] punctuations = { "(", ",", ".", "/", "<", ">", "?", ";", "'", ":", "\"", "[", "]", "{", "}", //
				"`", "~", "!", ")", "-", "_" };

		String newWord = word;
		for (int i = 0; i < punctuations.length; i++) {
			if (word.startsWith(punctuations[i])) {
				newWord = removePunctuation(word.substring(1));
			}

			if (word.endsWith(punctuations[i])) {
				newWord = removePunctuation(word.substring(0, word.length() - 1));
			}
		}

		return newWord.toLowerCase();
	}

}
