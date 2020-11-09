import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution_973 {

    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(K, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                double res = (Math.pow(o1[0],2) + Math.pow(o1[1],2)) - (Math.pow(o2[0],2) + Math.pow(o2[1],2));

                return (int)res;
            }
        });
        for(int[] axis : points) {
            minHeap.add(axis);
        }
        int[][] result = new int[K][];
        for (int i = 0; i < K; i++) {
            result[i] = minHeap.poll();
        }
        return result;

    }
    
}
