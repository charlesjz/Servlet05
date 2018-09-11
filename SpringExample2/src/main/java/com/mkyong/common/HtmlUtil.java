package com.mkyong.common;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.File;
import java.net.HttpURLConnection;
import java.net.URL;

import org.htmlparser.Node;
import org.htmlparser.util.NodeIterator;
import org.htmlparser.Parser;

/**
* @author www.baizeju.com
*/
public class HtmlUtil {
    private static String ENCODE = "utf-8";
    private static void message( String szMsg ) {
        try{ System.out.println(new String(szMsg.getBytes(ENCODE), System.getProperty("file.encoding"))); }     catch(Exception e ){}
    }
//    public static String openFile( String szFileName ) {
//        try {
//            BufferedReader bis = new BufferedReader(new InputStreamReader(new FileInputStream( new File(szFileName)),    ENCODE) );
//            String szContent="";
//            String szTemp;
//            
//            while ( (szTemp = bis.readLine()) != null) {
//                szContent+=szTemp+"\n";
//            }
//            bis.close();
//            return szContent;
//        }
//        catch( Exception e ) {
//            return "";
//        }
//    }
    
    public static void main( String[] args ){
        
        try{
            Parser parser = new Parser( (HttpURLConnection) (new URL("https://www.monster.ca/jobs/search/?Ontario+Toronto__2fGTA+ZZcompanySearchZZ_126?q=java-Developer&amp;where=toronto&amp;rad=32-km")).openConnection() );
        
            for (NodeIterator i = parser.elements (); i.hasMoreNodes(); ) {
                Node node = i.nextNode();
                message("getText:"+node.getText());
                message("getPlainText:"+node.toPlainTextString());
                message("toHtml:"+node.toHtml());
                message("toHtml(true):"+node.toHtml(true));
                message("toHtml(false):"+node.toHtml(false));
                message("toString:"+node.toString());
                message("=================================================");
            }            
        }
        catch( Exception e ) {     
            System.out.println( "Exception:"+e );
        }
    }
}
