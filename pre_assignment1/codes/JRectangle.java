class JRectangle {
	public static void main(String[] args) {
		
		double area = areaOfRectangle(2, 3.0);
		System.out.println("The area of Rectangle is : "+ area);
	}


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