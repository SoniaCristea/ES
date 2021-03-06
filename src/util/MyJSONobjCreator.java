package src.util;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

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
