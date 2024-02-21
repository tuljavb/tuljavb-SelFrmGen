package selFrmGen.Tests;

import org.testng.annotations.Test;

import junit.framework.Assert;
import selFrmGen.PageObjects.HomePage;
//import pages.ActionViewPage;
//import pages.HomePage;

public class StandardUserTests extends selFrmGen.TestComponent.BaseTestComponent {

	//DPTC01
	//DPTC02
	
@Test
public void standardUserLoginAndLogin() throws InterruptedException { //DP entry
//	navigate to AV to verify document intake tasks
	
	login.enteruser("standard_user"); // RyanUSTester
	login.enterpass("secret_sauce"); // us@t3st3r
	HomePage home = login.clickSubmit(); // home object created from method return
	Thread.sleep(5000);
	String logoText = home.getLogoText();
	System.out.println(logoText);
	Assert.assertTrue(logoText.equalsIgnoreCase("Swag Labs"));
	home.logoutStandardUser();
	}

//public void standardUserLogout() {
//	
//}


}
	