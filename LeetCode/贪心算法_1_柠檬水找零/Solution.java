package 贪心算法_1_柠檬水找零;

/**
 * 在柠檬水摊上，每一杯柠檬水的售价为 5 美元。
 *
 * 顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。
 *
 * 每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。
 *
 * 注意，一开始你手头没有任何零钱。
 *
 * 如果你能给每位顾客正确找零，返回 true ，否则返回 false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lemonade-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Solution {
    /**
     思路:贪心算法:
     维护两个变量 5块钱的数量，10块钱的数量，因为只有这两张钱能在找零时给顾客
     当支付5块钱时，不用找钱
     当支付10元钱时，找5块
     当支付20元钱时，优先找10块，再找5块
     */
    public boolean lemonadeChange(int[] bills) {
        if(bills == null || bills.length < 1) {
            return false;
        }
        String str = "";

        int fives = 0;
        int tens = 0;

        for (int i = 0; i < bills.length;i++) {
            if (bills[i] == 5) {
                fives ++;
            } else if (bills[i] == 10) {
                if (fives > 0) {
                    fives --;
                    tens++;
                } else {
                    return false;
                }

            } else {
                int giveBack = 15;
                if (tens > 0) {
                    tens --;
                    giveBack-=10;
                }
                while (giveBack > 0 && fives > 0) {
                    fives--;
                    giveBack -=5;
                }
                if (giveBack != 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
