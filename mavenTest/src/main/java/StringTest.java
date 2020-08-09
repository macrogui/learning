import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StringTest {

    public static void main(String[] args) throws IOException {
        List<String> list = new ArrayList<String>();
        list.add("l1");
        list.add("l2");
        list.add("l3");
        System.out.println(String.join("\n\t", list));
    }
}
