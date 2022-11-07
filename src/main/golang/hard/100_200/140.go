package hard

import "strings"

func wordBreak1(s string, wordDict []string) []string {
	contains := func(input string) bool {
		for _, s2 := range wordDict {
			if input == s2 {
				return true
			}
		}
		return false
	}
	var ans []string
	var tracker []string
	var backtrack func(left int)
	backtrack = func(left int) {
		if left == len(s) {
			var item = strings.Join(tracker, " ")
			ans = append(ans, item)
			return
		}
		for i := left + 1; i < len(s)+1; i++ {
			if !contains(s[left:i]) {
				continue
			}
			tracker = append(tracker, s[left:i])
			backtrack(i)
			tracker = tracker[:len(tracker)-1]
		}
	}
	backtrack(0)
	return ans
}

func wordBreak(s string, wordDict []string) []string {
	contains := func(input string) bool {
		for _, s2 := range wordDict {
			if input == s2 {
				return true
			}
		}
		return false
	}
	var ans []string
	var tracker []string
	var backtrack func(left, right int)
	backtrack = func(left, right int) {
		if right == len(s) {
			if contains(s[left:right]) {
				var item = strings.Join(append(tracker, s[left:right]), " ")
				ans = append(ans, item)
			}
			return
		}
		if contains(s[left:right]) {
			tracker = append(tracker, s[left:right])
			backtrack(right, right)
			tracker = tracker[:len(tracker)-1]
		}
		backtrack(left, right+1)
	}
	backtrack(0, 0)
	return ans
}
