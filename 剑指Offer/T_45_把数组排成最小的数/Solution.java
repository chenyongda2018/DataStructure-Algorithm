package T_45_把数组排成最小的数;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public String PrintMinNumber(int [] numbers) {
        StringBuilder minResult = new StringBuilder();
        if (numbers == null) {
            return "";
        }
        ArrayList<String> strList = new ArrayList<>();

        for (int i = 0; i < numbers.length; i++) {
            strList.add(String.valueOf(numbers[i]));
        }

        Collections.sort(strList, new StringComparator());

        for (int i = 0; i < strList.size(); i++) {
            minResult.append(strList.get(i));
        }

        return minResult.toString();
    }



    //public boolean isSmaller(String str1,String str2) {
    //    StringBuilder sb1 = new StringBuilder(str1).append(str2);
    //    StringBuilder sb2 = new StringBuilder(str2).append(str1);
    //    int num1 = Integer.valueOf(sb1.toString());
    //    int num2 = Integer.valueOf(sb2.toString());
    //    if (num1 <= num2) {
    //        return true;
    //    }
    //    return false;
    //}
}

class StringComparator implements Comparator<String> {

    @Override
    public int compare(String s, String t1) {
        StringBuilder sb1 = new StringBuilder(s).append(t1);
        StringBuilder sb2 = new StringBuilder(t1).append(s);
        int num1 = Integer.valueOf(sb1.toString());
        int num2 = Integer.valueOf(sb2.toString());
        if (num1 <= num2) {
            return -1;
        }
        return 1;
    }

}
