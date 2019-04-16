package src.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import src.extensions.Document;
import src.extensions.DocumentFolder;
import src.extensions.Tag;
import src.gui_functionality.TagDialogFunc;
import src.gui_swing.TagDialog;

public class Classifier {

	private List<String> wordsList = new ArrayList<String>();
	private List<String> fileList = new ArrayList<String>();
	private File file = new File("out.txt");
	private File wordsFile = new File("words.txt");
	private ArrayList<String> words=new ArrayList<>();
	private TagDialogFunc tdf;
	private HashMap<Tag,Integer> tagAppearances=new HashMap<>();
	private ArrayList<Tag> allTags=new ArrayList<>();
	
	public Classifier(TagDialogFunc tdf){
		words=initReadWords();
		this.tdf=tdf;
		allTags=tdf.getTags();
	}
	public Classifier(){
		words=initReadWords();
		this.tdf=tdf;
		allTags=tdf.getTags();
	}
	//removable words

	public void classify() {
		
//		BufferedReader reader = null;
//		BufferedReader wordsReader = null;
//
//		try {
//			wordsReader = new BufferedReader(new FileReader(wordsFile));
//			String words = null;
//
//			while ((words = wordsReader.readLine()) != null) {
//				wordsList.add(words);
//			}
//
//			reader = new BufferedReader(new FileReader(file));
//			String text = null;
//
//			while ((text = reader.readLine()) != null) {
//				Scanner s2 = new Scanner(text);
//				while (s2.hasNext()) {
//					String ss = s2.next();
//					String s = removePunctuation(ss.trim());
//
//					if (!wordsList.contains(s.toLowerCase())) {
//						if (!fileList.contains(s.toLowerCase())) {
//							if (!checkPlural(s, fileList)) {
//								fileList.add(s);
//							}
//						}
//					}
//				}
//
//			}
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if (reader != null) {
//					reader.close();
//				}
//				if (wordsReader != null) {
//					wordsReader.close();
//				}
//			} catch (IOException e) {
//			}
//		}
//
//		// print out the list
//		//System.out.println(fileList);
	}

	public static String removePunctuation(String word) {
		String[] punctuations = { "(", ",", ".", "/", "<", ">", "?", ";", "'", ":", "\"", "[", "]", "{", "}", //
				"`", "~", "!", ")", "-", "_" };

		String newWord = word;
		for (int i = 0; i < punctuations.length; i++) {
			if (word.startsWith(punctuations[i])) {
				newWord = removePunctuation(word.substring(1));
			}

			if (word.endsWith(punctuations[i])) {
				newWord = removePunctuation(word.substring(0, word.length() - 1));
			}
		}

		return newWord.toLowerCase();
	}

	public static boolean checkPlural(String word, List<String> fileWords) {
		for (String s : fileWords) {
			if (s.equals(word.substring(0, word.length() - 1)))
				return true;
		}
		return false;
	}
	
	public ArrayList<Document> classify(DocumentFolder folder){
		ArrayList<Document> list = folder.getFiles();
		//words=initReadWords();

		for (Document d : list) {
			initTagAppearances();
			if(d.isUserClassified())
				continue;
			else{
				fileList=removeUnnecessaryWords(d);
				for(Tag t : allTags){
					ArrayList<String> dictionary=t.getDictionary();
					if(dictionary.isEmpty()){
						if(fileList.contains(t.getName().toLowerCase())){
							setTagCounter(t);
						}
					}else{
						for(String word:dictionary){
							if(fileList.contains(word.toLowerCase())){
								setTagCounter(t);
							}
						}
						
					}
				}
				
				d.addTag(getTagWithMaxAppearences());
				System.out.println("!!!!!!!!"+d);
			}
		}
		return list;
	}
	
	private Tag getTagWithMaxAppearences(){
		int max=0;
		Tag t=null;
		
		 for (Map.Entry mapElement : tagAppearances.entrySet()) { 
	            Tag key = (Tag)mapElement.getKey(); 
	            int value = ((int)mapElement.getValue()); 
	  
	            if(value>max){
	            	max=value;
	            	t=key;
	            }
	            System.out.println(key + " : " + value); 
	        } 
	    return t;
	}

	private void setTagCounter(Tag t){
		 for (Map.Entry mapElement : tagAppearances.entrySet()) { 
	            Tag key = (Tag)mapElement.getKey(); 
	  
	            if(key.equals(t)){
	            	int value = ((int)mapElement.getValue() + 1); 
	            	tagAppearances.put(key, value);
	            }
	            // Add some bonus marks 
	            // to all the students and print it 
	  
	            System.out.println(key); 
	        } 
	}
	private void initTagAppearances() {
		for(Tag t: allTags){
			tagAppearances.put(t, 0);
		}
	}
	private ArrayList<String> removeUnnecessaryWords(Document d) {
		Scanner lineScanner = null;
//		BufferedWriter writer=null;
		ArrayList<String> wordsFromFile=new ArrayList<String>();
		try {
			lineScanner = new Scanner(new File(d.getPath()));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while (lineScanner.hasNextLine()) {
			Scanner wordScanner = new Scanner(lineScanner.nextLine());
			String sentence="";
			while (wordScanner.hasNext()) {
				String s = wordScanner.next();
				s=removePunctuation(s);
				if(!words.contains(s)){
//					try {
//						writer = new BufferedWriter(new FileWriter("temp.txt"));
//						sentence+=s+" ";
//						writer.write(sentence);
						
					wordsFromFile.add(s.toLowerCase());
					//	System.out.println(s);
//					} catch (IOException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
				}
			}
//			try {
//			//	writer.close();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}
		return wordsFromFile;
	}
	
	//read from file words.txt the words to be removed 
		private ArrayList<String> initReadWords() {
			ArrayList<String> words = new ArrayList<>();
			Scanner lineScanner = null;
			try {
				lineScanner = new Scanner(new File("words.txt"));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			while (lineScanner.hasNextLine()) {
				Scanner wordScanner = new Scanner(lineScanner.nextLine());
				while (wordScanner.hasNext()) {
					String s = wordScanner.next();
					words.add(s);
					//System.out.println(s);
				}
			}
			return words;
		}
		
	public void addDictionaryToTag(Tag tag,Document d){
		ArrayList<String> fileWords=removeUnnecessaryWords(d);
		for(String word:fileWords){
			tag.addWordToDictionary(word);
		}
	}
}
