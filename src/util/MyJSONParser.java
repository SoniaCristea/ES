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
				JSONtoObject jto = new JSONtoObject(jo.get("considerSubfolder").toString(), jo.get("name").toString());
				list.add(jto);
			}
		} catch (IOException | ParseException e) {
			System.out.println(e.getMessage());
		}

		return list;

	}

}
