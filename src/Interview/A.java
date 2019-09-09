package Interview;

public class A {
    static{
        System.out.println("A");
    }
    B b = new B();

    public static void main(String[] args) {
        A a ;
    }
}

class Test1 {

    private int getX(int x,int y) {
        return x+y;
    }

}

class Test2 extends Test1{

    private int getY(int x) {
        return x;
    }
}


