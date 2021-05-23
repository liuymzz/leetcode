//设计一个简化版的推特(Twitter)，可以让用户实现发送推文，关注/取消关注其他用户，能够看见关注人（包括自己）的最近十条推文。你的设计需要支持以下的几个
//功能： 
//
// 
// postTweet(userId, tweetId): 创建一条新的推文 
// getNewsFeed(userId): 检索最近的十条推文。每个推文都必须是由此用户关注的人或者是用户自己发出的。推文必须按照时间顺序由最近的开始排序。
// 
// follow(followerId, followeeId): 关注一个用户 
// unfollow(followerId, followeeId): 取消关注一个用户 
// 
//
// 示例: 
//
// 
//Twitter twitter = new Twitter();
//
//// 用户1发送了一条新推文 (用户id = 1, 推文id = 5).
//twitter.postTweet(1, 5);
//
//// 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
//twitter.getNewsFeed(1);
//
//// 用户1关注了用户2.
//twitter.follow(1, 2);
//
//// 用户2发送了一个新推文 (推文id = 6).
//twitter.postTweet(2, 6);
//
//// 用户1的获取推文应当返回一个列表，其中包含两个推文，id分别为 -> [6, 5].
//// 推文id6应当在推文id5之前，因为它是在5之后发送的.
//twitter.getNewsFeed(1);
//
//// 用户1取消关注了用户2.
//twitter.unfollow(1, 2);
//
//// 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
//// 因为用户1已经不再关注用户2.
//twitter.getNewsFeed(1);
// 
// Related Topics 堆 设计 哈希表 
// 👍 218 👎 0


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Twitter {

    public static int timestamp = 0;
    public static class User{
        private int id;
        private Set<Integer> followed;
        private Tweet head;
        public User(int id){
            followed=new HashSet<>();
            this.id = id;
            this.head=null;
            follow(id);
        }
        public void follow(int id){
            followed.add(id);
        }
        public void unfollow(int id){
            if (id != this.id){
                followed.remove(id);
            }
        }
        public void post(int tweetId){
            Tweet twt = new Tweet(tweetId,timestamp);
            timestamp++;
            twt.next=head;
            head=twt;
        }
    }
    public static class Tweet{
        private int id;
        private int time;
        private Tweet next;
        public Tweet(int id,int time){
            this.id = id;
            this.time=time;
            this.next=null;
        }
        public int getId() {
            return id;
        }
        public int getTime() {
            return time;
        }
        public Tweet getNext() {
            return next;
        }
    }

    /** Initialize your data structure here. */
    public Twitter() {

    }

    private final HashMap<Integer,User> userMap = new HashMap<>();

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if (!userMap.containsKey(userId)){
            userMap.put(userId,new User(userId));
        }
        userMap.get(userId).post(tweetId);
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        if (!userMap.containsKey(userId)) return res;
        PriorityQueue<Tweet> pq = new PriorityQueue<>((a,b)->b.time-a.time);
        for (Integer followeeId : userMap.get(userId).followed) {
            Tweet head = userMap.get(followeeId).head;
            if (head !=null){
                pq.add(head);
            }
        }

        while (!pq.isEmpty()){
            if (res.size()==10){
                return res;
            }
            Tweet poll = pq.poll();
            res.add(poll.id);
            if (poll.next!=null){
                pq.add(poll.next);
            }
        }

        return res;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId)){
            userMap.put(followerId,new User(followerId));
        }
        if (!userMap.containsKey(followeeId)){
            userMap.put(followeeId,new User(followeeId));
        }

        userMap.get(followerId).follow(followeeId);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (userMap.containsKey(followerId)){
            userMap.get(followerId).unfollow(followeeId);
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
//leetcode submit region end(Prohibit modification and deletion)
