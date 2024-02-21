package selFrmGen.Playground;

public class PS2 extends PS3 {
	int a; //global class variable 
	
	public PS2(int a) { //instance variable
		// TODO Auto-generated constructor stub
		super(a);
		this.a=a; //global class variable = instance variable
	}

	public int increment() {
		a = a+1;
		return a;
	}
	
	public int decrement() {
		a = a-1;
		return a;
	}

}
