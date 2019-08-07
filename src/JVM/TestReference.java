package JVM;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

public class TestReference {
    public static void main(String[] args) {
        Object o = new Object();
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        SoftReference<Object> s = new SoftReference<>(o,referenceQueue);
        o = null;
        s = null;
        System.gc();
        System.out.println(o);
//        System.out.println(s.get());
        System.out.println(referenceQueue.poll());
    }
}
