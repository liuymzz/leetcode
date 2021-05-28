//给你一个整数数组 nums，请你将该数组升序排列。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入：nums = [5,2,3,1]
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 输入：nums = [5,1,1,2,0,0]
//输出：[0,0,1,1,2,5]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 50000 
// -50000 <= nums[i] <= 50000 
// 
// 👍 293 👎 0


import java.util.Random;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] sortArray(int[] nums) {
        if (nums==null) return nums;
        randomQuickSort(nums,0,nums.length-1);
        return nums;
    }

    private void randomQuickSort(int[] nums,int lo,int hi){
        if (lo<hi){
            int pos=randomPartition(nums,lo,hi);
            randomQuickSort(nums,lo,pos-1);
            randomQuickSort(nums,pos+1,hi);
        }
    }
    private int randomPartition(int[] nums,int lo,int hi){
        int pos = new Random().nextInt(hi-lo+1)+lo;
        swap(nums,hi,pos);
        return partition(nums,lo,hi);
    }

    private int partition(int[] nums,int lo,int hi){
        int i=lo;
        for(int j=lo;j<=hi;j++){
            if (nums[j]<nums[hi]){
                swap(nums,i,j);
                i++;
            }
        }
        swap(nums,i,hi);
        return i;
    }

    private void swap(int[] nums,int i,int j){
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
