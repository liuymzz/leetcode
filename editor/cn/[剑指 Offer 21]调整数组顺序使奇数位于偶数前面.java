//输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
// 使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
//
// 
//
// 示例： 
//
// 
//输入：nums = [1,2,3,4]
//输出：[1,3,2,4] 
//注：[3,1,2,4] 也是正确的答案之一。 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 50000 
// 1 <= nums[i] <= 10000 
// 
// 👍 137 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] exchange(int[] nums) {
        int head=0,tail= nums.length-1, tmp;
        while (head<tail){
            if (nums[head]%2==0 && nums[tail]%2!=0){
                tmp=nums[head];
                nums[head]=nums[tail];
                nums[tail]=tmp;
                head++;
                tail--;
                continue;
            }
            if (nums[head]%2!=0){
                head++;
            }
            if (nums[tail]%2==0){
                tail--;
            }
        }

        return nums;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
