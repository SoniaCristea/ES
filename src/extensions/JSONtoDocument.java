package src.extensions;

import java.util.ArrayList;

public class JSONtoDocument {
	
	private String folderName;
	private ArrayList<Tag> userSelectedTags;
	
	public JSONtoDocument(String folderName, ArrayList<Tag> userSelectedTags) {
		
		this.folderName = folderName;
		this.userSelectedTags = userSelectedTags;
	}

	public String getFolderName() {
		return folderName;
	}


	public ArrayList<Tag> getUserSelectedTags() {
		return userSelectedTags;
	}

	@Override
	public String toString() {
		return "Folder [folderName=" + folderName  + ", userSelectedTags="
				+ userSelectedTags + "]";
	}
	
	
}