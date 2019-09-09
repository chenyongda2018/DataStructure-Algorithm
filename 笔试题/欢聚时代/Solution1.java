package 欢聚时代;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution1 {


    public static void main(String[] args) {

//        int [] arr = new int[] {1,2,2,2,2,2,8,8,8};
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();

        while(sc.nextInt() != -1) {
            list.add(sc.nextInt());
        }
        int size = list.size();
        int target = list.get(size-1);
        System.out.println(target);
        int[] arr = new int[size-1];
        for (int i = 0; i <= size-2 ; i++) {
            arr[i] = list.get(i);
        }


        System.out.println(find(arr,target));


    }

    public static int find(int [] arr,int target) {
        if(arr == null || arr.length < 1) return -1;
        int length = arr.length-1;
        int i = length;
        while(i >= 0) {
            if(arr[i] == target) return i;
            i--;
        }
        return -1;
    }
    public static void printMatrx(int[][] matrix) {
        if(matrix == null || matrix .length <=0 || matrix[0].length <= 0) return ;
        int height = matrix.length;
        int width = matrix[0].length;
        int level = height*width -1;


    }

    public static ListNode getMid(ListNode head) {
        if(head == null) return null;
        int count = 1;
        ListNode n1 = head;
        ListNode n2 = head;
        while(n1.next!= null && n2.next!=null) {
            n1 = n1.next;
            n2 = n2.next;
            if(n2.next!=null) {
                n2 = n2.next;
            }
        }
        return n1;
    }


}

class ListNode {
    int val;
    ListNode next;
    public ListNode(int val) {
        this.val = val;
    }
}
