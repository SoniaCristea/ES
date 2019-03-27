package main;

import java.net.MalformedURLException;
import java.net.URL;

import util.Classifier;
import util.Crawler;

public class Main {
	
	public static void main(String[] args){
		
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
	}
}

