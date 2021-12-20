package Test1;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AutoITFileUpload {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
      
		String downloadPath=System.getProperty("user.dir");
		
		System.setProperty("webdriver.chrome.driver", "E:\\Projects\\chromedriver_win32\\chromedriver.exe");
		//http://admin:admin@the-internet.herokuapp.com/basic_auth
		
		 HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
	       // Set ChromePref and pass the download folder path with key
	        chromePrefs.put("profile.default_content_settings.popups", 0);
	        chromePrefs.put("download.default_directory", downloadPath);
	        ChromeOptions options=new ChromeOptions();

	        options.setExperimentalOption("prefs", chromePrefs);
		WebDriver driver =new ChromeDriver(options);
		driver.get("https://smallpdf.com/word-to-pdf");
		driver.findElement(By.cssSelector(".l3tlg0-0.hrcxSS")).click();
		Thread.sleep(5000);
		Runtime.getRuntime().exec("G:\\fileUpload.exe");
		WebDriverWait wait=new WebDriverWait(driver,15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".l3tlg0-0.eqlXyA")));
		driver.findElement(By.cssSelector(".l3tlg0-0.eqlXyA")).click();
		File f=new File(downloadPath+"/converter.pdf");
        if(f.exists())
        {
            Assert.assertTrue(f.exists());
            
        }
		
		
	}

}
