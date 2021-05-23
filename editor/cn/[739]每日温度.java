//请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。
// 如果气温在这之后都不会升高，请在该位置用 0 来代替。
// 
//
// 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2
//, 1, 1, 0, 0]。 
//
// 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。 
// Related Topics 栈 哈希表 
// 👍 759 👎 0


import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res=new int[temperatures.length];
        Stack<Integer> stack=new Stack<>();

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.empty()&&temperatures[stack.peek()]<temperatures[i]){
                res[stack.peek()]=i-stack.pop();
            }
            stack.push(i);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
