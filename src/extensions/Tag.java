package src.extensions;
import java.util.ArrayList;

public class Tag {

	private String name;
	private int threshold;
	private ArrayList<Document> files;
	private int timesOfClassification;
	private ArrayList<String> dictionary;
	
	public Tag(String name, int threshold) {
		super();
		this.name = name;
		this.threshold = threshold;
		files=new ArrayList<>();
		timesOfClassification = 0;
		dictionary=new ArrayList<>();
	}

	
	public int getTimesOfClassification() {
		return timesOfClassification;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getThreshold() {
		return threshold;
	}

	public void setThreshold(int threshold) {
		this.threshold = threshold;
	}

	public ArrayList<Document> getFiles() {
		return files;
	}

	public void setFiles(ArrayList<Document> files) {
		this.files = files;
	}
	
	public ArrayList<String> getDictionary() {
		return dictionary;
	}


	public void addWordToDictionary(String word){
		dictionary.add(word);
	}
	
	public void removeWordFromDictionary(String word){
		dictionary.remove(word);
	}
	
	
	public void addFile(Document f){
		files.add(f);
	}
	
	public void removeFile(Document f){
		files.remove(f);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + threshold;
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
		Tag other = (Tag) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (threshold != other.threshold)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Tag [name=" + name + ", threshold=" + threshold + ", dictionary=" + dictionary + "]";
	}
	
	
}
