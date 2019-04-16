package util;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


import extensions.Document;

public class FileSearcher {

	private ArrayList<Document> txtFiles;

	public FileSearcher() {
		super();
	}

	public ArrayList<Document> searchInFolderRecursively(String folderr) {
		txtFiles = new ArrayList<>();

		File folder = new File(folderr);

		if (folder.isDirectory()) {
			File[] listOfFiles = folder.listFiles();
			if (listOfFiles.length < 1)
				System.out.println("There is no File inside Folder");
			else
				System.out.println("List of Files & Folder");
			for (File file : listOfFiles) {
				if (!file.isDirectory() && file.getName().endsWith(".txt")) {
					try {
						System.out.println(file.getCanonicalPath().toString());
						txtFiles.add(new Document(file.getName(), file.getCanonicalPath().toString(), false));
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else if (file.isDirectory()) {
					try {
						searchInFolderRecursively(file.getCanonicalPath().toString());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		} else
		{
			System.out.println("There is no Folder @ given path :" + folderr);
		}
		return txtFiles;

	}

	public ArrayList<Document> searchInFolder(String folderr) {
		txtFiles = new ArrayList<>();

		File folder = new File(folderr);

		if (folder.isDirectory()) {
			File[] listOfFiles = folder.listFiles();
			if (listOfFiles.length < 1)
				System.out.println("There is no File inside Folder");
			else
				System.out.println("List of Files & Folder");
			for (File file : listOfFiles) {
				if (!file.isDirectory() && file.getName().endsWith(".txt")) {
					try {
						System.out.println(file.getCanonicalPath().toString());
						txtFiles.add(new Document(file.getName(), file.getCanonicalPath().toString(), false));
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}
		} else{
			System.out.println("There is no Folder @ given path :" + folderr);
		}
		return txtFiles;

	}

	public ArrayList<Document> getTxtFiles() {
		return txtFiles;
	}

	public void setTxtFiles(ArrayList<Document> txtFiles) {
		this.txtFiles = txtFiles;
	}

}
