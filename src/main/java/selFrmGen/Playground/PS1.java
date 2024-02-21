package selFrmGen.Playground;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class PS1 {

	public void vikram() {
		System.out.println("Playing present");
	}
	
	@BeforeTest
	public void flashBack() {
		System.out.println("begin flashback");
	}
	
	@AfterTest
	public void theEnd(){
		System.out.println("End titles");
	}
}
