package Test1;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class BrokenLink {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "E:\\Projects\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		
		List<WebElement> links=driver.findElements(By.xpath("//table[@class='gf-t']/tbody/tr/td/ul/li/a"));
		for(WebElement link: links) {
			
			String url=link.getAttribute("href");
			 HttpURLConnection conn=  (HttpURLConnection)new URL(url).openConnection();
			 conn.setRequestMethod("HEAD");
			 conn.connect();
			 int respCode=conn.getResponseCode();
			 if(respCode>400) {
				 System.out.println("The link -"+link.getText()+"- is broken with the status code "+respCode);
				 
			 }
			 else {
				 System.out.println("The link -"+link.getText()+"- is passed with the status code "+respCode);
			 }
			 
		};
	}

}
