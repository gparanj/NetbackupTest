package veritas.netbackup.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import veritas.netbackup.base.TestBase;

	public class DashboardPage extends TestBase{
	
				//Page Factory / Object Repository
		
			@FindBy(xpath="//*[@class='vdl-title-bar']//*[@class='vdl-title-bar-text']")
			WebElement nameuserLabel;
			
			@FindBy(xpath="//*[@class = 'vdl-sidenav-list']//*[contains(text(),' Dashboard')]")
			WebElement dashboard;
			
			@FindBy(xpath="//*[@class = 'vdl-sidenav-list']//*[contains(text(),' Jobs')]")
			WebElement jobs;
			
			@FindBy(xpath="//*[@class = 'vdl-sidenav-list']//*[contains(text(),' VMware')]")
			WebElement VMware;
			
			@FindBy(xpath="//*[@class = 'vdl-sidenav-list']//*[contains(text(),' Protection Plans')]")
			WebElement protectionplan;
			
			@FindBy(xpath="//*[@class = 'vdl-sidenav-list']//*[contains(text(),' RBAC')]")
			WebElement RBAC;
		
			@FindBy(xpath="//*[text()=' Jobs ']")
			WebElement jobs_box;
			
			@FindBy(xpath="//*[text()=' Certificates ']")
			WebElement certificates_box;
			
			@FindBy(xpath="//*[text()=' Tokens ']")
			WebElement tokens_box;
			
			@FindBy(xpath="//*[text()='Veritas Smart Meter']")
			WebElement smartmeter_box;
			
			@FindBy(xpath="//*[text()='Last 24 hours']")
			WebElement date_label;
			
			@FindBy(xpath="//*[text()=' Security events ']")
			WebElement security_events_box;
			
			@FindBy(xpath="//*[@class='day-of-week']")
			WebElement day_of_week;
			
			@FindBy(xpath="//*[@class='month']")
			WebElement date_and_month;
			
			@FindBy(xpath="//*[@src='./assets/img/smart-meter-1.svg']//parent::*")
			WebElement smartmeter_img1;
			
			@FindBy(xpath="//*[@src='./assets/img/smart-meter-2.svg']//parent::*")
			WebElement smartmeter_img2;
			
			@FindBy(xpath="//*[@src='./assets/img/smart-meter-3.svg']//parent::*")
			WebElement smartmeter_img3;
			
			@FindBy(xpath="//*[contains(text(), 'Monitor alerts for timely budget decisions')]")
			WebElement text1;
			
			@FindBy(xpath="//*[contains(text(), 'Spot usage trends and plan licensing effectively')]")
			WebElement text2;
			
			@FindBy(xpath="//*[contains(text(), 'View accurate, near real-time capacity usage reporting')]")
			WebElement text3;
			
			@FindBy(xpath="//*[@class='right-arrow']")
			WebElement right_arrow;
			
			
				//Initializing the Page Objects
			public DashboardPage() {
				PageFactory.initElements(driver, this);
	}
			
			
					//Actions
			public boolean VarifyJobsBox() {
				return jobs_box.isDisplayed();
			}
			
			public boolean VarifyCertificateBox() {
				return certificates_box.isDisplayed();
			}
			
			public boolean VarifyTokensBox() {
				return tokens_box.isDisplayed();
			}
			
			public boolean VarifySmartmeterBox() {
				return smartmeter_box.isDisplayed();
			}
			
			public boolean VarifyDate() {
				return date_label.isDisplayed();
			}
			
			public boolean VarifyDayOfWeek() {
				return day_of_week.isDisplayed();
			}
			
			public boolean VarifyDateAndMonth() {
				return date_and_month.isDisplayed();
			}
			
			public boolean VarifyFirstImg() {
				return smartmeter_img1.isDisplayed();
			}
			
			public boolean VarifyFirstText() {
				return text1.isDisplayed();
			}
			
			public boolean VarifySecondImg() {
				return smartmeter_img2.isDisplayed();
			}
			
			public boolean VarifySecondText() {
				return text2.isDisplayed();
			}
			
			public boolean VarifyThirdImg() {
				return smartmeter_img3.isDisplayed();
			}
			
			public boolean VarifyThirdText() {
				return text3.isDisplayed();
			}
			
			public void ClickOnRightArrow() {
				right_arrow.click();
			}
			
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
			
			public RBACPage clickOnRBAC() {
				RBAC.click();
				return new RBACPage();
			}
			
			
	}
