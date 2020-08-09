import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashMapTest {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>(2);
        map.put("a",1);
        map.put("b",2);
        map.put("c",3);
        List<Integer> array = new ArrayList<>();
        array.add(1);
        Map<String, List<Integer>> m = new HashMap<>();
        m.put("d", array);
        m.get("d").add(2);
        m.get("d").add(3);
    }
}
