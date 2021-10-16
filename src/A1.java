import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Comparator;
import java.util.Arrays;

class A1 {
	public static void main(String [] args) {

		Scanner fIn = null;
		Shape[] shapes = null;

		try {
			FileReader fileReader = new FileReader("shapes.txt");
			int numLines = 0;
			Scanner tmpScanner = new Scanner(fileReader);
			
			//Count number of lines
			while(tmpScanner.hasNextLine()) {
				String s = tmpScanner.nextLine().split(",")[0];
				if(s.equals("Rectangle") || s.equals("Circle")) //Only count valid shapes as entries, non-valid lines are not added to number of Shapes.
					numLines++;
			}
			tmpScanner.close();
			fileReader.close();

			fileReader = new FileReader("shapes.txt"); //Re-open file to be at top
			fIn = new Scanner(fileReader);

			shapes = new Shape[numLines];
			int idx = 0;

			//Cycle each line
			while(fIn.hasNextLine()) {

				String str = fIn.nextLine();
				String shapeType = str.split(",")[0]; 

				switch(shapeType) {
					case "Circle":
						shapes[idx] = Circle.parse(str);
						idx++;
						break;
					case "Rectangle":
						shapes[idx] = Rectangle.parse(str);
						idx++;
						break;
					default: break;
				}

			}

			Arrays.sort(shapes, new Comparator<Shape>() {
				public int compare(Shape o1, Shape o2) 
				{
					if(o1.getName().equals(o2.getName())) {
						if(o1.getArea() == o2.getArea())
							return 0;

						return (o1.getArea() < o2.getArea()) ? -1 : 1;
					}
					
					return o1.getName().equals("Rectangle") ? -1 : 1;
				}
			});
	
			Printable.print(Arrays.copyOf(shapes, shapes.length, Printable[].class));

			fileReader.close();
			fIn.close();		
		}
		
		catch(FileNotFoundException e){
			System.out.println("An error has occured: File not found.");		
		}
		catch(Exception e) {
			System.out.println("Unknown error(s): " + e.getMessage());
		}
	
	}

}



