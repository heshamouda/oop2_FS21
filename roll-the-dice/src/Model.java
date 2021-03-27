

public class Model {

	//number to be rolled
	public int dice=0;
	
	public void roll() {
		dice= (int) (Math.random()* 6)+1;
	}
}
