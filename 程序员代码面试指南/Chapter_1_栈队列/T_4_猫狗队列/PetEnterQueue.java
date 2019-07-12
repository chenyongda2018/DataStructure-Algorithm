package Chapter_1_栈队列.T_4_猫狗队列;

public class PetEnterQueue {

    private Pet pet;
    private long count ;

    public PetEnterQueue(Pet pet, long count) {
        this.pet = pet;
        this.count = count;
    }


    public Pet getPet() {
        return pet;
    }

    public long getCount() {
        return count;
    }

    public String getPeyType() {
        return pet.getType();
    }
}
