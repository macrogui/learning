import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class SetTest {

    public static void main(String[] args) {
        String str = "hello,world";
        char[] chars = str.toCharArray();
        Map<Character, Integer> map = new HashMap();
        for (char c : chars) {
            if (map.get(c)==null){
                map.put(c, 1);
            } else {
                map.put(c, map.get(c)+1);
            }
        }
        System.out.println(map);
//        Map<Character, Integer> map = new HashMap<>();
//        for (int i = 0; i < str.length(); i++) {
//            Set<Character> set = map.keySet();
//            Iterator<Character> it = set.iterator();
//            while (it.hasNext()){
//                map.put(str.charAt(i), map.get(str.charAt(i))+1);
//                System.out.println(map);
//            }
//        }
    }
}
