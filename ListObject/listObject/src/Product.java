public class Product {
    String name;
    int quantity;
    double price;
    Product(String name, int quantity, double price){
        this.name= name;
        this.quantity = quantity;
        this.price = price;
    }
    public void printDetail(){
        System.out.println("Name : " + name + " Quantity: "+quantity+ 
        " Price: "+ price);
    }
}
