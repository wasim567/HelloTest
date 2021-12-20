package Test1;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Demo1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "E:\\Projects\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
	    String name="demo1";
	    String pwd=getPassword(driver);
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.id("inputUsername")).sendKeys(name);
		driver.findElement(By.name("inputPassword")).sendKeys(pwd);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.tagName("p")).getText(),"You are successfully logged in.");
		Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(),"Hello "+name+",");
		
		driver.close();
		
		}
	
	public static String getPassword(WebDriver driver) throws InterruptedException {
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='forgot-pwd-container']/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("button[class='reset-pwd-btn']")).click();
		Thread.sleep(2000);
String password=driver.findElement(By.cssSelector("form p")).getText();
   String pwdArray=password.split("'")[1].split("'")[0];
   return pwdArray;
   
	}

}
