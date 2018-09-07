package veritas.netbackup.util;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import veritas.netbackup.base.TestBase;

public class TestUtil extends TestBase {

	public static long PAGE_LOAD_TIMEOUT = 30;
	public static long IMPLICIT_WAIT = 20;
	
	public void logout() throws InterruptedException {
		driver.findElement(By.xpath("//*[@class='vdl-top-bar-actions']//*[@class='top-bar__settings-button ng-star-inserted']//following-sibling::*[@id='user__menu']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@class='vdl-menu-item']//*[@fonticon='fa-sign-out']")).click();
	}
	
	public boolean add() {
		//click on add
		driver.findElement(By.cssSelector("button[class='mini vo ng-star-inserted']")).click();
		return driver.findElement(By.cssSelector("button[class='mini vo ng-star-inserted']")).isDisplayed();
	}
	
	
	public void save() {
		int i;
		for(i=1; i<=5; i++) {
		driver.findElement(By.xpath("//*[contains(text(),'Save')]")).click();
		}
	}
	
	public boolean Stop_Services() throws InterruptedException {
		
		Thread.sleep(3000);
        ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "cd \"C:\\Program files\\Veritas\\Netbackup\\Bin\" && bpdown -v -f");
        System.out.println("\n\n Services are stopping");
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
		return false;
}



	public boolean Start_Services() throws InterruptedException {
	
		Thread.sleep(2000);
		ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "cd \"C:\\Program files\\Veritas\\Netbackup\\Bin\" && bpup -v -f");
		System.out.println("\n\n Services are starting");
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
			// TODO Auto-generated catch block
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
		
		Thread.sleep(3000);
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
