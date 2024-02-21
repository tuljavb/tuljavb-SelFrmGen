package selFrmGen.Playground;

import org.testng.annotations.Test;

public class PS extends PS1 {
	
	@Test
	public void all() {
	
		vikram(); //from PS1
		int a = 5;
		
		
		PS2 ps2 = new PS2(a); //parameterized constructor //from PS2
		int x = ps2.increment();
		int y = ps2.decrement();
		System.out.println(x);
		System.out.println(y);
		
//		PS3 ps3 = new PS3(a);
		int z = ps2.multiplyFive();
		System.out.println(z);
	}
}
