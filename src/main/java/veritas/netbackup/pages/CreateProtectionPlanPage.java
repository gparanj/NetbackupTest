package veritas.netbackup.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import veritas.netbackup.base.TestBase;

public class CreateProtectionPlanPage extends TestBase {
	
		//Page Factory / Object Repository
	@FindBy(xpath="//*[contains(text(),' Create protection plan ')]")
	WebElement  createprotectionplansLabel;
	
	@FindBy(xpath="//button[@class='mini vo ng-star-inserted']")
	WebElement create;
	
	@FindBy(xpath="//*[@class='vdl-button-bar']//*[text()=' Next ']")
	WebElement next;
	
	@FindBy(xpath="//*[contains(text(),'Keep a copy for long-term retention')]")
	WebElement retention;
	
	@FindBy(xpath="//*[contains(text(),'Finish')]")
	WebElement finish;
	
	@FindBy(id="name")
	WebElement name;
	
	@FindBy(id="description")
	WebElement description;
	
	
	
	//Initializing the Page Objects
		public CreateProtectionPlanPage() {
			PageFactory.initElements(driver, this);
		}
		
			//Actions
		public String VarifyCreateProtectionPlanPageTitle() {
			return driver.getTitle();
		}
	
		public boolean VerifyCreateProtectionPlanLabel() {
			return createprotectionplansLabel.isDisplayed();	
		}
		
		public void clickOnCreate() {
			create.click();
		}

		public void clickOnNext() {
			next.click();	
		}
		
	
		public void clickOnRetention() {
			retention.click();	
		}
	
		public void clickOnFinish() {
			finish.click();		
		}
		
		public void clickOngetname(String ProtectionplanName) {
			name.sendKeys(ProtectionplanName);		
		}
		
		public void clickOngetdescription(String ProtectionplanDescription) {
			description.sendKeys(ProtectionplanDescription);		
		}
	}
