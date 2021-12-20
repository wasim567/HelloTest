package Test1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JDBCSeleniumConnection {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		
		System.setProperty("webdriver.chrome.driver", "E:\\Projects\\chromedriver_win32\\chromedriver.exe");
		
		  
		   
		   //write jdbc code
		   
		     Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","root");
		               Statement s=con.createStatement();
		               ResultSet rs=s.executeQuery("select * from carddetails where password='pwd1'");
		        
		   // connect to selenium
		               WebDriver driver=new ChromeDriver();
		            	driver.get("https://login.salesforce.com/?locale=eu");
		               while(rs.next()) 
		               {
		            	  
		            	driver.findElement(By.id("username")).sendKeys(rs.getString("username"));
		            	driver.findElement(By.id("password")).sendKeys(rs.getString("password"));
		            	   
		            	   
		               }
		   
	}

}
