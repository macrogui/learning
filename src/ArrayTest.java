import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayTest {
    public static void main(String[] args) {
        Integer[] arr = {1,2,3};
        List list = Arrays.asList(arr);
        System.out.println(list);
        Collections.addAll(new ArrayList<>(), arr);
    }
}
