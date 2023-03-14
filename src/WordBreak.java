import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("leet");
        list.add("code");
        System.out.println(
                new Solution139().wordBreak("leetcode", list)
        );
    }
}

class Solution139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> listset = new HashSet<>(wordDict);
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && listset.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
