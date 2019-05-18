package Financial_Management;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        float sum = 0;
        for (int i = 0; i < 12; i++) {
            float num = scanner.nextFloat();
            if( num > 0) {
                sum+=num;
            }
        }
        sum =Math.round(sum/12);
        System.out.println(sum);
    }
}
