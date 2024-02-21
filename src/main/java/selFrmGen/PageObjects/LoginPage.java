package selFrmGen.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

//import Abstract.AbsComponents;
import selFrmGen.AbstractComponent.AbstractComponents;


public class LoginPage extends AbstractComponents{
	WebDriver driver;
	WebDriverWait wait;
	
	//Constructor that will be automatically called as soon as the object of the class is created
	public LoginPage(WebDriver driver) { //chg9
		super(driver); 
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="user-name")
	WebElement inp_username;
	
	@FindBy(id="password")
	WebElement inp_password;
	
	@FindBy(id="login-button")
	WebElement btn_submit;
	
	@FindBy(xpath="//h3[@data-test=\"error\"]")
	WebElement lockedOutLoginMsg;
	
//	method to navigate
		public void goTo() {
			driver.get("https://www.saucedemo.com/"); //https://propertypointuat.sd-apps.com/#/login
		}
	
	//method to enter username
	public void enteruser(String user) {
		waitForElementClickable(inp_username);
		inp_username.sendKeys(user);
	}
	
	//method to enter password
		public void enterpass(String pass) {
			waitForElementClickable(inp_password);
			inp_password.sendKeys(pass);
		}	

		//method to click submit
		public HomePage clickSubmit() {
			btn_submit.click();
			return new HomePage(driver);
		}	
		
		public String getInvalidLoginMsg(){
			return lockedOutLoginMsg.getText();
		}
}