package src.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import src.extensions.JSONtoDocument;
import src.extensions.Tag;

public class MyJSONtoDocParser {

	public ArrayList<JSONtoDocument> parseJSONFile(File file) {

		BufferedReader br = null;
		String line = null;
		JSONObject jo = null;
		ArrayList<JSONtoDocument> list = new ArrayList<>();

		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));

			while ((line = br.readLine()) != null) {

				line = line.trim();
				jo = (JSONObject) new JSONParser().parse(line);
				
				String folderName = (String)jo.get("folder name");
				ArrayList<Tag> userAssignedTags = (ArrayList<Tag>) jo.get("user assigned tags");
				
				JSONtoDocument jto = new JSONtoDocument(folderName, userAssignedTags);
				list.add(jto);
			}
		} catch (IOException | ParseException e) {
			System.out.println(e.getMessage());
		}

		return list;

	}

}
