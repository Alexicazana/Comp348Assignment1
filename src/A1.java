import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


 class A1 {
	
	public static void main(String [] args) {
		
		File f = new File("shapes.txt");
		Scanner fIn = new Scanner (f);
		
		
		try {
			fIn.nextLine();
			
		}
		
		catch(FileNotFoundException e){
			System.out.println("An error has occured: File not found.");
	
			
		}
		catch(Exception e) {
			System.out.println("Unknown errors");
		}
		
		f.close();
		fIn.close();
		
	}

}



