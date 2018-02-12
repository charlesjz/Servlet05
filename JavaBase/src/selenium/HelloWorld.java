package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HelloWorld
{

    public static void main(String[] args) throws Exception
	{
//		String URL = "http://www.baidu.com";
		WebDriver webDriver = new FirefoxDriver();
		webDriver.get("http://www.baidu.com");
		
		WebElement query = webDriver.findElement(By.name("wd"));
		query.sendKeys("taobao");
		
		Thread.sleep(5000);
		
		webDriver.quit();
	}
}