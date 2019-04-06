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

import extensions.JSONtoObject;
import util.Classifier;
import util.Crawler;
import util.MyJSONobjCreator;
import util.MyJSONParser;

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
		
		MyJSONobjCreator jo1 = new MyJSONobjCreator("Exam", "no",bw);
		MyJSONobjCreator jo2 = new MyJSONobjCreator("Projects", "yes",bw);
		
		MyJSONParser myParser = new MyJSONParser();
		
		jsonFileContent = myParser.parseJSONFile(jsonFile);
		System.out.println(jsonFileContent);
		
		bw.close();
	}
	
	
}

