//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。 
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 注意：给定 n 是一个正整数。 
//
// 示例 1： 
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶 
//
// 示例 2： 
//
// 输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶
// 
// Related Topics 动态规划 
// 👍 1688 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 斐波那契数列，f(n) = f(n-1)+f(n-2)
    // 当n==0 或 n==1 时，算一种方法
    public int climbStairs(int n) {
        if (n == 0 || n == 1) return 1;
        int sum = 0, a = 1 ,b = 1;
        for (int i = 2; i <= n; i++) {
            sum = a+b;
            a = b;
            b = sum;
        }

        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
