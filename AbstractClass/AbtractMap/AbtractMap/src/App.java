import java.util.AbstractMap;
import java.util.HashMap;

public class App {
    public static void main(String[] args) throws Exception {
        AbstractMap< String ,Object > mapEmployee = new HashMap<String,Object> ();
        if (mapEmployee.isEmpty()){
            System.out.println("Hashmap is empty");
        }
        mapEmployee.put("name","hoang");
        mapEmployee.put("age",30);
        System.out.println("Detail employee: ");
        System.out.println("Name: "+mapEmployee.get("name")+".Age:"+mapEmployee.get("age"));
        System.out.println("Size: "+mapEmployee.size());
        //Map thích hợp với trường hợp số lượng các key nhiều, VD: các điểm trên đồ thị
        AbstractMap<Double, Double> mapPoints = new HashMap<Double, Double>();
        mapPoints.put(1.0, 5.0); //x = 1.0 thì y = 5.0
        mapPoints.put(2.0, 7.0); //x = 2.0 thì y = 7.0
        mapPoints.put(3.5, 6.0); //x = 3.5 thì y = 6.0
        //Có thể thêm / bớt tuỳ ý các key-value
        mapPoints.remove(3.5);
        mapPoints.forEach((key,value)->{
            System.out.println("key  " + key +"value " +value );
        });
        
        System.out.println("Hashcode: "+mapPoints.hashCode());
        //Phương thức equals
        AbstractMap<String, Object> mapEmployee2 = new HashMap<String, Object>();
        mapEmployee2.put("name", "Hoang");
        mapEmployee2.put("age", 30);
        System.out.println(mapEmployee.equals(mapEmployee2));
    }
}
