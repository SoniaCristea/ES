import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Classifier {
	
	public static void main(String[] args) {
		List<String> wordsList = new ArrayList<String>();
		List<String> fileList = new ArrayList<String>();
		File file = new File("test.txt");
		BufferedReader reader = null;

		File wordsFile = new File("words.txt");
		BufferedReader wordsReader = null;
		
		try {
			wordsReader = new BufferedReader(new FileReader(wordsFile));
		    String words = null;

		    while ((words = wordsReader.readLine()) != null) {
		    	wordsList.add(words);
		    }
			
			
		    reader = new BufferedReader(new FileReader(file));
		    String text = null;

		    while ((text = reader.readLine()) != null) {
		    	 Scanner s2 = new Scanner(text);
		         while (s2.hasNext()) {
		             String ss = s2.next();
		             String s=removePunctuation(ss.trim());
		            
		             if(!wordsList.contains(s.toLowerCase())){
		            	 if(!fileList.contains(s.toLowerCase())){
		            		 if(!checkPlural(s, fileList)){
		            			 fileList.add(s);
		            		 }
		            	 }
		             }
		         }
		    	
		    }
		} catch (FileNotFoundException e) {
		    e.printStackTrace();
		} catch (IOException e) {
		    e.printStackTrace();
		} finally {
		    try {
		        if (reader != null) {
		            reader.close();
		        }
		        if (wordsReader != null) {
		        	wordsReader.close();
		        }
		    } catch (IOException e) {
		    }
		}

		//print out the list
		System.out.println(fileList);
	}

	
	public static String removePunctuation(String word){
		String[] punctuations={"(",",",".","/","<",">","?",";","'",":","\"","[","]","{","}",//
				"`","~","!",")","-","_"};
		
		String newWord=word;
		for(int i=0;i<punctuations.length;i++){
			if(word.startsWith(punctuations[i])){
				newWord=removePunctuation(word.substring(1));
			}
				
			if(word.endsWith(punctuations[i])){
				newWord=removePunctuation(word.substring(0,word.length()-1));
			}
		}
	
		return newWord.toLowerCase();
	}
	
	public static boolean checkPlural(String word,List<String> fileWords){
		for(String s:fileWords){
			if(s.equals(word.substring(0,word.length()-1)) )
				return true;
		}
		return false;
	}
}
