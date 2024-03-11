class JRectangle {
	public static void main(String[] args) {
		// Test Case 1. Normal case
		try {
			// Arrange / Act
			double area = Rectangle.areaOfRectangle(2, 3.0);
			System.out.println("The area of Rectangle is : "+ area);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		
		// Test Case 2> Negative width
		try{
			double area = Rectangle.areaOfRectangle(-2, 3.0);
		}catch(IllegalArgumentException e) {
			System.out.println("Error: " + e.getMessage());
		}

		// Test Case 3> Negative length
		try{
			double area = Rectangle.areaOfRectangle(2, -3.0);
		}catch(IllegalArgumentException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}


	
}

class Rectangle {

	public static double areaOfRectangle(double width, double length) {

		if (width < 0) {
			throw new IllegalArgumentException("width must be greater than zero");
		}
		if (length < 0) {
			throw new IllegalArgumentException("length must be greater than zero");
		}

		return width * length;
	}
}