package selFrmGen.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import selFrmGen.AbstractComponent.AbstractComponents;

public class HomePage extends AbstractComponents {
	WebDriver driver;
	
	//Constructor that will be automatically called as soon as the object of the class is created
	public HomePage(WebDriver driver) {
		super(driver); 
		this.driver = driver;
	}
	
	By div_logoText = By.xpath("//div[@class='app_logo']");
	
	@FindBy(id="react-burger-menu-btn")
	WebElement burgerIcon;
	@FindBy(id="logout_sidebar_link")
	WebElement logoutLink;
	
	//Method to capture the page heading
	public String getLogoText() {
		String msg = driver.findElement(div_logoText).getText();
		return msg;
	}
	
	public void logoutStandardUser() {
//		waitForElementClickable(burgerIcon);
		clickElement(burgerIcon);
//		burgerIcon.click();
		clickElement(logoutLink);
//		logoutLink.click();
	}
	
//	public String getFirstName() {
//		String firstName = getWelcomeText().split(", ")[1].trim().toLowerCase();
//		return firstName;
//	}
}
