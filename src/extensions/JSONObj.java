package extensions;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONObj {

	private JSONObject object;
	private BufferedWriter bw;


	public JSONObj(String name, String considerSubfolders, BufferedWriter bw) {

		object = new JSONObject();
		this.bw = bw;
		object.put("name", name);
		object.put("considerSubfolder", considerSubfolders);
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

	public void parseJSONobject(File file) {

		//return fields;

	}
}
