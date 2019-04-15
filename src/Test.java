/**
 * Created by cyd on 19-4-8.
 */

public class Test {
    public static void main(String[] args) {
        StringBuffer buffer = new StringBuffer("  ");
        System.out.println("调用前length:--"+buffer.length());
        System.out.println("调用前capacity:--"+buffer.capacity());
        buffer.trimToSize();
        System.out.println("调用后length:--"+buffer.length());
        System.out.println("调用后capacity:--"+buffer.capacity());
    }
}
