package 面试题2实现SingleTon模式;

/**
 * Created by cyd on 19-4-3.
 * 懒汉式
 */

public class LazySingleTon {
    private static LazySingleTon instance = null;

    private LazySingleTon() {

    }

    public static synchronized LazySingleTon getInstance() {
        if (instance == null) {
            instance = new LazySingleTon();
        }
        return instance;
    }
}
