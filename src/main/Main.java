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
import java.lang.reflect.Array;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import extensions.Document;
import extensions.JSONtoObject;
import extensions.Tag;
import util.Classifier;
import util.Crawler;
import util.MyJSONobjCreator;
import util.MyJSONParser;

public class Main {
	
	static File jsonFile = new File("json.txt");
	
	
	public static void main(String[] args) throws IOException{
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(jsonFile));
		ArrayList<JSONtoObject> jsonFileContent = new ArrayList<>();
//		
//		Crawler crawler = new Crawler();
//		Classifier classifier = new Classifier();
//		
//		URL url = null;
//		String stringURL = null;
//		
//		try {
//			url = new URL("https://en.wikipedia.org/wiki");
//			stringURL = url.toString() + "Toy"; //instead of Toy, set tag name
//		} catch (MalformedURLException e) {
//			System.out.println(e.getMessage());
//		}
//		
//		if ( crawler.retrieveHTMLBody(stringURL)){
//			classifier.classify();
//		}
		
		/* Asa am testat creator si parser de JSON
		Tag t = new Tag("Flower", 2);
		Tag t1 = new Tag("Bumblebee", 3);
		Document doc = new Document("Botanic", "C:\\Desktop", true);
		ArrayList<Tag> tagList = new ArrayList<>();
		ArrayList<Tag> userList = new ArrayList<>();
		tagList.add(t);
		tagList.add(t1);
		doc.setTags(tagList);
		doc.setUserSelectedTags(userList);
		
		MyJSONobjCreator jo2 = new MyJSONobjCreator(doc,bw);
		
		MyJSONParser myParser = new MyJSONParser();
		
		jsonFileContent = myParser.parseJSONFile(jsonFile);
		System.out.println(jsonFileContent.toString());
		*/
		
		bw.close();
		
	}
	
}

