package medium

import (
	"fmt"
	"sort"
	"time"
)

func Max(x, y int) int {
	if x > y {
		return x
	} else {
		return y
	}
}
func Min(x, y int) int {
	if x < y {
		return x
	} else {
		return y
	}
}

type Tweets []Tweet
type Tweet struct {
	Id     int
	PostBy int
	time   int64
}

func (x Tweets) Len() int           { return len(x) }
func (x Tweets) Less(i, j int) bool { return x[i].time > x[j].time }
func (x Tweets) Swap(i, j int)      { x[i], x[j] = x[j], x[i] }
func (x Tweets) getTop(num int) []int {
	sort.Sort(x)
	var res []int
	for i := 0; i < Min(num, len(x)); i++ {
		res = append(res, x[i].Id)
	}
	fmt.Printf("%v %v\n", x, res)
	return res
}

type Twitter struct {
	//user->tweets
	mailBox map[int][]Tweet
	//follower->followee
	links map[int]map[int]bool
}

func Constructor() Twitter {
	return Twitter{mailBox: make(map[int][]Tweet), links: make(map[int]map[int]bool)}
}

func (this *Twitter) PostTweet(userId int, tweetId int) {
	postToUser := func(uid, tweet int) {
		if tweets, ok := this.mailBox[uid]; !ok {
			this.mailBox[uid] = []Tweet{Tweet{PostBy: userId, Id: tweet, time: time.Now().UnixNano()}}
		} else {
			tweets = append(tweets, Tweet{PostBy: userId, Id: tweet, time: time.Now().UnixNano()})
			this.mailBox[uid] = tweets
		}
	}
	//send to self
	postToUser(userId, tweetId)

}

func (this *Twitter) GetNewsFeed(userId int) []int {
	tweets := this.mailBox[userId]
	var ans []Tweet
	ans = append(ans, tweets[Max(0, len(tweets)-10):]...)
	if followee, ok := this.links[userId]; ok {
		for user, _ := range followee {
			if lst, ok := this.mailBox[user]; ok {
				ans = append(ans, lst[Max(0, len(lst)-10):]...)
			}
		}
	}
	return Tweets(ans).getTop(10)
}

func (this *Twitter) Follow(followerId int, followeeId int) {
	if _, ok := this.links[followerId]; !ok {
		this.links[followerId] = make(map[int]bool)
	}
	this.links[followerId][followeeId] = true
}

func (this *Twitter) Unfollow(followerId int, followeeId int) {
	delete(this.links[followerId], followeeId)
}

/**
 * Your Twitter object will be instantiated and called as such:
 * obj := Constructor();
 * obj.PostTweet(userId,tweetId);
 * param_2 := obj.GetNewsFeed(userId);
 * obj.Follow(followerId,followeeId);
 * obj.Unfollow(followerId,followeeId);
 */
