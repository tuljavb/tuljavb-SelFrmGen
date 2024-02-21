package selFrmGen.AbstractComponent;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

//import pages.ActionViewPage;
//import pages.DocumentIntakePage;

public class AbstractComponents {

	WebDriver driver;
	JavascriptExecutor executor;
	
	
	public AbstractComponents(WebDriver driver) { //chg2
		this.driver = driver;
	    this.executor = (JavascriptExecutor) this.driver;
		PageFactory.initElements(driver, this);
	}
	
	public void zoomPageAt(String decimalPercent) {
		executor.executeScript("document.body.style.zoom = '"+decimalPercent+"'");
//		executor.executeScript("document.body.style.zoom = '0.75'");
	}
	
//	pageFactory
	@FindBy(xpath="//a[contains(text(),'ACT')]")
	WebElement actM;
	
	@FindBy(xpath="//a[contains(text(),'Intake Documents')]")
	WebElement diOption;
	
	@FindBy(xpath="//a[contains(text(),'New Action View')]")
	WebElement newAVOption;
	
	public void clickMenuOption(WebElement we1, WebElement we2) {
		hoverOverElement(we1);
		waitForElementClickable(we2);
		we2.click();
	}
	
	/*
	 * public DocumentIntakePage navigatetoDIPage() { clickMenuOption(actM,
	 * diOption); return new DocumentIntakePage(driver); }
	 * 
	 * public ActionViewPage navigatetoAVPage() { clickMenuOption(actM,
	 * newAVOption); return new ActionViewPage(driver); }
	 */
	
	public void hoverActMenu() {
		hoverOverElement(actM);
}	
			
	public void clickDocIntOption() {
		waitForElementClickable(diOption);
		diOption.click();
	}
	
	public void waitForElementClickable(WebElement we) {
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
	wait.until(ExpectedConditions.elementToBeClickable(we));
	}
	
	public void clickElement(WebElement we) {
		waitForElementClickable(we);
		we.click();
	}
	
	public void hoverOverElement(WebElement we) {
		Actions act = new Actions(driver);
		act.moveToElement(we).build().perform();
	}
	
	public void scrollToElement(WebElement we) {
		Actions act = new Actions(driver);
		act.scrollToElement(we).build().perform();
	}
	
	public void scrollToViewElement(WebElement we) {
		waitForElementClickable(we);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", we);
//		Actions act = new Actions(driver);
//		act.moveToElement(we).build().perform();
		we.click();

	}
	
	public void scrollByDimension(int x, int y) {
		String Dimension = "window.scrollTo("+x+","+y+")";
		System.out.println(Dimension);
		executor.executeScript(Dimension);

	}
	
		
	public void verifyElementDisplayed(By findBy) {
		Assert.assertTrue(driver.findElement(findBy).isDisplayed());
	}
	
	public void verifyWebElementDisplayed(WebElement we) {
		Assert.assertTrue(we.isDisplayed());
	}
	
	public WebElement returnWebElement(WebElement we) {
		return we;
	}
	
	
//	String labelName;
	@FindBy(xpath="//input/parent::label")
	List<WebElement> inputLabels;
	
	public void clickRadioButtonwithLabel(String labelName) {

		for (WebElement il : inputLabels) {
			if(il.getText().equalsIgnoreCase(labelName)) {
//				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", il);
//				hoverOverElement(il);
//				waitForElementClickable(il);
//				scrollToElement(il);
				il.click();
				break;
//				executor.executeScript("arguments[0].scrollIntoView(true);", il);
//				
			}	
		}
	}
	
}
