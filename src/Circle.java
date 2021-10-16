
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

	public double getPerimeter() {
		return (2*Math.PI*radius);
	}

	public double getArea() {
		return (Math.PI*radius*radius);
	}
	
	public String toString()
	{
		String ret = this.getName() + "," + this.radius;

		return ret;
	}

	public static Circle parse(String s) {
		
		String[] shapeInfo = s.split(",");
		
		if(shapeInfo[0].equals("Circle")) {
			
			double r = Double.parseDouble(shapeInfo[1]);

			return new Circle(r);
			
		}
		
		return null;
	}
	
	public Circle(double r)
	{
		this.radius = r;
	}

	public Circle()
	{
		this.radius = 0;
	}
}
