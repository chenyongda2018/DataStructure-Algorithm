package T4_替换空格;

/**
 * Created by cyd on 19-4-5.
 */

public class ReplaceSpace {
    /**
     * 解题思路:
     * 1,先统计字符串中空格的个数,更新字符串的长度 = 原长+空格个数*2
     * 2,定义两个索引,p1指向原字符串末尾,p2指向新字符串末尾
     * 3,把p1的内容复制给p2,p1向前,p2向前,直到p1遇到空格,停下,
     * 4,把p2的位置和往前两个位置一次赋值0,2,%,p1向前....直到p1,p2重合
     * @param array
     */
    public static void replaceSpace(char[] array) {
        if(array == null) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(array));
        int spaceNum = 0;
        //1,先统计字符串中空格的个数
        for (int i=0;i<stringBuilder.length();i++) {
            if (stringBuilder.charAt(i) == ' ') {
                spaceNum ++;
            }
        }

        if (spaceNum == 0 ) {
            return;
        }

        int originalLength = stringBuilder.length();
        //2,设置新的长度
        stringBuilder.setLength(originalLength+spaceNum*2);
        int p1 = originalLength-1;//指向原始字符串末尾的索引
        int p2 = stringBuilder.length()-1;//指向新的字符串末尾的索引

        while (p1 < p2) {
            if (stringBuilder.charAt(p1) != ' ') {
                stringBuilder.setCharAt(p2,stringBuilder.charAt(p1));//把p1的值给p2

                //两个索引向前移动
                p1--;
                p2--;
            } else {
                stringBuilder.setCharAt(p2--,'0');
                stringBuilder.setCharAt(p2--,'2');
                stringBuilder.setCharAt(p2--,'%');
                p1--;
            }
        }

        System.out.println(stringBuilder);

    }

    public static void main(String[] args) {
        char[] array = "We  are  happy".toCharArray();
        replaceSpace(array);
    }
}
