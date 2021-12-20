package Test1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicAuth {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "E:\\Projects\\chromedriver_win32\\chromedriver.exe");
//http://admin:admin@the-internet.herokuapp.com/basic_auth
		WebDriver driver=new ChromeDriver();
		driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
	}

}
