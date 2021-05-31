//编写一个函数，以字符串作为输入，反转该字符串中的元音字母。 
//
// 
//
// 示例 1： 
//
// 输入："hello"
//输出："holle"
// 
//
// 示例 2： 
//
// 输入："leetcode"
//输出："leotcede" 
//
// 
//
// 提示： 
//
// 
// 元音字母不包含字母 "y" 。 
// 
// Related Topics 双指针 字符串 
// 👍 154 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int left=0,right=s.length()-1;
        char tmp;
        while (left<right){
            if (!isYuanYin(chars[left])){
                left++;
            }else if (!isYuanYin(chars[right])){
                right--;
            }else{
                tmp=chars[left];
                chars[left]=chars[right];
                chars[right]=tmp;
                left++;
                right--;
            }
        }
        return new String(chars);
    }

    public boolean isYuanYin(char a){
        return (a=='a' || a=='e' || a=='i' || a=='o' || a == 'u'
                || a=='A' || a=='E' || a=='I' || a=='O' || a == 'U');
    }
}
//leetcode submit region end(Prohibit modification and deletion)
