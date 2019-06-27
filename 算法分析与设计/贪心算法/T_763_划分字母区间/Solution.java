package 贪心算法.T_763_划分字母区间;

import java.util.ArrayList;
import java.util.List;

/**
 * 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，
 * 同一个字母只会出现在其中的一个片段。返回一个表示每个字符串片段的长度的列表。
 *
 * 示例 1:
 *
 * 输入: S = "ababcbacadefegdehijhklij"
 * 输出: [9,7,8]
 * 解释:
 * 划分结果为 "ababcbaca", "defegde", "hijhklij"。
 * 每个字母最多出现在一个片段中。
 * 像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-labels
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    public List<Integer> partitionLabels(String S) {
        if (S == null ) return null;

        List<Integer> lengthList = new ArrayList<>();
        int[] location = new int[128];
        for (int i = 0; i < S.length() ;i++) {
            location[S.charAt(i)] = i; //根据字符的ascii码存储它出现的最后的位置
        }

        int start = 0;
        int end = 0;

        for (int i = 0; i< S.length(); i++) {
            //随着遍历，不断更新拉的最长的字母，end表示拉的最长的字母的位置，这个字母也就是这个字串的最后一个字母
            end = Math.max( end,location[S.charAt(i)] );
            if (end == i) {
                lengthList.add(end - start + 1); //将字串的长度添加到返回值list中
                start = end + 1;//更新start
            }
        }

        return lengthList;
    }
}
