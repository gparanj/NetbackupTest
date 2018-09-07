package veritas.netbackup.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import veritas.netbackup.base.TestBase;

	public class HomePage extends TestBase {
		
		
		
		//Page Factory / Object Repository
		@FindBy(xpath="//*[@class='vdl-title-bar-text']")
		WebElement nameuserLabel;
		
		@FindBy(xpath="//*[@class = 'vdl-sidenav-list']//*[contains(text(),' Dashboard')]")
		WebElement dashboard;
		
		@FindBy(xpath="//*[@class = 'vdl-sidenav-list']//*[contains(text(),' Jobs')]")
		WebElement jobs;
		
		@FindBy(xpath="//*[@class = 'vdl-sidenav-list']//*[contains(text(),' VMware')]")
		WebElement VMware;
		
		@FindBy(xpath="//*[@class = 'vdl-sidenav-list']//*[contains(text(),' Protection Plans')]")
		WebElement protectionplan;
		
		
				//Initializing the Page Objects
				public HomePage() {
					PageFactory.initElements(driver, this);
		}
				
				//Actions
				public String VarifyHomePageTitle() {
					return driver.getTitle();
				}
				
				public boolean VerifynameUser() {
					return nameuserLabel.isDisplayed();	
				}
				
				public DashboardPage clickOnDashboard(){
					dashboard.click();
					return new DashboardPage();
				}
				
				public JobsPage clickOnJobs() {
					jobs.click();
					return new JobsPage();
				}
				
				public VMwarePage clickOnVmware() {
					VMware.click();
					return new VMwarePage();
				}
				
				public ProtectionPlanPage clickOnProtectionPlan() {
					protectionplan.click();
					return new ProtectionPlanPage();
				}
				
		}
	