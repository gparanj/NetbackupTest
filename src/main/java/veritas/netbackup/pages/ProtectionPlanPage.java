package veritas.netbackup.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import veritas.netbackup.base.TestBase;

public class ProtectionPlanPage extends TestBase {
	
		//Page Factory / Object Repository
	@FindBy(xpath="//*[@class='vdl-title-bar-text']")
	WebElement  protectionplansLabel;
	
	@FindBy(linkText="Protection plans")
	WebElement protection_plans;
	
	@FindBy(xpath="//button[@class='mini vo ng-star-inserted']")
	WebElement create;
	
	//Initializing the Page Objects
	public ProtectionPlanPage() {
		PageFactory.initElements(driver, this);
	}
	
		//Actions
	public String VarifyProtectionPlanPageTitle() {
		return driver.getTitle();
	}
	
	public boolean VerifyprotectionPlanLabel() {
		return protectionplansLabel.isDisplayed();	
	}
	
	
	public CreateProtectionPlanPage clickOnCreate() {
		create.click();
		return new CreateProtectionPlanPage();
	}
	
	
	
}


