//输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。 
//
// 
//
// 示例 1： 
//
// 输入：matrix = [[1,2,3],
//                [4,5,6],
//                [7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
//
// 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 限制： 
//
// 
// 0 <= matrix.length <= 100 
// 0 <= matrix[i].length <= 100 
// 
//
// 注意：本题与主站 54 题相同：https://leetcode-cn.com/problems/spiral-matrix/ 
// Related Topics 数组 
// 👍 265 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix==null || matrix.length==0) return new int[0];
        int numCount = matrix[0].length* matrix.length;
        int top=0,bottom=matrix.length-1,left=0,right=matrix[0].length-1;
        int[] res = new int[numCount];
        int index=0;
        while (index<numCount){
            // 上
            for (int i = left; i <= right && index <numCount; i++) {
                res[index++]=matrix[top][i];
            }
            top++;
            // 右
            for (int i = top; i <= bottom && index <numCount; i++) {
                res[index++]=matrix[i][right];
            }
            right--;
            // 下
            for (int i = right; i >= left && index <numCount; i--) {
                res[index++]=matrix[bottom][i];
            }
            bottom--;
            // 左
            for (int i = bottom; i >=top && index <numCount ; i--) {
                res[index++]=matrix[i][left];
            }
            left++;

        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
