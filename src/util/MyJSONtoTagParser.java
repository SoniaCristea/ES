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

import src.extensions.JSONtoTag;

public class MyJSONtoTagParser {
	
	public ArrayList<JSONtoTag> parseFile(File file){
		
		BufferedReader br = null;
		String line = null;
		JSONObject jo = null;
		ArrayList<JSONtoTag> list = new ArrayList<>();
		
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			
			while ((line = br.readLine()) != null) {

				line = line.trim();
				jo = (JSONObject) new JSONParser().parse(line);
				
				String tagName = (String)jo.get("name");
				String treshold =  (String) jo.get("treshold");
				
				JSONtoTag jtt = new JSONtoTag(tagName, treshold);
				list.add(jtt);
			}
		} catch (IOException | ParseException e) {
			System.out.println(e.getMessage());
		}
		
		return list;
		
	}

}
