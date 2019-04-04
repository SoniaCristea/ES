package extensions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONObj {

	private JSONObject object;
	private static File file = new File("json.txt");

	public JSONObj(String name, String considerSubfolders) {

		object = new JSONObject();
		object.put("name", name);
		object.put("considerSubfolder", considerSubfolders);
		writeObjToFile();

	}
	

	public void writeObjToFile() {

		try {
			PrintWriter pw = new PrintWriter(file);
			pw.write(this.object.toString());

			pw.flush();
			pw.close();

		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	public HashMap<String, String> parseJSONobject(){

		Object obj = null;
		try {
			obj = new JSONParser().parse(new FileReader(file));
		} catch (IOException | ParseException e) {
			System.out.println(e.getMessage());
		}
		JSONObject jo = (JSONObject) obj;
		HashMap<String, String> fields = new HashMap<>();
		
        String name = (String) jo.get("name"); 
        String considerSubfolder = (String) jo.get("considerSubfolder"); 
        fields.put("considerSubfolders", considerSubfolder);
        fields.put("name", name);

		return fields;

	}

}
