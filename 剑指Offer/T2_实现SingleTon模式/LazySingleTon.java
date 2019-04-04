package T2_实现SingleTon模式;

/**
 * Created by cyd on 19-4-3.
 * 懒汉式
 */

public class LazySingleTon {
    private static LazySingleTon instance = null;
    private static Object lock = new Object();

    private LazySingleTon() {

    }

    public static  LazySingleTon getInstance() {
        if (instance == null) {
            synchronized (lock) {
                if (instance == null) {
                    instance = new LazySingleTon();
                }
            }
        }
        return instance;
    }
}
