package src.extensions;
import java.util.ArrayList;

public class Document {
	private String name;
	private String path;
	private ArrayList<Tag> tags;
	private boolean isUserClassified;
	private ArrayList<Tag> userSelectedTags;
	
	public Document(String name, String path, boolean isUserClassified) {
		super();
		this.name = name;
		this.path = path;
		this.tags = new ArrayList<>();
		this.isUserClassified = isUserClassified;
		this.userSelectedTags =  new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public ArrayList<Tag> getTags() {
		return tags;
	}

	public void setTags(ArrayList<Tag> tags) {
		this.tags = tags;
	}

	public boolean isUserClassified() {
		return isUserClassified;
	}

	public void setUserClassified(boolean isUserClassified) {
		this.isUserClassified = isUserClassified;
	}

	public ArrayList<Tag> getUserSelectedTags() {
		return userSelectedTags;
	}

	public void setUserSelectedTags(ArrayList<Tag> userSelectedTags) {
		this.userSelectedTags = userSelectedTags;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (isUserClassified ? 1231 : 1237);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((path == null) ? 0 : path.hashCode());
		result = prime * result + ((tags == null) ? 0 : tags.hashCode());
		result = prime * result + ((userSelectedTags == null) ? 0 : userSelectedTags.hashCode());
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
		Document other = (Document) obj;
		if (isUserClassified != other.isUserClassified)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (path == null) {
			if (other.path != null)
				return false;
		} else if (!path.equals(other.path))
			return false;
		if (tags == null) {
			if (other.tags != null)
				return false;
		} else if (!tags.equals(other.tags))
			return false;
		if (userSelectedTags == null) {
			if (other.userSelectedTags != null)
				return false;
		} else if (!userSelectedTags.equals(other.userSelectedTags))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Document [name=" + name + ", path=" + path + ", tags=" + tags + ", isUserClassified=" + isUserClassified
				+ ", userSelectedTags=" + userSelectedTags + "]";
	}
	
	public void addUserTag(Tag t){
		userSelectedTags.add(t);
	}
	
	public void addTag(Tag t){
		tags.add(t);
	}
}
