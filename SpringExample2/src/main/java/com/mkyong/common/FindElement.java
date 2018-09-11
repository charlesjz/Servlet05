package com.mkyong.common;

import java.util.concurrent.TimeUnit;  

import org.openqa.selenium.By;  
import org.openqa.selenium.WebDriver;  
import org.openqa.selenium.firefox.FirefoxDriver;  
  
public class FindElement {  
  
    public static void click(String url) {
//        System.setProperty("webdriver.gecko.driver", "D:\\Java\\library\\selenium-java-3.11.0\\geckodriver.exe");  
        System.setProperty("webdriver.gecko.driver", "D:\\Java\\library\\selenium-java-3.11.0\\geckodriver.exe");  
        WebDriver driver = new FirefoxDriver();   
       
        driver.manage().window().maximize();    
         
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);  
            
        driver.get(url);    
          
        driver.findElement(By.id("applybtn")).click();  

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  

        driver.close();
          
    }  
  
}  