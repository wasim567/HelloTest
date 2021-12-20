package Test1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class DropdownPractice {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "E:\\Projects\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().maximize();
		driver.findElement(By.id("autosuggest")).sendKeys("Am");
		Thread.sleep(5000);
		List<WebElement> values=driver.findElements(By.cssSelector("a[class='ui-corner-all'] "));
		
		for(WebElement option:values) {
			
			if(option.getText().equalsIgnoreCase("Iran (Islamic Republic of)")){
				option.click();
				break;
			}
		}
		
		Assert.assertFalse(driver.findElement(By.id("ctl00_mainContent_chk_SeniorCitizenDiscount")).isSelected());
		driver.findElement(By.id("ctl00_mainContent_chk_SeniorCitizenDiscount")).click();
		Assert.assertTrue(driver.findElement(By.id("ctl00_mainContent_chk_SeniorCitizenDiscount")).isSelected());
		System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
		
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXTaction")).click();
		driver.findElement(By.cssSelector("a[value='BLR']")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("div[id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] a[value='MAA']")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();
		
		if(driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5")) {
			Assert.assertTrue(true);
			System.out.println("Its disabled");
		}
		
		driver.findElement(By.cssSelector("div[id='Div1'] button[type='button']")).click();
		while(!driver.findElement(By.cssSelector("div[class='ui-datepicker-title'] span[class='ui-datepicker-month']")).getText().contains("April")) {
			driver.findElement(By.cssSelector(".ui-datepicker-header.ui-widget-header.ui-helper-clearfix.ui-corner-right a")).click();
		}
		Thread.sleep(5000);
		for(int i=0;i<driver.findElements(By.cssSelector("td[data-handler='selectDay'] a")).size();i++) {
	 if(driver.findElements(By.cssSelector("td[data-handler='selectDay'] a")).get(i).getText().equals("10")) {
		 driver.findElements(By.cssSelector("td[data-handler='selectDay'] a")).get(i).click(); 
	 }
		}
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000);
		for(int i=1;i<5;i++) {
			driver.findElement(By.id("hrefIncAdt")).click();
		}
		
		driver.findElement(By.id("btnclosepaxoption")).click();
		
		Select s=new Select(driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")));
		s.selectByValue("USD");
		
		//driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
		
		
	}

}
