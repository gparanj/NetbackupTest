package veritas.netbackup.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ReadProp {

	public static void main(String[] args) throws IOException {
		
		WebDriver driver = null;
	
		//How to read properties file
		Properties prop = new Properties();
		FileInputStream ip = new FileInputStream("C:\\BCSE4\\NetbackupTest\\src\\main\\java\\veritas\\netbackup\\config\\config.properties");
		prop.load(ip);
		
		System.out.println(prop.getProperty("browser"));
		String browserName = prop.getProperty("browser");
		
		if (browserName.equals("Firefox")){
			 System.setProperty("WebDriver.gecko.driver","C:\\BCSE4\\NetbackupTest\\geckodriver.exe");
			 driver = new FirefoxDriver();
		}else if(browserName.equals("chrome")){
			 System.setProperty("WebDriver.chrome.driver","C:\\BCSE4\\NetbackupTest\\chromedriver.exe");
			 driver =new ChromeDriver();
		}else {
			System.out.println("No browser value is given");
		}
		
		driver.get(prop.getProperty("url"));
		
		WebDriverWait wait = new WebDriverWait(driver, 100);
		 wait.until(ExpectedConditions.titleIs(prop.getProperty("browser_title")));
		
		 String url = driver.getCurrentUrl();
		 System.out.println(url);
		 
		 if(url.equals(prop.getProperty("url"))){
			 System.out.println("Correct url");
		}
			 else{
				 System.out.println("incorrect url");
			 }
		
		
		driver.manage().window().maximize();
	 	 driver.manage().deleteAllCookies();
	 	 
	 	 String title = driver.getTitle();
		 System.out.println(title);
		 
		 if(title.equals(prop.getProperty("browser_title"))){
			 System.out.println("title correct");
		}
			 else{
				 System.out.println("incorrect title");
			 }
		
		driver.findElement(By.xpath(prop.getProperty("netbackup_logo_xpath"))).isDisplayed();
		driver.findElement(By.xpath(prop.getProperty("netbackup_title_xpath"))).isDisplayed();
		driver.findElement(By.xpath(prop.getProperty("netbackup_subtitle_xpath"))).isDisplayed();
		driver.findElement(By.id(prop.getProperty("username_id"))).sendKeys(prop.getProperty("username"));
		driver.findElement(By.id(prop.getProperty("password_id"))).sendKeys(prop.getProperty("password"));
		driver.findElement(By.className(prop.getProperty("loginbtn_className"))).click();
		
		
		

	}

}
