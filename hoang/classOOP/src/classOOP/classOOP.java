package classOOP;
class Circle{
	double radius = 1.0;
	double x, y;
	// Hàm khởi tạo
	Circle(double radius, double x, double y){
		System.out.printf("Initializing object with"
				+ "radius : %f x: %f , y: %f", radius, x, y);
	this.x = x;
	this.y = y;
	}
	Circle(double x, double y){
		System.out.printf("Initializing object with"
				+ " x: %f , y: %f", radius, x, y);
	this.x = x;
	this.y = y;
	}
}

public class classOOP {
	public static void main(String[] args) {
		Circle cirlce1 = new Circle (10.0, 0, 0 );
		Circle circle2 = new Circle (1.0 , 1.0);
		System.out.println("end of program");
	}
}
