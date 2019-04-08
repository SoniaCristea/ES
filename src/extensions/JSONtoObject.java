package extensions;

import java.util.ArrayList;

public class JSONtoObject {
	
	private String folderName;
	private ArrayList<Tag> tagList;
	private ArrayList<Tag> userSelectedTags;
	
	public JSONtoObject(String folderName, ArrayList<Tag> tagList, ArrayList<Tag> userSelectedTags) {
		
		this.folderName = folderName;
		this.tagList = tagList;
		this.userSelectedTags = userSelectedTags;
	}

	public String getFolderName() {
		return folderName;
	}

	public ArrayList<Tag> getTagList() {
		return tagList;
	}

	public ArrayList<Tag> getUserSelectedTags() {
		return userSelectedTags;
	}

	@Override
	public String toString() {
		return "Folder [folderName=" + folderName + ", tagList=" + tagList + ", userSelectedTags="
				+ userSelectedTags + "]";
	}
	
	
}