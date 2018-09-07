package veritas.netbackup.base;

import org.apache.log4j.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GenerateLogs {

	public static void main(String[] args) {
		
		Logger log = Logger.getLogger(GenerateLogs.class);
		
		System.setProperty("WebDriver.gecko.driver","C:\\BCSE4\\Automation\\Selenium\\geckodriver.exe");
		WebDriver driver= new FirefoxDriver();
		
		log.info("launching browser");
		
		driver.get("http://www.google.com");
		log.info("google url has launched");
		
		String title= driver.getTitle();
		System.out.println("title value is: "+ title);
		log.info("title value is: "+title);
		
		if(title.equals("Google")) {
			System.out.println("correct title is Google");
			log.info("correct title is Google and testcase is passed");
		}else {
			System.out.println("correct title is not Google");
			log.info("correct title is Google and testcase is not passed");
		}
		
		driver.close();
		log.info("browser closed");
	}
}
