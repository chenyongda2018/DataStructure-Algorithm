package T2_实现SingleTon模式;

/**
 * Created by cyd on 19-4-3.
 * 饿汉式
 */

public class SingleTon {
//    private static SingleTon instance = new SingleTon();
//
//    private SingleTon() {
//
//    }
//    public static SingleTon getInstance() {
//        return instance;
//    }


    //优化饿汉式
    static class Creator {
        private Creator() {

        }

        private static SingleTon instance = new SingleTon();

    }

    public static SingleTon getInstance() {
        return Creator.instance;
    }


}
