package T_3_国王挖金矿问题;

public class Solution {
    static int GOLDS = 5; //金矿数量
    static int PEOPLES = 100; //总人数


    public static void main(String[] args) {
        int[] peopleNeed = new int[]{77, 22, 29, 50, 99};//每座金矿需要的人数
        int[] goldGet = new int[]{92, 22, 87, 36, 90};//每座金矿能够得到的金子数量
        //记录当剩下 people个人和 剩下前golds个金矿时，能够得到的最大的金子,当为-1值表示未知
        int[][] maxGold = new int[PEOPLES +1][GOLDS ];
        initData(maxGold);

        System.out.println(getMaxGold(PEOPLES, GOLDS-1, peopleNeed, goldGet, maxGold));
    }

    public static int getMaxGold(int people, int goldNum, int[] peopleNeed, int[] goldGet, int[][] maxGold) {
        int getGold = 0; //记录当有people个人，前goldNum个金矿时，得到的金子
        if (maxGold[people][goldNum] != -1) { //如果之前有记录，就直接取出来
            getGold = maxGold[people][goldNum];
        } else if (goldNum == 1) { //最后一个金矿
            if (people >= peopleNeed[goldNum]) {
                getGold = goldGet[goldNum];
            } else {
                getGold = 0;
            }
        } else if (people >= peopleNeed[goldNum]) {
            getGold = Math.max(
                    getMaxGold(people - peopleNeed[goldNum],
                            goldNum - 1, peopleNeed, goldGet, maxGold)
                    ,
                    getMaxGold(people, goldNum - 1, peopleNeed, goldGet, maxGold));
        } else {
            getGold = getMaxGold(people, goldNum - 1, peopleNeed, goldGet, maxGold);
            maxGold[people][goldNum] = getGold;
        }

        return getGold;
    }


    public static void initData(int[][] maxGold) {
        for (int i = 0; i < maxGold.length; i++) {
            for (int j = 0; j < maxGold[0].length; j++) {
                maxGold[i][j] = -1;
            }
        }
    }


}
