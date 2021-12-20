package Test1;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

public class ScrollWindow {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
      DesiredCapabilities ds=new DesiredCapabilities();
      ds.acceptInsecureCerts();
      ds.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
      ds.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        		
        		ChromeOptions co=new ChromeOptions();
        co.merge(ds);
		System.setProperty("webdriver.chrome.driver", "E:\\Projects\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver(co);
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		//driver.manage().deleteCookieNamed(null);
		driver.findElement(By.id("autocomplete")).sendKeys("ind");
		Thread.sleep(5000);
		driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
		Thread.sleep(5000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		int j=0;
		String value=(String)js.executeScript("return document.getElementById(\'autocomplete\').value;");
		if(value.equalsIgnoreCase("India")) {
			System.out.println("Value is available " +value);
			j++;
		}
		
		while(!value.equalsIgnoreCase("India")) {
			driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
			Thread.sleep(5000);
			 value=(String)js.executeScript("return document.getElementById(\'autocomplete\').value;");
			if(value.equalsIgnoreCase("India")) {
				System.out.println("Value is available " +value);
				j++;
				break;
			}
			
			
		}
		
		if(j==0) {
			System.out.println("value isn't present");
		}
		
		
		js.executeScript("window.scrollBy(0,700)");
		js.executeScript("document.querySelector(\".tableFixHead\").scrollTop=500");
		
		List<WebElement> amount=driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		int sum=0;
		for(int i=0;i<amount.size();i++) {
			sum=sum+Integer.parseInt(amount.get(i).getText());
		}
		System.out.println(sum);
		 int total=Integer.parseInt(driver.findElement(By.cssSelector("div.totalAmount")).getText().split(":")[1].trim());
		 
		 Assert.assertEquals(sum, 296);
		 
		 File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 FileUtils.copyFile(src, new File("E:\\Projects\\Selenium\\AutomationPage.png"));
	}
}
