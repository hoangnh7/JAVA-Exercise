package AbstractClass;

public class Rectangle extends Shape {
    //Các thuộc tính thêm vào Shape
    Double width;
    Double height;
    @Override 
    public double area(){
        return width*height;
    }    
    public void draw(){
        System.out.println("drawing a rectanlge");
    }
    //Constructor
    Rectangle(String name, double width, double height){
        super(name);
        this.width = width;
        this.height=height;
    }
}
