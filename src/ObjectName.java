public class ObjectName {
    public static void main(String[] args) {
        String s = "aaa";
        String name = s.getClass().getName();
        System.out.println(name.substring(name.lastIndexOf(".")+1));
    }
}
