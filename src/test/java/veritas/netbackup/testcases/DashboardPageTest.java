package veritas.netbackup.testcases;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import veritas.netbackup.base.TestBase;
import veritas.netbackup.pages.DashboardPage;
import veritas.netbackup.pages.LoginPage;
import veritas.netbackup.util.TestUtil;

public class DashboardPageTest extends TestBase {
	
	TestUtil testutil;
	LoginPage loginPage;
	DashboardPage dashboardPage;
	
	
	public DashboardPageTest() {
		super();
	}

	
	
	@BeforeMethod
	public void SetUp() throws InterruptedException {
		initialization();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		loginPage = new LoginPage();
		testutil = new TestUtil();
		dashboardPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	
		}
	
	@Test
	public void verifyHomePageTitleTest() {
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		String homePageTitle = dashboardPage.VarifyHomePageTitle();
		Assert.assertEquals(homePageTitle, prop.getProperty("browser_title") , "Home Page title is not matched");
	}
	
	
	@Test
	public void VerifynameUserTest() {
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		Assert.assertTrue(dashboardPage.VerifynameUser());
	}
	
	
	@Test
	public void verifyJobBoxTest() {
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		Assert.assertTrue(dashboardPage.VarifyJobsBox());
	}
	
	@Test
	public void verifyCertificateBoxTest() {
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		Assert.assertTrue(dashboardPage.VarifyCertificateBox());
	}
	
	@Test
	public void verifyTokensBoxTest() {
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		Assert.assertTrue(dashboardPage.VarifyTokensBox());
	}
	
	@Test
	public void verifySmartmeterBoxTest() throws InterruptedException {
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		Assert.assertTrue(dashboardPage.VarifySmartmeterBox());
		Thread.sleep(1000);
		Assert.assertTrue(dashboardPage.VarifyFirstImg());
		Assert.assertTrue(dashboardPage.VarifyFirstText());
		dashboardPage.ClickOnRightArrow();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		Assert.assertTrue(dashboardPage.VarifySecondImg());
		Assert.assertTrue(dashboardPage.VarifySecondText());
		dashboardPage.ClickOnRightArrow();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		Assert.assertTrue(dashboardPage.VarifyThirdImg());
		Assert.assertTrue(dashboardPage.VarifyThirdText());
	}
	
	@Test
	public void verifyDateTest() {
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		Assert.assertTrue(dashboardPage.VarifyDate());
	}
	
	@Test
	public void verifyDayOfWeekTest() {
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		Assert.assertTrue(dashboardPage.VarifyDayOfWeek());
	}
	
	@Test
	public void verifyDateAndMonthTest() {
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		Assert.assertTrue(dashboardPage.VarifyDateAndMonth());
	}
	
	
	@AfterMethod
	public void tearDown() throws InterruptedException {
		dashboardPage= new DashboardPage();
		testutil.logout();
		driver.quit();
	}
		
}
