package Test1;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SeleniumGrid {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "E:\\Projects\\chromedriver_win32\\chromedriver.exe");
             
		DesiredCapabilities ds=new DesiredCapabilities();
		ds.setBrowserName("chrome");
		ds.setPlatform(Platform.WIN10);
		WebDriver driver =new RemoteWebDriver(new URL("http://192.168.1.10:4444/wd/hub"),ds);
		 driver.get("https://www.selenium.dev/downloads/");
		 
         
	}

}
