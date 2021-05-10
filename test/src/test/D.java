package test;

public class D {

	int i;
D () 	{
		System.out.println("D:" + i);
		i = 5;

	}
}

class E extends D {
	E ()
	{
		System.out.println("E:" + i);
//		i = 6;

	}

public static void main(String[] args) { 
	System.out.println(new E() );


}

}
