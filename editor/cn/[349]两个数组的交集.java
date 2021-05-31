//给定两个数组，编写一个函数来计算它们的交集。 
//
// 
//
// 示例 1： 
//
// 输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2]
// 
//
// 示例 2： 
//
// 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[9,4] 
//
// 
//
// 说明： 
//
// 
// 输出结果中的每个元素一定是唯一的。 
// 我们可以不考虑输出结果的顺序。 
// 
// Related Topics 排序 哈希表 双指针 二分查找 
// 👍 371 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.stream.Collectors;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int nums1Index=0,nums2Index=0;
        HashSet<Integer> set = new HashSet<>(Math.min(nums1.length, nums2.length));
        while (nums1Index<nums1.length&&nums2Index<nums2.length){
            if (nums1[nums1Index]==nums2[nums2Index]){
                set.add(nums1[nums1Index]);
                nums1Index++;
                nums2Index++;
            }else if (nums1[nums1Index]>nums2[nums2Index]){
                nums2Index++;
            }else {
                nums1Index++;
            }
        }

        int[] ints = new int[set.size()];
        int index=0;
        for (Integer n: set){
            ints[index++]=n;
        }
        return ints;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
