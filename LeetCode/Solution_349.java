import java.util.ArrayList;
import java.util.HashMap;

public class Solution_349 {

    public int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map1 = count(nums1);
        HashMap<Integer, Integer> map2 = count(nums2);
        ArrayList<Integer> result;
        if (map1.size() < map2.size()) {
            result = intersec(map1, map2);
        } else {
            result = intersec(map2, map1);
        }
        int[] res;
        if (result != null) {
            res = new int[result.size()];
            for (int i = 0; i < res.length; i++) {
                res[i] = result.get(i);
            }
        } else {
            res = new int[0];
        }
        return res;
    }

    public ArrayList<Integer> intersec(HashMap<Integer, Integer> map1, HashMap<Integer, Integer> map2) {
        ArrayList<Integer> result = new ArrayList<>();
        map1.forEach((key, value) -> {
            if (map2.containsKey(key)) {
                result.add(key);
            }
        });
        return result;
    }

    public HashMap<Integer, Integer> count(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int count;
            if (map.containsKey(nums[i])) {
                count = map.get(nums[i]) + 1;
                map.put(nums[i], count);
            } else {
                map.put(nums[i], 1);
            }
        }
        return map;
    }
}
