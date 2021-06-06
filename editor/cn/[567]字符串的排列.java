//给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。 
//
// 换句话说，第一个字符串的排列之一是第二个字符串的 子串 。
//
// 
//
// 示例 1： 
//
// 
//输入: s1 = "ab" s2 = "eidbaooo"
//输出: True
//解释: s2 包含 s1 的排列之一 ("ba").
// 
//
// 示例 2： 
//
// 
//输入: s1= "ab" s2 = "eidboaoo"
//输出: False
// 
//
// 
//
// 提示： 
//
// 
// 输入的字符串只包含小写字母 
// 两个字符串的长度都在 [1, 10,000] 之间 
// 
// Related Topics 双指针 Sliding Window 
// 👍 357 👎 0


import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * s1 是子串，判断s2是否包含s1的全部字符且不包含其他字符
     */
    public boolean checkInclusion(String s1, String s2) {
        Map<Character,Integer> need = new HashMap<>(),window = new HashMap<>();
        for (char c : s1.toCharArray()) {
            need.merge(c,1,Integer::sum);
        }
        int left=0,right=0,vail=0;
        while (right < s2.length()){
            char r = s2.charAt(right);
            right++;
            if (need.containsKey(r)){
                window.merge(r,1,Integer::sum);
                if (need.get(r).equals(window.get(r))){
                    vail++;
                }
            }

            if ((right-left)==s1.length()){
                if (need.size()==vail){
                    return true;
                }
                char l = s2.charAt(left);
                left++;
                if (need.containsKey(l)){
                    if (need.get(l).equals(window.get(l))){
                        vail--;
                    }
                    window.merge(l,-1,Integer::sum);
                }
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
