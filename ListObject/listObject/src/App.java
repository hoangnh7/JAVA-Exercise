import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;

public class App {
    public static void main(String[] args) {
        System.out.println("Tạo tập hợp(Set) các đối tượng Products");
        Product product1 = new Product("iphone X", 5, 2500);
        Product product2 = new Product("iphone 6", 6, 2600);
        Product product3 = new Product("iphone 7", 9, 2900);
        Product product4 = new Product("iphone 8", 10, 3200);
        HashSet<Product> products = new HashSet<>();
        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);
        products.add(product2);//Không báo lỗi nhưng ko được thêm vào
        //Set ko theo thứ tự ban đầu
        products.forEach(product -> {
            product.printDetail();
        });
        //Số các phần tử trong Set
        System.out.println("Number of products = "+products.size());
        //Nhân bản 1 Set
        HashSet<Product> products2 = (HashSet<Product>) products.clone();
        System.out.println("products = "+products);
        System.out.println("products2 = "+products2);
        products2.forEach(product -> {
            product.printDetail();
        });
    }



    //TẠO LIST PRODUCT
    public static void main001(String[] args) throws Exception {
        List <Product> products = new ArrayList<Product>();
        Product product1 = new Product("iphone x", 5, 2600);
        Product product2 = new Product("iphone 6", 6, 2600);
        Product product3 = new Product("iphone 7", 9, 2900);
        Product product4 = new Product("iphone 8", 10, 3200);
        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);
        //Cho phép nhiều đối tượng trùng nhau trong 1 list
        //products.add(product2);
        //Xoá hết các phần tử trong List ?
        //products.clear();
        //Lấy object tại vị trí bất kỳ
        products.get(2).printDetail();
        //Duyệt danh sách trong List
        products.forEach(product -> {
            product.printDetail();
        });
        System.out.println(products);
        System.out.println("Duyệt bằng Iterator");
        ListIterator<Product> iterator = products.listIterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            product.printDetail();
        }
        System.out.println("Duyệt theo thứ tự ngược lại");
        while (iterator.hasPrevious()) {
            Product product = iterator.previous();
            product.printDetail();
        }
    }
}
