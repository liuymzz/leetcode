//给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 10 
// -100 <= matrix[i][j] <= 100 
// 
// Related Topics 数组 
// 👍 806 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int numCount = matrix[0].length* matrix.length;
        int top=0,bottom=matrix.length-1,left=0,right=matrix[0].length-1;
        List<Integer> res = new ArrayList<>(numCount);
        while (numCount>=1){
            // 上
            for (int i = left; i <= right && numCount >=1; i++) {
                res.add(matrix[top][i]);
                numCount--;
            }
            top++;
            // 右
            for (int i = top; i <= bottom && numCount >=1; i++) {
                res.add(matrix[i][right]);
                numCount--;
            }
            right--;
            // 下
            for (int i = right; i >= left && numCount >=1; i--) {
                res.add(matrix[bottom][i]);
                numCount--;
            }
            bottom--;
            // 左
            for (int i = bottom; i >=top && numCount >=1 ; i--) {
                res.add(matrix[i][left]);
                numCount--;
            }
            left++;

        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
