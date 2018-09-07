package veritas.netbackup.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import veritas.netbackup.base.TestBase;

public class VMwarePage extends TestBase {
	
				//Page Factory / Object Repository
			@FindBy(xpath="//*[@class='vdl-title-bar-text']")
			WebElement VMwareLabel;
			
			@FindBy(linkText="Virtual machines")
			WebElement Virtual_machines;

			@FindBy(linkText="Servers")
			WebElement Servers;
			
			@FindBy(linkText="Intelligent VM groups")
			WebElement Intelligent_VM_groups;
			
			@FindBy(linkText="Instant access virtual machines")
			WebElement Instant_access_virtual_machines;
			
			@FindBy(id="vdl-radio-3")
			WebElement Esxi;
			
			@FindBy(id="vdl-radio-2")
			WebElement Vcenter;
			
			@FindBy(xpath="//*[@class='overlay-content__credentials']//*[@label='Username']//*//*//*//*[@placeholder='Username']")
			WebElement serverusername;
			
			@FindBy(xpath="//*[@class='overlay-content__credentials']//*[@label='Password']//*//*//*//*[@placeholder='Password']")
			WebElement serverpassword;
			
			
			//Initializing the Page Objects
			public VMwarePage() {
				PageFactory.initElements(driver, this);
	}
			
			//Actions
			public boolean VerifyVMwareLabel() {
				return VMwareLabel.isDisplayed();	
			}
			
			
			public String VarifyVMwarePageTitle() {
				return driver.getTitle();
			}
			

			public void clickOnServer() {
				Servers.click();
			}
			
			public boolean verifyIntelligentVMgroupsTab() {
				return Intelligent_VM_groups.isDisplayed();
			}
			
			public boolean verifyInstantAccessVirtualMachinesTab() {
				return Instant_access_virtual_machines.isDisplayed();
			}
			
			public boolean verifyVirtualMachinesTab() {
				return Virtual_machines.isDisplayed();
				
			}
			
			public void clickOnEsxi() {
				Esxi.click();
			}
			
			public void clickOnVcenter() {
				Vcenter.click();
			}
			
			public void serverUsername() {
				serverusername.sendKeys("root");
			}
			
			public void serverPassword() {
				serverpassword.sendKeys("Gyp.s8m");
			}
			
			public void clickOnVirtualMachineTab() {
				Virtual_machines.click();
			}
			
			public void clickOnIntelligentVMgroupsTab() {
				Intelligent_VM_groups.click();
			}
			
}
