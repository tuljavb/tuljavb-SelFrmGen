package selFrmGen.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

//import baseTest.BaseTestComponent;
//import pages.HomePage;
import selFrmGen.TestComponent.BaseTestComponent;
import selFrmGen.PageObjects.HomePage;

public class invalidLoginTest extends selFrmGen.TestComponent.BaseTestComponent {
	
	@Test (groups = {"invalidlogin"})
	public void invalidLoginTest1() throws InterruptedException {
		login.enteruser("RyanUSTester000");
		login.enterpass("us@t3st3r");
		HomePage home = login.clickSubmit(); //home object created from method return
		login.clickSubmit();
		Thread.sleep(5000);
		String msg = login.getInvalidLoginMsg();
		System.out.println(msg);
		Assert.assertEquals(msg, "The user name or password is incorrect.");
	}

}
