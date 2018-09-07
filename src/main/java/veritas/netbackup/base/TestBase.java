package veritas.netbackup.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import veritas.netbackup.util.TestUtil;
import veritas.netbackup.util.WebEventListener;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventlistener;
	
	
	public TestBase() {
		
			//To read properties file
		
		prop = new Properties();
		FileInputStream ip = null;
		try {
			ip = new FileInputStream("C:\\BCSE4\\NetbackupTest\\src\\main\\java\\veritas\\netbackup\\config\\config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			prop.load(ip);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void initialization() {
		String browserName= prop.getProperty("browser");
		
		if(browserName.equals("Firefox")) {
			System.setProperty("WebDriver.gecko.driver","C:\\BCSE4\\NetbackupTest\\geckodriver.exe");
			 driver = new FirefoxDriver();
		}
		else if(browserName.equals("chrome")) {
			System.setProperty("WebDriver.chrome.driver","C:\\BCSE4\\NetbackupTest\\chromedriver.exe");
			 driver =new ChromeDriver();	
		}
		
		 e_driver = new EventFiringWebDriver(driver);
		 eventlistener =new WebEventListener();
		 e_driver.register(eventlistener);
		 driver = e_driver;
		
		 driver.manage().window().maximize();
	 	 driver.manage().deleteAllCookies();
	 	 driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	 	 driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
	 	 
	 	 driver.get(prop.getProperty("url"));
			 	
	}
	
}
