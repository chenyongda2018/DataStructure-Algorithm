package T_1_汉诺塔;

public class Solution {
    public void HanNuoTa(int n,char from,char mid,char to) {
        if (n == 1) {
            System.out.println("将第"+n+"个盘子从"+from+"号主子移到"+to+"号柱子");
        } else {
            HanNuoTa(n-1, from,to , mid);
            System.out.println("将第"+n+"个盘子从"+from+"号主子移到"+to+"号柱子");
            HanNuoTa(n-1, mid, from,to );
        }
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        s.HanNuoTa(3,'a' ,'b' ,'c' );
    }
}
