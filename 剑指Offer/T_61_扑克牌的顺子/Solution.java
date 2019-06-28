package T_61_扑克牌的顺子;

/**
 * 题目描述
 * LL今天心情特别好,因为他去买了一副扑克牌,发现里面居然有2个大王,2个小王(一副牌原本是54张^_^)...
 * 他随机从中抽出了5张牌,想测测自己的手气,看看能不能抽到顺子,如果抽到的话,他决定去买体育彩票,嘿嘿！！
 * “红心A,黑桃3,小王,大王,方片5”,“Oh My God!”不是顺子.....LL不高兴了,他想了想,决定大\小 王可以看成任何数字,并且A看作1,J为11,Q为12,K为13。
 * 上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4),“So Lucky!”。LL决定去买体育彩票啦。
 * 现在,要求你使用这幅牌模拟上面的过程,然后告诉我们LL的运气如何， 如果牌能组成顺子就输出true，否则就输出false。为了方便起见,你可以认为大小王是0。
 */
import java.util.*;
public class Solution {

    public boolean isContinuous(int [] numbers) {
        //先排序 O(logn)
        //找出间隔的数字个数
        //方法：最后一个数-0后的第一个数 +1 - 长度 = 缺少的数字的个数 less
        // > 0 说明有间隔的,= 0说明正好有序 <0说明有重复数字（return false）
        // > 0时 检查numbers中0的个数 是否等于 less
        if (numbers == null || numbers.length < 3) return false;
        Arrays.sort(numbers);
        int jokers = 0;//大小王的个数
        int lastJokerIndex = -1;
        for(int i = 0; i< numbers.length ; i++) {
            if (numbers[i] == 0) {
                jokers++;
                lastJokerIndex = i;
            }
        }

        int min = numbers[lastJokerIndex+1];
        int max = numbers[numbers.length-1];
        int less = max-min + 1 - (numbers.length - jokers); //缺少的数字个数
        if(less < 0) return false;
        //如果不缺少(说明本来就连续)或者 大小王的个数能够弥补空缺 就返回true
        if(less == 0 || jokers == less) return true;

        return false;


    }
}