//给你一个字符串 s 、一个字符串 t 。
// 返回 s 中涵盖 t 所有字符的最小子串。
// 如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
//
// 注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC"
// 
//
// 示例 2： 
//
// 
//输入：s = "a", t = "a"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length, t.length <= 105 
// s 和 t 由英文字母组成 
// 
//
// 
//进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？ Related Topics 哈希表 双指针 字符串 Sliding Window 
// 👍 1186 👎 0


import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String minWindow(String s, String t) {
        Map<Character,Integer> need = new HashMap<>(),window = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.merge(c,1,Integer::sum);
        }
        int left=0,right=0,start=0,val=0,len=s.length()+1;
        while (right<s.length()){
            char r = s.charAt(right);
            right++;
            if (need.containsKey(r)){
                window.merge(r,1,Integer::sum);
                if (need.get(r).equals(window.get(r))){
                    val++;
                    while (val==need.size()){
                        if ((right-left)<len){
                            len = right-left;
                            start=left;
                        }
                        char l = s.charAt(left);
                        left++;
                        if (window.containsKey(l)){
                            if (need.get(l).equals(window.get(l))){
                                val--;
                            }
                            window.merge(l,-1,Integer::sum);
                        }
                    }
                }
            }
        }
        return len>s.length()?"":s.substring(start,start+len);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
