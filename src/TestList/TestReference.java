package TestList;

public class TestReference {
    public static void main(String[] args) {
        int a = 10;
        int b;
        func(a);
//        func(b);
    }
    public static void func(int a) {
        a = 20;
    }
}
