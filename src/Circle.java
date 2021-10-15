
public class Circle extends PrintableObject implements Shape {

	private double radius;
	
	public String getName(){
		return Circle.class.getSimpleName().toUpperCase();
		
	}
	
	public double getRadius() {
		return this.radius;
	}
	
	public void setRadius(double newRadius) {
		this.radius = newRadius;
	}

	@Override
	public double getPerimeter() {
		return (2*3.1415926535*radius);
	}

	@Override
	public double getArea() {
		return (3.14115926535*radius*radius);
	}
	
	
	

	public static Circle parse(String s) {
		
		
		
		String[] shapeInfo = s.split(",");
		
		if(shapeInfo[0] == "Circle") {
			
			double r = Double.parseDouble(shapeInfo[1]);

			
			
			return new Circle(r);
			
		}
		
		return null;
	}
	
	
	
	
	
	public Circle(double r)
	{
		this.radius = r;
		//Copy cons
	}
}
