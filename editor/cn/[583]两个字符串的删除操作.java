//给定两个单词 word1 和 word2，找到使得 word1 和 word2 相同所需的最小步数，每步可以删除任意一个字符串中的一个字符。 
//
// 
//
// 示例： 
//
// 输入: "sea", "eat"
//输出: 2
//解释: 第一步将"sea"变为"ea"，第二步将"eat"变为"ea"
// 
//
// 
//
// 提示： 
//
// 
// 给定单词的长度不超过500。 
// 给定单词中的字符只含有小写字母。 
// 
// Related Topics 字符串 动态规划 
// 👍 202 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minDistance(String word1, String word2) {
        // 可以先获得最长公共子序列的长度
        int len = longestCommonSubsequence(word1, word2);
        return (word1.length()-len) + (word2.length()-len);
    }

    int[][] m;
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1.length() == 0 || text2.length() == 0) return 0;
        m = new int[text1.length()][text2.length()];
        for (int[] ints : m) {
            Arrays.fill(ints, -1);
        }
        return dp(text1, 0, text2, 0);
    }

    private int dp(String text1, int i, String text2, int j) {
        if (i == text1.length() || j == text2.length())
            return 0;
        if (m[i][j] != -1)
            return m[i][j];
        else if (text1.charAt(i) == text2.charAt(j))
            m[i][j] = 1 + dp(text1, i + 1, text2, j + 1);
        else
            m[i][j] = Math.max(dp(text1, i + 1, text2, j), dp(text1, i, text2, j + 1));
        return m[i][j];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
