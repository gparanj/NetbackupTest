package veritas.netbackup.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import veritas.netbackup.base.TestBase;
import veritas.netbackup.pages.HomePage;
import veritas.netbackup.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest() {
		super();
	}
	
	
	@BeforeMethod
	public void SetUp() {
		initialization();
		loginPage = new LoginPage();
	}
	
	
	@Test
	public void loginPageTitleTest() {
		String loginPagetitle = loginPage.ValidateLoginPageTitle();
		Assert.assertEquals(loginPagetitle, prop.getProperty("browser_title"), "Login Page title not matched");
		
	}
	
	@Test
	public void NetbackupLogoTest() {
		boolean logo= loginPage.validateNetbackupLogo();
		Assert.assertTrue(logo);
	}
	
	@Test
	public void NetbackupTitleTest() {
		boolean NetbackupTitle= loginPage.ValidateNetbackupTitle();
		Assert.assertTrue(NetbackupTitle);
	}
	
	@Test
	public void NetbackupSubtitleTest() {
		boolean NetbackupSubtitle= loginPage.ValidateNetbackupSubtitle();
		Assert.assertTrue(NetbackupSubtitle);
	}
	
	@Test
	public void loginTest() throws InterruptedException {
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));	
		
		}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
