package Test1;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinksFinding {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "E:\\Projects\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		  System.out.println(driver.findElements(By.tagName("a")).size());
		  
		  WebElement footer=driver.findElement(By.id("gf-BIG"));
		  System.out.println(footer.findElements(By.tagName("a")).size());
		  
		  WebElement firstcolumn=footer.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		    System.out.println(firstcolumn.findElements(By.tagName("a")).size());
		    for(int i=0;i<firstcolumn.findElements(By.tagName("a")).size();i++) {
		    	String click_on_link=Keys.chord(Keys.CONTROL,Keys.ENTER);
		    	firstcolumn.findElements(By.tagName("a")).get(i).sendKeys(click_on_link);
		    	Thread.sleep(5000);
		    }
		    
		    Set<String> windows=driver.getWindowHandles();
		      Iterator<String> itr=windows.iterator();
		      while(itr.hasNext()) {
		    	  
		    	  driver.switchTo().window(itr.next());
		    	  System.out.println(driver.getTitle());
		      };
		      
		      
		      
	}

}
 