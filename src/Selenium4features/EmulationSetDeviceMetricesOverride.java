package Selenium4features;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v95.emulation.Emulation;

public class EmulationSetDeviceMetricesOverride {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "E:\\Projects\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		      DevTools devTools= driver.getDevTools();
		      devTools.createSession();
		      devTools.send(Emulation.setDeviceMetricsOverride(null, null, null, null, null, null, null, null, null, null, null, null, null));
	}

}
