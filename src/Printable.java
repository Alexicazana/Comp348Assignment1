
public interface Printable {

	public void print();
	
	public static void print(Printable... printables) {
		for(Printable p : printables)
			p.print();
	}
}
