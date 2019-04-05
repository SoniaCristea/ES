package extensions;

public class JSONtoObject {
	
	private String considerSubfolder;
	private String name;
	
	public JSONtoObject(String considerSubfolder, String name) {
		
		this.considerSubfolder = considerSubfolder;
		this.name = name;
	}

	public String getConsiderSubfolder() {
		return considerSubfolder;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "JSONtoObject [considerSubfolder=" + considerSubfolder + ", name=" + name + "]";
	}
	
	

}
