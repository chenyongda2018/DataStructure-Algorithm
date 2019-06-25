package 贪心算法_3_分发饼干;

import java.util.Arrays;

/**455
 * 题目描述:
 * 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。对每个孩子 i ，都有一个胃口值 gi ，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j ，都有一个尺寸 sj 。如果 sj >= gi ，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/assign-cookies
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public int findContentChildren(int[] g, int[] s) {
        //先对孩子的胃口和饼干尺寸从小到大进行排序
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;//满足孩子的个数
        int j = 0; //g的指针
        int i = 0;//s的指针
        while (i < s.length && j < g.length) {
            if (s[i] >= g[j] ) { //如果饼干尺寸满足孩子胃口
                j++;
                count++;
            }
            i++;
        }
        return count;
    }
}
