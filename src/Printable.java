
public interface Printable {

	public void print();
	
	public static void print(Printable[] printables) {
		
		for(int i=0; i<printables.length; i++) {
			
			printables[i].print();
			
		}
	}
}
