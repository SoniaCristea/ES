package src.util;

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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import src.extensions.Document;
import src.extensions.Tag;

public class MyJSONobjCreator {

	private JSONObject object;
	private BufferedWriter bw;
	private Document doc;
	private JSONArray jsonArray = new JSONArray();


	public MyJSONobjCreator(Document doc, BufferedWriter bw) {

		object = new JSONObject();
		this.bw = bw;
		this.doc = doc;
		
		object.put("folder name", doc.getName());
		object.put("user classified tags", doc.getUserSelectedTags());
		
		jsonArray = getTagsTreshold(doc);
		object.put("tag list", jsonArray);
		writeObjToFile();
	}

	private JSONArray getTagsTreshold(Document doc) {
		
		Iterator<Tag> it = doc.getTags().iterator();
		JSONArray array = new JSONArray();
		JSONObject obj = new JSONObject();
		
		while(it.hasNext()){
			Tag t = it.next();
			//tagTreshold.put(t.getName(), treshold);
			obj.put("name: "+ t.getName(),"treshold: "+ t.getThreshold());
		}
		array.add(obj);
		
		return array;
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
