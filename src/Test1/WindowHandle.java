package Test1;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "E:\\Projects\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com/loginpagePractise/");
		driver.findElement(By.cssSelector("a[target='_blank']")).click();
		Set<String> windows=driver.getWindowHandles();
		   Iterator<String> itr=  windows.iterator();
		   String parent=itr.next();
		   String child=itr.next();
		   driver.switchTo().window(child);
		   String text=driver.findElement(By.xpath("//p[@class='im-para red']")).getText();
		  String email= text.split("at")[1].trim().split(" ")[0];
		  driver.switchTo().window(parent);
		  driver.findElement(By.id("username")).sendKeys(email);
		  
	}

}
