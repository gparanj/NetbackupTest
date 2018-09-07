package veritas.netbackup.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import veritas.netbackup.base.TestBase;
import veritas.netbackup.pages.HomePage;
import veritas.netbackup.pages.LoginPage;
import veritas.netbackup.pages.ProtectionPlanPage;
import veritas.netbackup.util.TestUtil;

public class ProtectionplanPageTest extends TestBase{
	
	TestUtil testutil;
	LoginPage loginPage;
	HomePage homePage;
	ProtectionPlanPage protectionplanPage;
	
	public ProtectionplanPageTest() {
		super();
	}
	
	@BeforeMethod
	public void SetUp() throws InterruptedException {
		initialization();
		loginPage = new LoginPage();
		protectionplanPage = new ProtectionPlanPage();
		testutil = new TestUtil();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		protectionplanPage = homePage.clickOnProtectionPlan();
	}

	
	@Test
	public void verifyProtectionPlanPageTitleTest() {
		String protectionplanPageTitle = protectionplanPage.VarifyProtectionPlanPageTitle();
		Assert.assertEquals(protectionplanPageTitle, prop.getProperty("browser_title") , "Protection Plan Page title is not matched");
	}
	
	
	@Test
	public void VerifyProtectionplanLabelTest() {
		Assert.assertTrue(protectionplanPage.VerifyprotectionPlanLabel());
		
	}
	
	@Test
	public void CreateTest(){
		protectionplanPage.clickOnCreate();
			
	}
	
	
	
	
	
	
	@AfterMethod
	public void tearDown() throws InterruptedException {
		homePage= new HomePage();
		testutil.logout();
		driver.quit();
	}

}
