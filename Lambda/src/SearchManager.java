import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class SearchManager {
    private Map<String, Predicate> searchMap = new HashMap<>();

    //constructor
    private SearchManager(){
        super();
    }
    public static SearchManager getInstance(){
        return new SearchManager();
    }
}
