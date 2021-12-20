package Test1;

import org.apache.logging.log4j.*;

public class LogTest {
    private static Logger log=  LogManager.getLogger(LogTest.class.getName());
	public static void main(String[] args) {
		// TODO Auto-generated method stub
  log.info("Hello");
	}

}
