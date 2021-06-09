//给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。 
//
// 你可以对一个单词进行如下三种操作： 
//
// 
// 插入一个字符 
// 删除一个字符 
// 替换一个字符 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：word1 = "horse", word2 = "ros"
//输出：3
//解释：
//horse -> rorse (将 'h' 替换为 'r')
//rorse -> rose (删除 'r')
//rose -> ros (删除 'e')
// 
//
// 示例 2： 
//
// 
//输入：word1 = "intention", word2 = "execution"
//输出：5
//解释：
//intention -> inention (删除 't')
//inention -> enention (将 'i' 替换为 'e')
//enention -> exention (将 'n' 替换为 'x')
//exention -> exection (将 'n' 替换为 'c')
//exection -> execution (插入 'u')
// 
//
// 
//
// 提示： 
//
// 
// 0 <= word1.length, word2.length <= 500 
// word1 和 word2 由小写英文字母组成 
// 
// Related Topics 字符串 动态规划 
// 👍 1647 👎 0


import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    // 递归回溯+备忘录解法
    /*String w1, w2;
    Map<String, Integer> cache = new HashMap<>();

    // word1 -> word2
    public int minDistance(String word1, String word2) {
        w1 = word1;
        w2 = word2;
        return dp(word1.length() - 1, word2.length() - 1);
    }

    private int dp(int m, int n) {
        if (m == -1) return n + 1;
        if (n == -1) return m + 1;

        if (cache.get(m + " " + n) != null) {
            return cache.get(m + " " + n);
        }

        if (w1.charAt(m) == w2.charAt(n))
            cache.put(m + " " + n, dp(m - 1, n - 1));
        else
            cache.put(m + " " + n, Math.min(dp(m - 1, n) + 1, Math.min(dp(m, n - 1) + 1, dp(m - 1, n - 1) + 1)));
        return cache.get(m + " " + n);
    }*/

    // 动态规划 子问题 自底向上
    // word1 -> word2
    public int minDistance(String word1, String word2) {
        int w1Length = word1.length();
        int w2Length = word2.length();
        int[][] dp = new int[w1Length +1][w2Length +1];

        for (int i = 0; i <= w1Length; i++) {
            dp[i][0]=i;
        }
        for (int i = 0; i <=w2Length; i++) {
            dp[0][i]=i;
        }

        for (int i = 1; i <= w1Length; i++) {
            for (int j = 1; j <= w2Length; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1))
                    dp[i][j]=dp[i-1][j-1];
                else
                    dp[i][j]=Math.min(dp[i-1][j-1],Math.min(dp[i][j-1],dp[i-1][j]))+1;
            }
        }

        for (int i = 0; i < w1Length; i++) {
            for (int i1 = 0; i1 < w2Length; i1++) {
                System.out.format("%5d",dp[i][i1]);
            }
            System.out.println();
        }
        return dp[word1.length()][word2.length()];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
