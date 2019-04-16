package src.extensions;

public class JSONtoTag {

	private String name;
	private String treshold;
	
	public JSONtoTag(String name, String treshold) {
		
		this.name = name;
		this.treshold = treshold;
	}

	public String getName() {
		return name;
	}

	public String getTreshold() {
		return treshold;
	}
	
	
}
