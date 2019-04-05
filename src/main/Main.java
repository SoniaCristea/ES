package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import extensions.JSONObj;
import extensions.JSONtoObject;
import util.Classifier;
import util.Crawler;

public class Main {
	
	static File jsonFile = new File("json.txt");
	
	
	public static void main(String[] args) throws IOException{
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(jsonFile));
		ArrayList<JSONtoObject> jsonFileContent = new ArrayList<>();
		
		Crawler crawler = new Crawler();
		Classifier classifier = new Classifier();
		
		URL url = null;
		String stringURL = null;
		
		try {
			url = new URL("https://en.wikipedia.org/wiki");
			stringURL = url.toString() + "Toy"; //instead of Toy, set tag name
		} catch (MalformedURLException e) {
			System.out.println(e.getMessage());
		}
		
		if ( crawler.retrieveHTMLBody(stringURL)){
			classifier.classify();
		}
		
		JSONObj jo1 = new JSONObj("Exam", "no",bw);
		JSONObj jo2 = new JSONObj("Projects", "yes",bw);
		
		jsonFileContent = parseJSONFile();
		System.out.println(jsonFileContent);
		
		bw.close();
	}
	
	private static ArrayList<JSONtoObject> parseJSONFile(){
		
		BufferedReader br = null;
		String line = null;
		JSONObject jo = null;
		ArrayList<JSONtoObject> list = new ArrayList<>();
		
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(jsonFile)));
			
			while((line = br.readLine())!=null){
				
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

