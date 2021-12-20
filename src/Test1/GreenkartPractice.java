package Test1;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GreenkartPractice {

	public static Logger log= LogManager.getLogger(GreenkartPractice.class.getName());
	public static void main(String[] args) {
		

		System.setProperty("webdriver.chrome.driver", "E:\\Projects\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		log.debug("Launching the site");
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		log.info("Site has been launced successfully");
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
		String[] itemsNeeded= {"Cucumber","Tomato","Capsicum"};
		addCart(driver,itemsNeeded,log);
		//driver.findElement(By.cssSelector("")).click();
		log.debug("Clicking on  cart icon");
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		log.info("Clickied on cart  Icon");
		log.debug("Clicking on Proceed to checkout button");
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		log.info("Clicked on proceed to checkout button");
		@SuppressWarnings("deprecation")
		WebDriverWait wait=new WebDriverWait(driver,10);
		log.debug("Wating for display of Enter promo code field");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[class='promoCode']")));
		log.info("Promocode text field displayed");
		log.debug("Entering promocode");
		driver.findElement(By.cssSelector("input[class='promoCode']")).sendKeys("rahulshettyacademy");
		log.info("Entered promo code");
		log.debug("Clicking on Apply button");
		driver.findElement(By.cssSelector("button[class='promoBtn']")).click();
		log.info("Clicked on Apply button");
		log.debug("Waiting for Order confirmation text");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span[class='promoInfo']")));
		System.out.println(driver.findElement(By.cssSelector("span[class='promoInfo']")).getText());
		 log.info("Order placement text displayed");
		 
	}

	static void addCart(WebDriver driver,String[] itemsNeeded, Logger log) {
		
		List<WebElement> itemsNeededToAdd=driver.findElements(By.cssSelector("h4.product-name"));
		List itemNames=Arrays.asList(itemsNeeded);
		int j=0;
		log.debug("Starting the loop for iteration");
		for(int i=0;i<itemsNeededToAdd.size();i++) {
			log.info("iterating the "+i+" st/rd item");
			String itemName=driver.findElements(By.cssSelector("h4.product-name")).get(i).getText();
			log.info("got the text of "+i+" st item");
			log.debug("Splitting the text of "+i+" st item");
			String name=itemName.split("-")[0].trim();
			log.info("Splitted the text of "+i+" st item");
			log.debug("Checking for the "+i+" item text containg the expected item or not");
			if(itemNames.contains(name)) {
				log.info(i+" st item text contains the expected item");
				j++;
				log.debug("Clicking on the Add to cart button for "+j+" st expected item");
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				log.info("Clicked on the Add to cart button for "+j+" st expected item");
				log.debug("checking whether all the needed items are added to cart or not");
				if(j==itemsNeeded.length) {
					log.info("All the needed items are added to cart and stoping the searching for items");
					break;
				}
				else {
					
					log.info("All the iteems needed aren't added to cart");
				}
				
			}
			else 
			{
				log.info("Expected item is not displayed in "+i+" st iteration");
			}
			
		}
	}
	
	
}
