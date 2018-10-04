package veritas.netbackup.testcases;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import veritas.netbackup.base.TestBase;
import veritas.netbackup.pages.DashboardPage;
import veritas.netbackup.pages.LoginPage;
import veritas.netbackup.pages.VMwarePage;
import veritas.netbackup.util.TestUtil;

public class VMwarePageTest extends TestBase {
	
	TestUtil testutil;
	LoginPage loginPage;
	DashboardPage dashboardPage;
	VMwarePage vmwarePage;
	
	String sheetName="ESXi";
	
	public VMwarePageTest() {
		super();
	}
	
	
	@BeforeMethod
	public void SetUp() throws InterruptedException {
		initialization();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		loginPage = new LoginPage();
		vmwarePage = new VMwarePage();
		testutil = new TestUtil();
		dashboardPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		vmwarePage = dashboardPage.clickOnVmware();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		
	}
	
	
	@Test
	public void verifyVMwarePageTitleTest() {
		String vmwarePageTitle = vmwarePage.VarifyVMwarePageTitle();
		Assert.assertEquals(vmwarePageTitle, prop.getProperty("browser_title") , "Protection Plan Page title is not matched");
	}
	
	
	@Test
	public void VerifyVMwareLabelTest() {
		Assert.assertTrue(vmwarePage.VerifyVMwareLabel());
		
	}
	
	
	@Test
	public void VirtualMachinesTabTest() throws InterruptedException {
		boolean VMT = vmwarePage.verifyVirtualMachinesTab();
		Assert.assertTrue(VMT);
	}
	
	
	@Test
	public void IntelligentVMgroupsTabTest() {
		boolean IVMGT = vmwarePage.verifyIntelligentVMgroupsTab();
		Assert.assertTrue(IVMGT);
	}
	
	
	@Test
	public void InstantAccessVirtualMachinesTabTest() {
		boolean IAVMT = vmwarePage.verifyInstantAccessVirtualMachinesTab();
		Assert.assertTrue(IAVMT);
	}
	
	@DataProvider
	public Object[][] getNetbackupTestData() {
		Object data[][]= TestUtil.getTestData(sheetName);
		return data;
		
	}
	
	
	@Test(dataProvider="getNetbackupTestData")
	public void ServersTabTest(String Name) throws InterruptedException{
		Assert.assertTrue(testutil.verifySearchButton());
		Assert.assertTrue(testutil.verifyRefreshButton());
		vmwarePage.clickOnServer();
		testutil.add();
		vmwarePage.clickOnEsxi();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		vmwarePage.gethostname(Name);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		vmwarePage.serverUsername();
		vmwarePage.serverPassword();
		testutil.save1();
		testutil.Stop_Services();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		testutil.Start_Services();
		driver.navigate().refresh();	

	}	
		
		@Test
		public void clickOnIntelligentVMgroupsTab() throws InterruptedException {
			vmwarePage.clickOnIntelligentVMgroupsTab();
			driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			Assert.assertTrue(testutil.verifySearchButton());
			Assert.assertTrue(testutil.verifyRefreshButton());
			Assert.assertTrue(testutil.verifyShowOrHideColoumnButton());
			Assert.assertTrue(testutil.verifyAdd());
				
		}
		
		
		@Test
		public void clickOnVirtualMachineTab() throws InterruptedException {
			vmwarePage.clickOnVirtualMachineTab();
			driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			Assert.assertTrue(testutil.verifySearchButton());
			Assert.assertTrue(testutil.verifyRefreshButton());
			Assert.assertTrue(testutil.verifyShowOrHideColoumnButton());
			Assert.assertTrue(testutil.verifyDensityDisplayButton());
			driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			vmwarePage.clickOnVM();
			vmwarePage.clickOnConfigureProtection();
			Thread.sleep(1000);
			vmwarePage.clickOnProtect();
			driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			vmwarePage.clickOnClose();
			driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			driver.navigate().refresh();
			driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

		}
	
	
	
	
	
	@AfterMethod
	public void tearDown() throws InterruptedException {
		dashboardPage= new DashboardPage();
		testutil.logout();
		driver.quit();
	}

}
