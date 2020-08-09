import java.util.ArrayList;
import java.util.Random;

public class Memory {
    public static void main(String[] args) {
        long max = Runtime.getRuntime().maxMemory();
        long memory = Runtime.getRuntime().totalMemory();
        long free = Runtime.getRuntime().freeMemory();
        System.out.println(max/1024/1024+"MB");
        System.out.println(memory/1024/1024+"MB");
        System.out.println(free/1024/1024+"MB");
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            try {
                arr.add(new Random().nextInt(99999999));
            }catch (Error e){
                System.out.println(i);
            }
        }
    }
}
