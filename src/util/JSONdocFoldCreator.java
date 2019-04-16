package src.util;

import java.io.BufferedWriter;
import java.io.IOException;

import org.json.simple.JSONObject;

import src.extensions.DocumentFolder;



public class JSONdocFoldCreator {

	private JSONObject object;
	private BufferedWriter bw;
	private DocumentFolder doc;


	public JSONdocFoldCreator(DocumentFolder doc, BufferedWriter bw) {

		object = new JSONObject();
		this.bw = bw;
		this.doc = doc;
		
		object.put("folder name", doc.getName());
		
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
