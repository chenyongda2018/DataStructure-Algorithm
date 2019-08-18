package TestInit;

public class TestInit {
    public static void main(String[] args) {
        System.out.println(C.age);
    }
}

class A {
    static {
        System.out.println("i am a");
    }
}

class B extends A {
    static {
        System.out.println("i am b");
    }
    public static int age = 10;
}

class C extends B {
    static {
        System.out.println("i am c");
    }
}
