import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;

public class Add {
    @Retention(RetentionPolicy.RUNTIME)
    @interface invTest{
        String[] values() default "unknown";
    }

    @invTest(values={"girl","boy"})
    public void somebody(String name, int age){
        System.out.println("\nsomebody: "+name+", "+age);
    }

    public static void main(String[] args) throws IOException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        int a = 2;
        int b = 4;
        int c = a + b;
//        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
//        inputStreamReader.read();

        Add add = new Add();
        Class<Add> addClass = Add.class;
        Method somebody = addClass.getMethod("somebody", String.class, int.class);
        somebody.invoke(add, new Object[]{"gyc", 20});
    }
}
