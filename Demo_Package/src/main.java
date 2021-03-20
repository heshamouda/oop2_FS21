import newPackage.Hans; //import class Hans
import otherPackage.*; //import all classes
import newPackage.*;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Aufstarten");
		Hans hans= new Hans();  
		
		newPackage.A a= new newPackage.A(); //to avoid a conflict of the same classes's name, so define which class is used
		
	}

}
