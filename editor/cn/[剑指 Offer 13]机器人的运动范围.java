//地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
// 一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），
// 也不能进入行坐标和列坐标的数位之和大于k的格子。
// 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。
// 但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
//
// 
//
// 示例 1： 
//
// 输入：m = 2, n = 3, k = 1
//输出：3
// 
//
// 示例 2： 
//
// 输入：m = 3, n = 1, k = 0
//输出：1
// 
//
// 提示： 
//
// 
// 1 <= n,m <= 100 
// 0 <= k <= 20 
// 
// 👍 298 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int m,n,k;
    boolean[][] isRead;

    public int movingCount(int m, int n, int k) {
        this.m=m;
        this.n=n;
        this.k=k;
        isRead = new boolean[m][n];
        return cacl(0,0);
    }

    private int cacl(int m, int n) {
        if (m>=this.m||n>=this.n||bitSum(m)+bitSum(n)>this.k||isRead[m][n])
            return 0;

        isRead[m][n]=true;
        return 1+cacl(m+1,n) + cacl(m,n+1);
    }

    private int bitSum(int n) {
        int sum = 0;
        while(n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
