package com.mkyong.common;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.htmlparser.Node;
import org.htmlparser.Parser;
import org.htmlparser.util.NodeIterator;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;
import org.htmlparser.visitors.HtmlPage;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args ) throws InterruptedException, IOException, ParserException
    {
    	ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Mail.xml");
    	 
    	MailMail mm = (MailMail) context.getBean("mailMail");
        
        String tempXml;
        
        SimpleDateFormat sdf = new SimpleDateFormat("yy/MM/dd HH:mm:ss.SSS"); 
        
		File file=new File("c:/Temp/temp.txt");
		FileWriter fw=new FileWriter(file, false);
		BufferedWriter bf=new BufferedWriter(fw);
		PrintWriter pw=new PrintWriter(bf);
  
                
        while(true){
        	tempXml = Utils.sendPost("https://www.monster.ca/jobs/search/?q=java-Developer&where=toronto&page=2","");
        	pw.write(tempXml);  
            Parser parser = new Parser(tempXml);
    		NodeIterator rootList = parser.elements();
    		
    		rootList.nextNode();
    		   Parser myParser;
    		    myParser = Parser.createParser(tempXml, "utf8");
    		    HtmlPage visitor = new HtmlPage(myParser);
    		    myParser.visitAllNodesWith(visitor);

    		    String textInPage = visitor.getTitle();
    		    System.out.println(textInPage);
    		    NodeList nodelist;
    		    nodelist = visitor.getBody();
    		    
    		    System.out.print(nodelist.asString().trim());

    		NodeList nodeList = rootList.nextNode().getChildren();
    		System.out.println("===============0================"); 
    		
    		
            System.out.println("===============1================"); 
            for (NodeIterator i = parser.elements(); i.hasMoreNodes(); ) {
                Node node = i.nextNode();
//                System.out.println(node.getText());
                System.out.println(node.getChildren());
                System.out.println("===============2================"); 
//                System.out.println(node.getChildren().asString());
            }
                
            
            System.out.println("===============3================"); 

        	pw.flush();  
        	bf.close();  
        	fw.close();
        	Thread.sleep(10000);
        	
        }
        /*
        */  
    }


    
    
    
    
    
    


}
