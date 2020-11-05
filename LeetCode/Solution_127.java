import java.util.*;

public class Solution_127 {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        Set<String> wordSet = new HashSet<>(wordList);
        wordSet.remove(beginWord);

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        int step = 1;
        while (!queue.isEmpty()) {
            int curSize = queue.size();
            for (int i = 0; i < curSize; i++) {
                String curWord = queue.poll();
                char[] chars = curWord.toCharArray();
                for (int j = 0; j < chars.length; j++) {
                    char curChar = chars[j];
                    for (char k = 'a'; k <= 'z'; k++) {
                        if (k == curChar) continue;
                        chars[j] = k;
                        String str = String.valueOf(chars);
                        if (wordSet.contains(str)) {
                            if (str.equals(endWord)) {
                                return step + 1;
                            }
                            if (!visited.contains(str)) {
                                queue.add(str);
                                visited.add(str);
                            }
                        }
                    }
                    chars[j] = curChar;
                }

            }
            step++;
        }
        return 0;

    }
}
