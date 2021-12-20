package Test1;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class RelativeLocators {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "E:\\Projects\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		//
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		WebElement nameEditbox=driver.findElement(By.xpath("//form/div[1]/input[1]"));
		System.out.println(driver.findElement(with(By.tagName("label")).above(nameEditbox)).getText());
		
		//
		//WebElement email=driver.findElement(By.cssSelector(""));
		//driver.findElement(with(By.tagName("input")).below(email)).sendKeys("kwas@123");
		
		//
		WebElement checkboxtext=driver.findElement(By.cssSelector("label[for='exampleCheck1']"));
		driver.findElement(with(By.tagName("input")).toLeftOf(checkboxtext)).click();
		
		//
		WebElement demo=driver.findElement(By.id("inlineRadio1"));
		System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(demo)).getText());
		
		
		driver.switchTo().newWindow(WindowType.TAB);
		       Set<String> windows=     driver.getWindowHandles();
		      Iterator<String> itr= windows.iterator();
		      String parentWindow=itr.next();
		      String childWindow=itr.next();
		      driver.switchTo().window(childWindow);
		      driver.get("https://rahulshettyacademy.com/#/index");
		    String courseName=  driver.findElements(By.cssSelector("div[class='lower-content'] a[href*='https://courses.rahulshettyacademy.com/p")).get(2).getText();
		    
		    driver.switchTo().window(parentWindow);
		    driver.findElement(By.xpath("//form/div[1]/input")).sendKeys(courseName);
		    
		    WebElement name=driver.findElement(By.xpath("//form/div[1]"));
		   File src= name.getScreenshotAs(OutputType.FILE);
		   FileUtils.copyFile(src, new File("E:\\Projects\\Selenium\\email.png"));
		   
		   WebElement email=driver.findElement(By.xpath("//form/div[2]/input"));
		   System.out.println(email.getRect().getDimension().getHeight());
		   System.out.println(email.getRect().getDimension().getWidth());
		   
	}

}
