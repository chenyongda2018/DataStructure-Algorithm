package 动态规划.T_3_买卖股票的最佳时机;

/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 *
 * 注意你不能在买入股票前卖出股票。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    public int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2) return 0;

        int min = prices[0];
        int maxDiff = prices[1] - prices[0];
        for (int i = 1; i< prices.length;i++) {

            if (prices[i] < min) {
                min = prices[i];
            }
            int diff = prices[i] - min;
            if (diff > maxDiff) {
                maxDiff = diff;
            }

        }
        return maxDiff;

    }
}