//一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。
// 求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
//
// 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。 
//
// 示例 1： 
//
// 输入：n = 2
//输出：2
// 
//
// 示例 2： 
//
// 输入：n = 7
//输出：21
// 
//
// 示例 3： 
//
// 输入：n = 0
//输出：1 
//
// 提示： 
//
// 
// 0 <= n <= 100 
// 
//
// 注意：本题与主站 70 题相同：https://leetcode-cn.com/problems/climbing-stairs/ 
//
// 
// Related Topics 递归 
// 👍 169 👎 0


import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 斐波那契数列，f(n) = f(n-1)+f(n-2)
    // 当n==0 或 n==1 时，算一种方法
    public int numWays(int n) {
        if (n == 0 || n == 1) return 1;
        int sum = 0, a = 1 ,b = 1;
        for (int i = 2; i <= n; i++) {
            sum = (a+b)%1000000007;
            a = b;
            b = sum;
        }

        return sum;
    }


}
//leetcode submit region end(Prohibit modification and deletion)
