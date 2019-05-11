package 寻找两个有序数组的中位数_4;

public class Solution {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length+nums2.length;
        int i = 0;
        int j = 0;
        int orderPos = 0;
        int orderLength = (length) %2 == 0 ? (length/2)+1 : (length+1)/2;
        int[] order = new int[orderLength];
        while( orderPos < orderLength) {
            if (i< nums1.length && nums1[i] < nums2[j]) {
                order[orderPos++] = nums1[i];
                i++;
            } else if ( j < nums2.length ){
                order[orderPos++] = nums2[j];
                j++;
            }
        }

        double result = 0;
        if (length % 2 == 0 ) {
            result =(order[orderLength-1]+order[orderLength-2])/2.0;
        } else {
            result = order[orderLength-1];
        }
        return result;

    }

    public static void main(String[] args) {
        double result = findMedianSortedArrays(new int[]{2}, new int[]{3});
        System.out.println(result);
    }
}
