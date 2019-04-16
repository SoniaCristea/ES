package src.main;

import java.io.File;
import java.io.IOException;
import src.gui_swing.Menu;

public class Main {
	
	static File jsonFile = new File("json.txt");
	
	public static void main(String[] args) throws IOException{
		
//		BufferedWriter bw = new BufferedWriter(new FileWriter(jsonFile));
//		ArrayList<JSONtoObject> jsonFileContent = new ArrayList<>();
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
////		}
//		
//		Asa am testat creator si parser de JSON
//		
//		Tag t = new Tag("Flower", 2);
//		Tag t1 = new Tag("Bumblebee", 3);
//		Document doc = new Document("Botanic", "C:\\Desktop", true);
//		ArrayList<Tag> tagList = new ArrayList<>();
//		ArrayList<Tag> userList = new ArrayList<>();
//		tagList.add(t);
//		tagList.add(t1);
//		doc.setTags(tagList);
//		doc.setUserSelectedTags(userList);
//		
//		MyJSONobjCreator jo1 = new MyJSONobjCreator(doc, bw);
//		
//		MyJSONParser myParser = new MyJSONParser();
//		
//		jsonFileContent = myParser.parseJSONFile(jsonFile);
//		System.out.println(jsonFileContent.toString()); 
//		
//	
//		bw.close();
		
		 new Menu();
	}

}

