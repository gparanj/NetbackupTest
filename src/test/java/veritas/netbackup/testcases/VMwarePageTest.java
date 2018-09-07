package veritas.netbackup.testcases;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import veritas.netbackup.base.TestBase;
import veritas.netbackup.pages.HomePage;
import veritas.netbackup.pages.LoginPage;
import veritas.netbackup.pages.VMwarePage;
import veritas.netbackup.util.TestUtil;

public class VMwarePageTest extends TestBase {
	
	TestUtil testutil;
	LoginPage loginPage;
	HomePage homePage;
	VMwarePage vmwarePage;
	
	public VMwarePageTest() {
		super();
	}
	
	
	@BeforeMethod
	public void SetUp() throws InterruptedException {
		initialization();
		loginPage = new LoginPage();
		vmwarePage = new VMwarePage();
		testutil = new TestUtil();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		vmwarePage = homePage.clickOnVmware();
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
	public void VirtualMachinesTabTest() {
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
	
	
	@Test
	public void ServersTabTest() throws InterruptedException {
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		Assert.assertTrue(testutil.verifySearchButton());
		Assert.assertTrue(testutil.verifyRefreshButton());
		vmwarePage.clickOnServer();
		testutil.add();
		vmwarePage.clickOnEsxi();
		WebElement host1 = driver.findElement(By.xpath("//*[@class='overlay-content__credentials']//*//*//*//*//*[@placeholder='Host name']"));
		
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the name of Vsphere:");
		String host = scan.nextLine();
		
		System.out.println("The entered name is:");
		System.out.print(host);
		host1.sendKeys(host);
		
		Thread.sleep(2000);
		
		vmwarePage.serverUsername();
		vmwarePage.serverPassword();
		Thread.sleep(1000);
		
		testutil.save();
		testutil.Stop_Services();
		testutil.Start_Services();
		vmwarePage.clickOnVirtualMachineTab();
	}
		
		
		
		@Test
		public void clickOnIntelligentVMgroupsTab() {
			vmwarePage.clickOnVirtualMachineTab();
			Assert.assertTrue(testutil.verifySearchButton());
			Assert.assertTrue(testutil.verifyRefreshButton());
			Assert.assertTrue(testutil.verifyShowOrHideColoumnButton());
			Assert.assertTrue(testutil.add());
				
		}
		
		
		@Test
		public void clickOnVirtualMachineTab() {
			vmwarePage.clickOnVirtualMachineTab();
			Assert.assertTrue(testutil.verifySearchButton());
			Assert.assertTrue(testutil.verifyRefreshButton());
			Assert.assertTrue(testutil.verifyShowOrHideColoumnButton());
			Assert.assertTrue(testutil.verifyDensityDisplayButton());
			driver.manage().timeouts().implicitlyWait(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		}
	
	
	
	
	
	@AfterMethod
	public void tearDown() throws InterruptedException {
		homePage= new HomePage();
		testutil.logout();
		driver.quit();
	}

}
