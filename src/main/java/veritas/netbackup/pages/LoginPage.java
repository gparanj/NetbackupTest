package veritas.netbackup.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import veritas.netbackup.base.TestBase;
import veritas.netbackup.util.TestUtil;





public class LoginPage extends TestBase{
		
		//Page Factory / Object Repository
		@FindBy(id="username")
		WebElement username;
		
		@FindBy(id="password")
		WebElement password;
		
		@FindBy(xpath="//*[@type='submit']")
		WebElement loginbtn;
		
		@FindBy(xpath="//*[@class='vdl-login-icon vdl-icon']")
		WebElement netbackup_logo;
		
		@FindBy(xpath="//*[@class='vdl-login-title']")
		WebElement netbackup_title;
		
		@FindBy(xpath="//*[@class='vdl-login-subtitle']")
		WebElement netbackup_subtitle;
		
		//Initializing the Page Objects
		public LoginPage() {
			PageFactory.initElements(driver, this);
		}
		
		//Actions
		public String ValidateLoginPageTitle() {
			return driver.getTitle();
		}
		
		public boolean validateNetbackupLogo() {
			return netbackup_logo.isDisplayed();
		}
		
		public boolean ValidateNetbackupTitle() {
			return netbackup_title.isDisplayed();
		}
		
		public boolean ValidateNetbackupSubtitle() {
			return netbackup_subtitle.isDisplayed();
		}
		
		public HomePage login(String un, String pwd) throws InterruptedException {
			username.sendKeys(un);
			password.sendKeys(pwd);
			Thread.sleep(1000);
			loginbtn.click();
			driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			return new HomePage();
		}
		
}
