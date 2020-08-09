import java.util.ArrayList;
import java.util.List;

public class ListToJson {
    public static void main(String[] args) {
        List<Fish> arr = new ArrayList<>();
        arr.add(new Fish("peter", 12));
        arr.add(new Fish("dam", 15));

        System.out.println(arr);
    }
}
class Fish{
    private String name;
    private int size;

    public Fish(String name, int size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public String toString() {
        return "Fish{" +
                "name='" + name + '\'' +
                ", size=" + size +
                '}';
    }
}
