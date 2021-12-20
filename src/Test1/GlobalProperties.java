package Test1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class GlobalProperties {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

	  Properties prop=new Properties();
	     FileInputStream fis=new FileInputStream("E:\\Projects\\Java\\Selenium Java Practice\\data.properties");
	     prop.load(fis);
	     
	     System.out.println(prop.getProperty("browser"));
	     System.out.println(prop.getProperty("url"));
	     
	     prop.setProperty("browser", "ie");
	     System.out.println(prop.getProperty("browser"));
	     FileOutputStream fos=new FileOutputStream("E:\\\\Projects\\\\Java\\\\Selenium Java Practice\\\\data.properties");
	   prop.store(fos, null);
	    System.out.println(prop.getProperty("browser"));
	    
	     
	     
	     
	}

}
