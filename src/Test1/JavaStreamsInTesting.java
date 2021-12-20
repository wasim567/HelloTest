package Test1;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class JavaStreamsInTesting {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "E:\\Projects\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//thead/tr/th[1]")).click();
		List<WebElement> items=driver.findElements(By.xpath("//tbody/tr/td[1]"));
		List<String> originalList=items.stream().map(s->s.getText()).collect(Collectors.toList());
		List<String> sortedList=originalList.stream().sorted().collect(Collectors.toList());
		Assert.assertEquals(originalList, sortedList);
		List<String> price;
		do {
			List<WebElement> rowitems=driver.findElements(By.xpath("//tbody/tr/td[1]"));
		 price= rowitems.stream().filter(s->s.getText().contains("Strawberry")).map(s->getVeggiePrice(s)).collect(Collectors.toList());			
		
		if(price.size()<1) {
		driver.findElement(By.xpath("//a[@aria-label='Next']")).click();	
		Thread.sleep(4000);
		}
		}while(price.size()<1);
		
		price.stream().forEach(s->System.out.println(s));
		
		driver.findElement(By.id("search-field")).sendKeys("Apple");
		 List<WebElement> rowValues=driver.findElements(By.xpath("//tbody/tr/td[1]"));
		 
		List<WebElement> expectedName=rowValues.stream().filter(s->s.getText().contains("Apple")).collect(Collectors.toList());
		Assert.assertEquals(expectedName.size(), 1);
	}

	private static String getVeggiePrice(WebElement s) {
		// TODO Auto-generated method stub
		String priceValue=s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return priceValue;
	}

}
