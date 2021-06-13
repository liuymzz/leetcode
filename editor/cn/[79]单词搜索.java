//给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 示例 1： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "AB
//CCED"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SE
//E"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "AB
//CB"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n = board[i].length 
// 1 <= m, n <= 6 
// 1 <= word.length <= 15 
// board 和 word 仅由大小写英文字母组成 
// 
//
// 
//
// 进阶：你可以使用搜索剪枝的技术来优化解决方案，使其在 board 更大的情况下可以更快解决问题？ 
// Related Topics 数组 回溯算法 
// 👍 926 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    String w;
    public boolean exist(char[][] board, String word) {
        w = word;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dp(board, word, i, j, 0)) return true;
            }
        }
        return false;
    }

    // 扫描每一个可能的路径，对于不存在的情况，进行剪枝
    private boolean dp(char[][] board, String word, int i, int j, int k) {
        if (i < 0 || j < 0
                || i >= board.length || j >= board[0].length || k >= w.length()
                || board[i][j] != word.charAt(k))
            return false;

        if (k == w.length()-1 && board[i][j] == word.charAt(k)){
            return true;
        }

        char tmp = board[i][j];
        board[i][j] = ' ';
        boolean flag =
                dp(board, word, i - 1, j, k + 1) || dp(board, word, i + 1, j, k + 1)
                        || dp(board, word, i, j - 1, k + 1) || dp(board, word, i, j + 1, k + 1);
        board[i][j] = tmp;
        return flag;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
