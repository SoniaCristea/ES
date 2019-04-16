package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import extensions.JSONtoObject;
import extensions.Tag;

public class MyJSONParser {

	public ArrayList<JSONtoObject> parseJSONFile(File file) {

		BufferedReader br = null;
		String line = null;
		JSONObject jo = null;
		ArrayList<JSONtoObject> list = new ArrayList<>();

		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));

			while ((line = br.readLine()) != null) {

				line = line.trim();
				jo = (JSONObject) new JSONParser().parse(line);
				
				String folderName = (String)jo.get("folder name");
				ArrayList<Tag> userAssignedTags = (ArrayList<Tag>) jo.get("user assigned tags");
				ArrayList<Tag> tagList = (ArrayList<Tag>) jo.get("tag list");
				
				JSONtoObject jto = new JSONtoObject(folderName, userAssignedTags, tagList);
				list.add(jto);
			}
		} catch (IOException | ParseException e) {
			System.out.println(e.getMessage());
		}

		return list;

	}

}
