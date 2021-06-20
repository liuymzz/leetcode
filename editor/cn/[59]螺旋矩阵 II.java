//给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，
// 且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：[[1,2,3],[8,9,4],[7,6,5]]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 
// Related Topics 数组 
// 👍 430 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] generateMatrix(int n) {
        int numCount = n*n;
        int top=0,bottom=n-1,left=0,right=n-1;
        int[][] res = new int[n][n];
        int index = 1;
        while (numCount>=1){
            // 上
            for (int i = left; i <= right && numCount >=1; i++) {
                res[top][i]=index++;
                numCount--;
            }
            top++;
            // 右
            for (int i = top; i <= bottom && numCount >=1; i++) {
                res[i][right]=index++;
                numCount--;
            }
            right--;
            // 下
            for (int i = right; i >= left && numCount >=1; i--) {
                res[bottom][i]=index++;
                numCount--;
            }
            bottom--;
            // 左
            for (int i = bottom; i >=top && numCount >=1 ; i--) {
                res[i][left]=index++;
                numCount--;
            }
            left++;

        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
