package veritas.netbackup.util;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;



import veritas.netbackup.base.TestBase;

public class WebEventListener extends TestBase implements WebDriverEventListener {
	
	public void BeforeFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println("Trying to find element by" + by.toString());
	}
	
	public void AfterFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println("found element by" + by.toString());
	}

	public void beforeAlertAccept(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterAlertAccept(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void beforeAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void beforeNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		System.out.println("Value of the:" + element.toString() + "Before any changes made");
		
	}

	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		System.out.println("Element value changed to:" + element.toString());
		
	}

	public void beforeScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void beforeSwitchToWindow(String windowName, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterSwitchToWindow(String windowName, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}


	public <X> void beforeGetScreenshotAs(OutputType<X> target) {
		// TODO Auto-generated method stub
		
	}

	public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {
		// TODO Auto-generated method stub
		
	}

	public void beforeGetText(WebElement element, WebDriver driver) {
		System.out.println("Trying to get the text:" + element.toString());
		
	}

	public void afterGetText(WebElement element, WebDriver driver, String text) {
		System.out.println("Found text as:" + element.toString());
		
	}

	public void beforeNavigateTo(String url, WebDriver driver) {
		System.out.println("Navigated to: '" + url + "'");
		
	}

	public void afterNavigateTo(String url, WebDriver driver) {
		System.out.println("After Navigating to: '" + url + "'");
		
	}

	public void beforeNavigateBack(WebDriver driver) {
		System.out.println("Navigated back to previous page");
		
	}

	public void afterNavigateBack(WebDriver driver) {
		System.out.println("Navigated back to previous page");
		
	}

	public void beforeNavigateForward(WebDriver driver) {
		System.out.println("Navigated forword to next page");
		
	}

	public void afterNavigateForward(WebDriver driver) {
		System.out.println("Navigated forword to next page");
		
	}

	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println("Trying to find element by" + by.toString());
		
	}

	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println("found element by" + by.toString());
		
	}

	public void beforeClickOn(WebElement element, WebDriver driver) {
		System.out.println("Trying to click on:" + element.toString());
		
	}

	public void afterClickOn(WebElement element, WebDriver driver) {
		System.out.println("Clicked on:" + element.toString());
		
	}

	public void onException(Throwable error, WebDriver driver) {
		System.out.println("Exception occured" + error);
		
		try {
			TestUtil.takescreenshotAtEndOfTest();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
}
