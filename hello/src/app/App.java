package app;

import java.util.Date;

import javax.swing.plaf.synth.SynthStyle;

class Geometry{
    private String color;
    private Boolean isFilled;
    private Date createdDate;
    //getter, setter
    String getColor(){
        return this.color;
    }
    void setColor(String color){
        this.color = color;
    }
    Geometry(String color, Boolean isFilled){
        this.color= color;
        this.isFilled = isFilled;
        this.createdDate = new Date();
        System.out.printf("Constructor in Gemytry with color : %s"
        +"isFilled = %b at %s \n",color,isFilled,this.createdDate);
    }
    void showSomething (int x){
        System.out.printf("x = %d", x);
    }

}
class Rectangle extends Geometry {
    double with;
    double height;
    Rectangle(String color, Boolean isFilled, double with, double height){
        super(color, isFilled);
        this.with = with;
        this.height= height;
        System.out.println("Constructor in Geomitry");
    }
    @Override
    // nạp chồng 
    String getColor(){
        return super.getColor() + "of Rectangle";
    }
    void showSomething(String s){
        System.out.printf("s = %s",s);
    }
}
public class App {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle("red", true, 100, 40);
        System.out.println(rectangle.getColor());
    }
}
