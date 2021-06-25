//实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。不得使用库函数，同时不需要考虑大数问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：x = 2.00000, n = 10
//输出：1024.00000
// 
//
// 示例 2： 
//
// 
//输入：x = 2.10000, n = 3
//输出：9.26100 
//
// 示例 3： 
//
// 
//输入：x = 2.00000, n = -2
//输出：0.25000
//解释：2-2 = 1/22 = 1/4 = 0.25 
//
// 
//
// 提示： 
//
// 
// -100.0 < x < 100.0 
// -231 <= n <= 231-1 
// -104 <= xn <= 104 
// 
//
// 
//
// 注意：本题与主站 50 题相同：https://leetcode-cn.com/problems/powx-n/ 
// Related Topics 递归 
// 👍 170 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double myPow(double x, int n) {
        double res = 1.0;
        long nn = n;
        if (nn < 0) {
            x = 1 / x;
            // java int 值的取值范围 -2147483648 至2147483647
            // 当指数n为-2147483648 时，用int 类型接收 -n就会溢出
            // 所以这里用转换成long 类型的nn
            nn = -nn;
        }

        // 快速幂解法，指数转化为二进制
        // 比如 2^13，指数13的二进制为1101，那么2^13 可以转化为2^8 * 2^4 * 2^0 * 2^1
        while (nn > 0) {
            if ((nn & 1) == 1) {
                res *= x;
            }
            x *= x;
            nn >>= 1;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
