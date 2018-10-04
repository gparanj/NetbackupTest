package veritas.netbackup.testcases;

import java.awt.AWTException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import veritas.netbackup.base.TestBase;
import veritas.netbackup.pages.CreateProtectionPlanPage;
import veritas.netbackup.pages.DashboardPage;
import veritas.netbackup.pages.LoginPage;
import veritas.netbackup.pages.ProtectionPlanPage;
import veritas.netbackup.util.TestUtil;

public class CreateProtectionPlanPageTest extends TestBase {
	
	TestUtil testutil;
	LoginPage loginPage;
	DashboardPage dashboardPage;
	ProtectionPlanPage protectionplanPage;
	CreateProtectionPlanPage createprotectionplanPage;
	
	String sheetName="NameDescription";
	
	public CreateProtectionPlanPageTest() {
		super();
	}
	
	@BeforeMethod
	public void SetUp() throws InterruptedException {
		initialization();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		loginPage = new LoginPage();
		protectionplanPage = new ProtectionPlanPage();
		createprotectionplanPage = new CreateProtectionPlanPage(); 
		testutil = new TestUtil();
		dashboardPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		protectionplanPage = dashboardPage.clickOnProtectionPlan();
		createprotectionplanPage = protectionplanPage.clickOnCreate();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		
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
	
	@DataProvider
	public Object[][] getNetbackupTestData() {
		Object data[][]= TestUtil.getTestData(sheetName);
		return data;	
	}
	
	@Test(dataProvider="getNetbackupTestData")
	public void CreateTest(String name, String description) throws InterruptedException, AWTException {
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		createprotectionplanPage.clickOngetname(name);
		createprotectionplanPage.clickOngetdescription(description);
		Thread.sleep(1000);
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
		dashboardPage= new DashboardPage();
		testutil.logout();
		driver.quit();
	}


}
