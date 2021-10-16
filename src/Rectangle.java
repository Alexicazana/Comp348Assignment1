public class Rectangle extends PrintableObject implements Shape{


	private double length, width;
	
	public double getLength() {
		return this.length;
	}
	public double getWidth(){
		return this.width;	
	}
	
	public void setLength(double newLength) {
		this.length = newLength;
	}
	
	public void setWidth(double newWidth) {
		this.width = newWidth;
	}
	
	public double getPerimeter() {
		return (2*length) + (2*width);
	}
	
	public double getArea() {
		return length*width;
	}

	public String toString()
	{
		String str = this.getName() + "," + this.length + "," + this.width;

		return str;
	}

	public static Rectangle parse(String s) {
		

		String[] shapeInfo = s.split(",");

		if(shapeInfo[0].equals("Rectangle") ) {
			
			double l = Double.parseDouble(shapeInfo[1]);
			double w = Double.parseDouble(shapeInfo[2]);

			return new Rectangle(l, w);
			
		}

		return null;
		
	}
	
	public Rectangle(double l, double w)
	{
		this.length = l;
		this.width = w;
	}

	public Rectangle()
	{
		this.length = 0;
		this.width = 0;
	}
	
	
}
