package JVM;

import java.util.HashMap;

public class TestCopy {
    public static void main(String[] args) {
        A a = new A();
        a.setB(new B(1));
        A a2 = (A)a.clone();
        C c = new C(2);
        String s = " ";
        System.out.println(a  == a2);
        System.out.println(a.getB() == a2.getB());
        System.out.println(a.getB().equals(a2.getB()));
//        B b1 = new B(1);
//        B b2 = (B) b1.clone();
//        System.out.println(b1.hashCode());
//        System.out.println(b2.hashCode());
//        System.out.println(b1.equals(b2));
    }

}

class A implements Cloneable {
    private int age;
    private B b;


    @Override
    protected Object clone() {
        try {
            A a1 = (A) super.clone();
            a1.setB((B) b.clone());
            return a1;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int getAge() {

        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public B getB() {
        return b;
    }

    public void setB(B b) {
        this.b = b;
    }


}

class B implements Cloneable {
    int age;

    public B(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    protected Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
}


class C {
    int a;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public C(int a) {
        this.a = a;
    }
}

