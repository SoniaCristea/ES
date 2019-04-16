package src.util;

import java.io.BufferedWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import src.extensions.Document;
import src.extensions.Tag;

public class JSONtagCreator {
	
	private JSONObject object;
	private BufferedWriter bw;
	private Tag tag;
	private JSONArray jsonArray = new JSONArray();
	
	public JSONtagCreator(Tag tag, BufferedWriter bw) {
		
		object = new JSONObject();
		this.tag = tag;
		this.bw = bw;
		
		object.put("name", tag.getName());
		object.put("treshold", Integer.toString(tag.getThreshold()));
		
		writeObjToFile();
		
	}
	
	public void writeObjToFile() {

		try {

			bw.write(object.toString());
			bw.newLine();
			bw.flush();

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

}
