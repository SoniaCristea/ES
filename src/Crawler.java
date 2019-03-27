
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Crawler {
	
	private static final String USER_AGENT =
            "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.1 (KHTML, like Gecko) Chrome/13.0.782.112 Safari/535.1";
	private Document HTML;
	private String bodyText = "";
	private static String url = "https://en.wikipedia.org/wiki";
	
	
	public boolean retrieveHTMLBody(String url){
		
		try {
			Connection connection = Jsoup.connect(url).userAgent(USER_AGENT);
			Document htmlDocument = connection.get();
			HTML = htmlDocument;
			
			if(connection.response().statusCode() == 200){
				System.out.println("Received web page at: "+url);
			}
			
			if(!connection.response().contentType().contains("text/html")){
				System.out.println("Received something other than html.");
				return false;
			}
			
			Element htmlBody =  htmlDocument.body();
			PrintWriter pw = new PrintWriter(new FileWriter(new File("out.txt")));
			bodyText = htmlBody.text();
			pw.append(bodyText);
			pw.close();
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		return true;
	}
	
	public String toString(){
		return bodyText;
	}
	
//	public static void main(String[] args) {
//		String url = "https://en.wikipedia.org/wiki";
//		String tag = "Toy";	
//		url = url + "/"+tag;
//		
//		Crawler crawler = new Crawler();
//		if ( crawler.retrieveHTMLBody(url)){
//			System.out.println(crawler.toString());
//		}
//		
//	}
		
}

