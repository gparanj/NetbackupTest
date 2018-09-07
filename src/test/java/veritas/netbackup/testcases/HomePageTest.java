package veritas.netbackup.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import veritas.netbackup.base.TestBase;
import veritas.netbackup.pages.HomePage;
import veritas.netbackup.pages.LoginPage;
import veritas.netbackup.util.TestUtil;

public class HomePageTest extends TestBase {
	
	TestUtil testutil;
	LoginPage loginPage;
	HomePage homePage;
	
	public HomePageTest() {
		super();
	}
	
	
	@BeforeMethod
	public void SetUp() throws InterruptedException {
		initialization();
		loginPage = new LoginPage();
		testutil = new TestUtil();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	
	
	@Test
	public void verifyHomePageTitleTest() {
		String homePageTitle = homePage.VarifyHomePageTitle();
		Assert.assertEquals(homePageTitle, prop.getProperty("browser_title") , "Home Page title is not matched");
	}
	
	
	@Test
	public void VerifynameUserTest() {
		Assert.assertTrue(homePage.VerifynameUser());
	}
	
	
	@Test
	public void VMwareTest() {
		homePage.clickOnVmware();
	}
	
	
	@AfterMethod
	public void tearDown() throws InterruptedException {
		homePage= new HomePage();
		testutil.logout();
		driver.quit();
	}


}
