import java.util.Arrays;
import java.util.List;

public class AcceptMethod {
    public static void  printValur(String str){
        System.out.println("print value : "+str);
    }

    public static void main(String[] args) {
        List<String> al = Arrays.asList("a","b","c","d");
        //下面的for each循环和上面的循环是等价的
        al.forEach(AcceptMethod::printValur);
    }
}
