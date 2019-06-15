package T_2_独木舟问题;

import DataStructure_Sort.MergeSort;

public class Solution {

    public int dumuzhou(int peopleSize, int boatWeight, int[] peopleWeight) {
        if (peopleSize < 1 || boatWeight < 0 || peopleWeight.length != peopleSize || peopleWeight == null) {
            return 0;
        }
        int start = 0;
        int end = peopleSize - 1;
        int boatCount = 0;
        MergeSort.sort(peopleWeight); //将体重进行排序

        while (start < end) {
            if (peopleWeight[start] + peopleWeight[end] < boatWeight) {
                boatCount++;
                start++;
                end--;
            } else if (peopleWeight[end] < boatWeight) {
                boatCount++;
                end--;
            }
        }
        if ( start ==end) {
            boatCount++; //最后只剩下了一个人
        }
        return boatCount;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] peopleWeight = new int[]{1,2,3};
        int boatWeight = 6;
        System.out.println(s.dumuzhou(3, boatWeight, peopleWeight));
    }
}
