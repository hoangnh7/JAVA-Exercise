import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class App {
    public static void main(String[] args) throws Exception {
        List <Person> persons = Person.generateListOfPerson();
        // Sắp xếp theo tuổi
        // Collections.sort(persons, (Person person1 , Person person2)->{
        //     return person2.getName().compareTo(person1.getName());
        // } );
        // sắp xếp theo tên
        // Collections.sort(persons, (Person person1 , Person person2)-> person2.getAge().compareTo(person1.getAge())
        //  );
        // Sắp xếp xử dụng Predicate?
        // List<Person> persons = Person.generateListOfPerson();
    //     Predicate <Person> agPredicate = person -> {
    //         return person.getAge() >= 29;
    //     };
    //     System.out.println("List after softed");
    //     for (Person person: persons){
    //         person.showDetails();
    //     }
 // TRUYỀN PARAM DƯỚI DẠNG FUNCTION
    // Function <Person , String> showNameAndDetail = person -> {
    //     return "Name "+ person.getName() + " email " + person.getEmail();
    // };
    // Person personA = new Person("nguyễn huy hàong", "huyhoang.nguyen1@gmail.com", 35, null);
    // personA.showDetails(showNameAndDetail);
    //  }
 // DUYỆT, LỌC DỮ LIỆU DANH SÁCH SỬ DỤNG PREDICATE KẾT HỢP FILTER
        
    }
}