/**
 * Created by cyd on 19-4-8.
 */

public class Test {
    public static void main(String[] args) {
        ClassLoader c = Test.class.getClassLoader();
        while(c != null) {
            System.out.println(c.toString());
            c = c.getParent();
        }
    }
}
