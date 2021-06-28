//给你两个二进制字符串，返回它们的和（用二进制表示）。 
//
// 输入为 非空 字符串且只包含数字 1 和 0。 
//
// 
//
// 示例 1: 
//
// 输入: a = "11", b = "1"
//输出: "100" 
//
// 示例 2: 
//
// 输入: a = "1010", b = "1011"
//输出: "10101" 
//
// 
//
// 提示： 
//
// 
// 每个字符串仅由字符 '0' 或 '1' 组成。 
// 1 <= a.length, b.length <= 10^4 
// 字符串如果不是 "0" ，就都不含前导零。 
// 
// Related Topics 位运算 数学 字符串 模拟 
// 👍 632 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int an = a.length()-1,bn=b.length()-1;
        int i = 0;
        while (an>=0 || bn>=0){
            i += an<0?0:a.charAt(an--)-'0';
            i += bn<0?0:b.charAt(bn--)-'0';
            sb.append(i%2);
            i/=2;
        }
        if (i!=0) sb.append(i);
        return sb.reverse().toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
