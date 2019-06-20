package DataStructure_Sort;

public class ArrUtil {

    public static  void swap(int[] data, int from, int to) {
        int temp = data[from];
        data[from] = data[to];
        data[to] = temp;
    }
}
