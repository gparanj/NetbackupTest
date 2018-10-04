package veritas.netbackup.util;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import veritas.netbackup.base.TestBase;

public class TestUtil extends TestBase {

	public static long PAGE_LOAD_TIMEOUT = 100;
	public static long IMPLICIT_WAIT = 50;
	
	
	public static String TESTDATA_SHEET_PATH = "C:\\BCSE4\\NetbackupTest\\src\\main\\java\\veritas\\netbackup\\testdata\\NetbackupTestData.xlsx";
		   static Workbook book;
		   static Sheet sheet;
	
	public static Object[][] getTestData(String sheetName){
		FileInputStream file = null;
		try {
			file= new FileInputStream(TESTDATA_SHEET_PATH);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		sheet= book.getSheet(sheetName);
		Object[][] data= new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for (int i=0; i<sheet.getLastRowNum(); i++) {
			for (int k=0; k<sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k]=sheet.getRow(i+1).getCell(k).toString();
			}
		}
		return data;	
	}
	
	
	public static void clickOn(WebDriver driver, WebElement element, int timeout) {
		new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}
	
	public static void sendKeys(WebDriver driver, WebElement element, int timeout, String value) {
		new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(value);
	}
	
	public void logout() throws InterruptedException {
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		WebElement firstElement = driver.findElement(By.xpath("//*[@class='vdl-top-bar-actions']//*[@class='top-bar__settings-button ng-star-inserted']//following-sibling::*[@id='user__menu']"));
		clickOn(driver, firstElement, 20);
		WebElement secondElement =driver.findElement(By.xpath("//*[@aria-label='fa-sign-out']//parent::*//preceding-sibling::*[@class='top-bar__settings-menu-item vdl-menu-item ng-star-inserted']//parent::*//parent::*//parent::*[@id='cdk-overlay-0']"));
		clickOn(driver, secondElement, 30);	
	}
	
	
	
	public void add() {
		driver.findElement(By.cssSelector("button[class='mini vo ng-star-inserted']")).click();
	}
	
	
	public boolean verifyAdd() {
		return driver.findElement(By.cssSelector("button[class='mini vo ng-star-inserted']")).isDisplayed();
	}
	
	public void save() {
		int i;
		for(i=1; i<=5; i++) {
		driver.findElement(By.xpath("//*[contains(text(),'Save')]")).click();
		}
	}
	
	public void save1() {
		driver.findElement(By.xpath("//*[contains(text(),'Save')]")).click();
		}
	
	
	public boolean Stop_Services() throws InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
        ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "cd \"C:\\Program files\\Veritas\\Netbackup\\Bin\" && bpdown -v -f");
        System.out.println("\n\nServices are stopping");
        builder.redirectErrorStream(true);
        Process p;
		try {
			p = builder.start();
			 BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
		        String line;
		        while (true) {
		            line = r.readLine();
		            if (line == null) { break; }
		            System.out.println(line);
		        }
		} catch (IOException e) {
			e.printStackTrace();
		}
       
		return false;
}



	public boolean Start_Services() throws InterruptedException {
	
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "cd \"C:\\Program files\\Veritas\\Netbackup\\Bin\" && bpup -v -f");
		System.out.println("\n\nServices are starting");
		builder.redirectErrorStream(true);
		Process p;
		try {
			p = builder.start();
				BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
				String line;
				while (true) {
					line = r.readLine();
					if (line == null) { break; }
					System.out.println(line);
				}
		} catch (IOException e) {
			e.printStackTrace();
		}
  
		return false;
	}
	
	
	@SuppressWarnings({ "resource", "unused" })
	public void Name_Discription() throws InterruptedException {
		
			//Enter the name
		WebElement name= driver.findElement(By.id("name"));
		Scanner scan = new Scanner(System.in);
		System.out.println("\nEnter any name:");
		String name1 = scan.nextLine();
		
		System.out.println("The entered name is:");
		System.out.print(name1);
		name.sendKeys(name1);
		
		WebElement description= driver.findElement(By.id("description"));
		Scanner scan1 = new Scanner(System.in);
		System.out.println("\n\nEnter any Description:");
		String description1 = scan.nextLine();
		
		System.out.println("The Description is:");
		System.out.print(description1);
		description.sendKeys(description1);
		
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
	}
	
	public void scrolldown() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
	}
	
	
	public boolean verifyRefreshButton() {
		return driver.findElement(By.xpath("//*[@aria-label='fa-refresh']")).isDisplayed();
		
	}
	
	public boolean verifyDensityDisplayButton() {
		return driver.findElement(By.xpath("//*[@aria-label='display-density']")).isDisplayed();
		
	}
	
	public boolean verifyShowOrHideColoumnButton() {
		return driver.findElement(By.xpath("//*[@aria-label='fa-columns']")).isDisplayed();
		
	}
	
	public boolean verifySearchButton() {
		return driver.findElement(By.xpath("//*[@aria-label='fa-search']")).isDisplayed();
		
	}
	
	
	public static void takescreenshotAtEndOfTest() throws IOException {
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
			FileUtils.copyFile(srcFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}

}
