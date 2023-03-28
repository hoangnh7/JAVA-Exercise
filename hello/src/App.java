
class Circle{
	double radius = 1.0;
	double x, y;
	// Hàm khởi tạo
	Circle(double radius, double x, double y){
		System.out.printf("Initializing object with"
				+ "radius : %f x: %f , y: %f\n", radius, x, y);
    this.radius = radius;
	this.x = x;
	this.y = y;
	}
	Circle(double x, double y){
		System.out.printf("Initializing object with"
				+ " x: %f , y: %f \n", radius, x, y);
	this.x = x;
	this.y = y;
	}
    //PHƯƠNG THỨC TÍNH DIỆN TÍNH
    double getArea(){
        return Math.PI * Math.pow(radius, 2);
    }
    //PHƯƠNG THỨC TÍNH CHU VI
    double getPerimeter(){
        return Math.PI * 2 *radius;
    }
    double distanceTo(Circle c){
        return Math.sqrt(Math.pow((this.x - c.x),2)+Math.pow((this.y - c.y),2));
    }
}

public class App {
	public static void main(String[] args) {
		Circle cirlce1 = new Circle (10.0, 0, 0 );
		System.out.printf("Area = %5.2f Perimeter = %.2f",cirlce1.getArea()
                                                , cirlce1.getPerimeter());
        Circle circle2 = new Circle (1.0 , 1.0);
        System.out.printf("Distance = %.2f",cirlce1.distanceTo(circle2));
		System.out.println("end of program");
	}
}