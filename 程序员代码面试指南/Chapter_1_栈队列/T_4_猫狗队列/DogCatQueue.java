package Chapter_1_栈队列.T_4_猫狗队列;

import java.util.LinkedList;
import java.util.Queue;

public class DogCatQueue {
    Queue<PetEnterQueue> catQ;
    Queue<PetEnterQueue> dogQ;
    long count;


    public DogCatQueue() {
        this.catQ = new LinkedList<>();
        this.dogQ = new LinkedList<>();
        this.count = 0;
    }

    public void add(Pet pet) {
        if (pet.getType().equals("Cat")) {
            catQ.offer(new PetEnterQueue(pet, count++));
        } else if (pet.getType().equals("Dog")) {
            dogQ.offer(new PetEnterQueue(pet, count++));
        }
    }

    public Pet pollAll() {
        if (!catQ.isEmpty() && !dogQ.isEmpty()) {
            if (catQ.peek().getCount() <= dogQ.peek().getCount()) {
                return catQ.poll().getPet();
            } else {
                return dogQ.poll().getPet();
            }
        } else if (!catQ.isEmpty()) {
            return catQ.poll().getPet();
        } else if (!dogQ.isEmpty()) {
            return dogQ.poll().getPet();
        } else {
            throw new RuntimeException("Queue is null");
        }
    }

    public Pet pollDog() {
        if (!dogQ.isEmpty()) {
            return dogQ.poll().getPet();
        } else {
            throw new RuntimeException("Queue is null");
        }
    }

    public Pet pollCat() {
        if (!catQ.isEmpty()) {
            return catQ.poll().getPet();
        } else {
            throw new RuntimeException("Queue is null");
        }
    }

    public boolean isEmpty() {
        return (!catQ.isEmpty() && !dogQ.isEmpty());
    }

    public boolean isDogEmpty() {
        return (!dogQ.isEmpty());
    }

    public boolean isCatEmpty() {
        return (!catQ.isEmpty());
    }
}
