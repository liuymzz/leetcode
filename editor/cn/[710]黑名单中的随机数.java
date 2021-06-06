//给定一个包含 [0，n) 中不重复整数的黑名单 blacklist ，写一个函数从 [0, n) 中返回一个不在 blacklist 中的随机整数。 
//
// 对它进行优化使其尽量少调用系统方法 Math.random() 。 
//
// 提示: 
//
// 
// 1 <= n <= 1000000000 
// 0 <= blacklist.length < min(100000, N) 
// [0, n) 不包含 n ，详细参见 interval notation 。 
// 
//
// 示例 1： 
//
// 
//输入：
//["Solution","pick","pick","pick"]
//[[1,[]],[],[],[]]
//输出：[null,0,0,0]
// 
//
// 示例 2： 
//
// 
//输入：
//["Solution","pick","pick","pick"]
//[[2,[]],[],[],[]]
//输出：[null,1,1,1]
// 
//
// 示例 3： 
//
// 
//输入：
//["Solution","pick","pick","pick"]
//[[3,[1]],[],[],[]]
//输出：[null,0,0,2]
// 
//
// 示例 4： 
//
// 
//输入： 
//["Solution","pick","pick","pick"]
//[[4,[2]],[],[],[]]
//输出：[null,1,3,1]
// 
//
// 输入语法说明： 
//
// 输入是两个列表：调用成员函数名和调用的参数。Solution的构造函数有两个参数，n 和黑名单 blacklist。pick 没有参数，输入参数是一个列表
//，即使参数为空，也会输入一个 [] 空列表。 
// Related Topics 排序 哈希表 二分查找 Random 
// 👍 70 👎 0


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int mid;
    Map<Integer,Integer> map = new HashMap<>();
    Random r;

    public Solution(int n, int[] blacklist) {
        r = new Random();
        // 将小于n 的虚拟数组分成两半，右边为黑名单大小，将处于左边的黑名单值，映射到一个右边的非黑名单值
        mid = n-blacklist.length;
        HashSet<Integer> midRight = new HashSet<>();
        for (int i = mid; i < n; i++) {
            midRight.add(i);
        }
        for (int i : blacklist) {
            midRight.remove(i);
        }

        Iterator<Integer> iterator = midRight.iterator();
        for (int i : blacklist) {
            if (i<mid){
                map.put(i,iterator.next());
            }
        }

    }
    
    public int pick() {
        int i = r.nextInt(mid);
        if (map.containsKey(i))
            return map.get(i);

        return i;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(n, blacklist);
 * int param_1 = obj.pick();
 */
//leetcode submit region end(Prohibit modification and deletion)
