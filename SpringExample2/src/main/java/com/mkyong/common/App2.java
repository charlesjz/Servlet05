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
import java.util.Set;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class App2 
{
    public static void main( String[] args ) throws Exception
    {
    	ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Mail.xml");
   	 
    	MailMail mm = (MailMail) context.getBean("mailMail");
    	
        
    	Set <String> jobs = Utils.SearchJob();
    	System.out.println("===============================");
    	
    	for(String job:jobs){
    		System.out.println(job);
    	}
    	System.out.println("There're " + jobs.size() + " jobs!");
                
//    	Utils.ApplyTheseJobs(jobs);
    	
    }

}
