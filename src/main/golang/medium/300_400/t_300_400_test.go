package medium

import (
	"fmt"
	"github.com/stretchr/testify/assert"
	"testing"
)

func TestTwitter_Follow(t *testing.T) {
	var twitter = Constructor()
	twitter.PostTweet(1, 5) // 用户 1 发送了一条新推文 (用户 id = 1, 推文 id = 5)
	// 用户 1 的获取推文应当返回一个列表，其中包含一个 id 为 5 的推文
	assert.Equal(t, twitter.GetNewsFeed(1), []int{5})
	twitter.Follow(1, 2)    // 用户 1 关注了用户 2
	twitter.PostTweet(2, 6) // 用户 2 发送了一个新推文 (推文 id = 6)
	// 用户 1 的获取推文应当返回一个列表，其中包含两个推文，id 分别为 -> [6, 5] 。推文 id 6 应当在推文 id 5 之前，因为它是在 5 之后发送的
	fmt.Printf("%v", twitter.GetNewsFeed(1))
	assert.Equal(t, []int{6, 5}, twitter.GetNewsFeed(1))
	twitter.Unfollow(1, 2) // 用户 1 取消关注了用户 2
	// 用户 1 获取推文应当返回一个列表，其中包含一个 id 为 5 的推文。因为用户 1 已经不再关注用户 2
	assert.Equal(t, twitter.GetNewsFeed(1), []int{5})

}

func TestTweets_1(t *testing.T) {
	//["Twitter","postTweet","follow","follow","getNewsFeed","postTweet","getNewsFeed","getNewsFeed","unfollow","getNewsFeed","getNewsFeed","unfollow","getNewsFeed","getNewsFeed"]
	//	[[],[1,5],[1,2],[2,1],[2],[2,6],[1],[2],[2,1],[1],[2],[1,2],[1],[2]]
	var twitter = Constructor()
	twitter.PostTweet(1, 5) // 用户 1 发送了一条新推文 (用户 id = 1, 推文 id = 5)
	twitter.Follow(1, 2)
	twitter.Follow(2, 1)
	assert.Equal(t, []int{5}, twitter.GetNewsFeed(2))
	twitter.PostTweet(2, 6)
	assert.Equal(t, []int{6, 5}, twitter.GetNewsFeed(1))
	assert.Equal(t, []int{6, 5}, twitter.GetNewsFeed(2))
	twitter.Unfollow(2, 1)
	assert.Equal(t, []int{6, 5}, twitter.GetNewsFeed(1))
	assert.Equal(t, []int{6}, twitter.GetNewsFeed(2))
	twitter.Unfollow(1, 2)
	assert.Equal(t, []int{5}, twitter.GetNewsFeed(1))
	assert.Equal(t, []int{6}, twitter.GetNewsFeed(2))

}

func Test310(t *testing.T) {
	//assert.Equal(t, []int{1}, findMinHeightTrees(4, [][]int{{1, 0}, {1, 2}, {1, 3}}))
	assert.Equal(t, []int{4, 3}, findMinHeightTrees(6, [][]int{{3, 0}, {3, 1}, {3, 2}, {3, 4}, {5, 4}}))
}

func Test300(t *testing.T) {
	assert.Equal(t, 6, lengthOfLIS([]int{3, 5, 6, 2, 5, 4, 19, 5, 6, 7, 12}))
	assert.Equal(t, 4, lengthOfLIS([]int{10, 9, 2, 5, 3, 7, 101, 18}))
}

func Test395(t *testing.T) {
	assert.Equal(t, 6, longestSubstring("aaabbb", 3))
	assert.Equal(t, 1, longestSubstring("a", 1))
	assert.Equal(t, 4, longestSubstring("aaaa", 1))
	assert.Equal(t, 6, longestSubstring("ababcc", 2))
	assert.Equal(t, 5, longestSubstring("ababbc", 2))
}
