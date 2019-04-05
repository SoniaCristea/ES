package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import extensions.JSONObj;
import util.Classifier;
import util.Crawler;

public class Main {
	
	static File jsonFile = new File("json.txt");
	
	public static void main(String[] args) throws IOException{
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(jsonFile));
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
		
		JSONObj jo1 = new JSONObj("Exam", "no",bw);
		JSONObj jo2 = new JSONObj("Projects", "yes",bw);
		
//		HashMap<String, String> parseJSONobject = jo1.parseJSONobject(jsonFile);
//		System.out.println(parseJSONobject);
		
		parseJSONFile(jsonFile);
		bw.close();
		
	}
	
	private static void parseJSONFile(File file){
		

		HashMap<String, String> fields = new HashMap<>();
		BufferedReader br = null;
		String line = null;
		String[] splits = null;

		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			while ((line = br.readLine()) != null) {
				
				line.trim();
				//TODO parse the lines accordingly

			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}
}

