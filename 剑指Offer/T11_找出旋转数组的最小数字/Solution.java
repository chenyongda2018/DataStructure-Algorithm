package T11_找出旋转数组的最小数字;

public class Solution {
    public int minNumberInRotateArray(int [] array) {
        if (array.length <= 0) {
            return 0;
        }
        int front = 0;
        int tail = array.length-1;
        int index = 0;
        while (array[front] >= array[tail]) {
            if (tail - front == 1) {
                return array[tail];
            }
            index = (front+tail) /2;
            if (array[front] == array[tail] && array[front] == array[index]) {
                int result = 0;
                for (int i = front;i<=tail;i++) {
                    if (result >= array[i]) {
                        result = array[i];
                    }
                }
                return result;
            }

            if (array[index] >= array[front]) {
                front = index;
            }
            if (array [index] <= array[tail]) {
                tail = index;
            }
        }
        return array[tail];
    }
}
