package extensions;

import java.util.ArrayList;

public class DocumentFolder {

	private String name;
	private String fullPath;
	private boolean considerSubfolders;
	private ArrayList<Document> files;

	public DocumentFolder(String name,String fullPath,boolean considerSubfolders) {
		super();
		this.name = name;
		this.fullPath=fullPath;
		this.considerSubfolders=considerSubfolders;
	}
	
	public DocumentFolder(String name,String fullPath) {
		super();
		this.name = name;
		this.fullPath=fullPath;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFullPath() {
		return fullPath;
	}

	public void setFullPath(String fullPath) {
		this.fullPath = fullPath;
	}

	public ArrayList<Document> getFiles() {
		return files;
	}

	public void setFiles(ArrayList<Document> files) {
		this.files = files;
	}

	public boolean isConsiderSubfolders() {
		return considerSubfolders;
	}

	public void setConsiderSubfolders(boolean considerSubfolders) {
		this.considerSubfolders = considerSubfolders;
	}

	@Override
	public String toString() {
		return "DocumentFolder [name=" + name + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fullPath == null) ? 0 : fullPath.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DocumentFolder other = (DocumentFolder) obj;
		if (fullPath == null) {
			if (other.fullPath != null)
				return false;
		} else if (!fullPath.equals(other.fullPath))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
}
