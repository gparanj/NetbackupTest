package veritas.netbackup.testcases;

import java.awt.AWTException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import veritas.netbackup.base.TestBase;
import veritas.netbackup.pages.CreateProtectionPlanPage;
import veritas.netbackup.pages.HomePage;
import veritas.netbackup.pages.LoginPage;
import veritas.netbackup.pages.ProtectionPlanPage;
import veritas.netbackup.util.TestUtil;

public class CreateProtectionPlanPageTest extends TestBase {
	
	TestUtil testutil;
	LoginPage loginPage;
	HomePage homePage;
	ProtectionPlanPage protectionplanPage;
	CreateProtectionPlanPage createprotectionplanPage;
	
	public CreateProtectionPlanPageTest() {
		super();
	}
	
	@BeforeMethod
	public void SetUp() throws InterruptedException {
		initialization();
		loginPage = new LoginPage();
		protectionplanPage = new ProtectionPlanPage();
		createprotectionplanPage = new CreateProtectionPlanPage(); 
		testutil = new TestUtil();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		protectionplanPage = homePage.clickOnProtectionPlan();
		createprotectionplanPage = protectionplanPage.clickOnCreate();
		
	}
	
	
	@Test
	public void verifyCreateProtectionPlanPageTitleTest() {
		String createprotectionplanPageTitle = createprotectionplanPage.VarifyCreateProtectionPlanPageTitle();
		Assert.assertEquals(createprotectionplanPageTitle, prop.getProperty("browser_title") , "Create Protection Plan Page title is not matched");
	}
	
	
	@Test
	public void VerifyCreateProtectionPlanLabelTest() {
		Assert.assertTrue(createprotectionplanPage.VerifyCreateProtectionPlanLabel());
		
	}
	
	@Test
	public void CreateTest() throws InterruptedException, AWTException {
		testutil.Name_Discription();
		createprotectionplanPage.clickOnNext();
		testutil.save();
		testutil.scrolldown();
		createprotectionplanPage.clickOnRetention();
		testutil.scrolldown();
		createprotectionplanPage.clickOnNext();
		createprotectionplanPage.clickOnNext();
		createprotectionplanPage.clickOnFinish();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		protectionplanPage.VerifyprotectionPlanLabel();
			
	}
	
	
	
	
	
	@AfterMethod
	public void tearDown() throws InterruptedException {
		homePage= new HomePage();
		testutil.logout();
		driver.quit();
	}


}
