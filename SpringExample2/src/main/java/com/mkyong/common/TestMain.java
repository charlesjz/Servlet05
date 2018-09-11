package com.mkyong.common;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class TestMain {

    public static void main(String[] args) {

        Document doc,doc1,doc2;
        String linkAttr1,linkAttr2,linkText1,linkText2; 
        try {

//        	https://www.monster.ca/jobs/search/?q=java-Developer&where=toronto&page=2
        	doc = Jsoup.connect("https://www.monster.ca/jobs/search/?q=java-Developer&where=toronto&page=2").get();

            // get page title
            String title = doc.title();
            System.out.println("title : " + title);
            
            String linkAttr, linkText;
            Elements links1,links2;

            // get all links
            Elements links = doc.select("a[href]");
            for (Element link : links) {

                // get the value from href attribute
//                System.out.println("\n" + link.attr("href"));
//                System.out.println("text : " + link.text());
                
                linkAttr=link.attr("href");
                linkText=link.text();
                
                if(linkText.toLowerCase().contains("java") 
                		&& (linkText.toLowerCase().contains("developer")
                        		|| linkText.toLowerCase().contains("programer")
                                		|| linkText.toLowerCase().contains("software")
                																			
                		))
                {
                	doc1 = Jsoup.connect(linkAttr).get();
                    links1 = doc1.select("a[href]");
                    for (Element link1 : links1) {
                    	if("Apply".equals(link1.text())){
                    		System.out.println("\n" + link1.attr("href"));
                    		System.out.println("----text : " + link1.text());
                    	}

                    	
                    }
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}