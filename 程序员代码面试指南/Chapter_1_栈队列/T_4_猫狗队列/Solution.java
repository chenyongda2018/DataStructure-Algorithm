package Chapter_1_栈队列.T_4_猫狗队列;

public class Solution {
    public static void main(String[] args) {
        DogCatQueue queue = new DogCatQueue();
        queue.add(new Dog());
        queue.add(new Dog());
        queue.add(new Cat());
        queue.add(new Cat());

        for (int i = 0; i < 4; i++) {
            System.out.println(queue.pollAll().getType());
        }
    }

}

class Pet {
    private String type;

    public Pet(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}

class Cat extends Pet{

    public Cat() {
        super("Cat");
    }
}

class Dog extends Pet {

    public Dog() {
        super("Dog");
    }
}


