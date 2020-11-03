public class Solution_941 {

    public static void main(String[] args) {
        int[] test = new int[]{0,1,2,3,4,5,6,7,8,9};
        System.out.println(validMountainArray(test));
    }
    public static boolean validMountainArray(int[] A) {
        if (A.length < 3) return false;

        int id1 = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i - 1] < A[i]) {
                id1 = i;
            } else {
                break;
            }
        }

        int id2 = A.length-1;
        for (int i = A.length - 2; i >= 0; i--) {
            if (A[i] > A[i + 1]) {
                id2 = i;
            } else {
                break;
            }
        }


        if(id1 == id2 && id1!=0 && id1!=A.length-1) {
            return true;
        }
        return false;

    }
}
