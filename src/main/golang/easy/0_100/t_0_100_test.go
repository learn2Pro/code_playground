package easy

import (
	"github.com/stretchr/testify/assert"
	"testing"
)

func TestTwoSum(t *testing.T) {
	assert.Equal(t, twoSum([]int{1000000000000000000, 7, 11, 15}, 1000000000000000007), []int{0, 1})
	assert.Equal(t, twoSum([]int{2, 7, 11, 15}, 9), []int{0, 1})
	assert.Equal(t, twoSum([]int{3, 2, 4}, 6), []int{1, 2})
	assert.Equal(t, twoSum([]int{3, 3}, 6), []int{0, 1})
	assert.Nil(t, twoSum([]int{3}, 6))
}

func TestIsPalindrome(t *testing.T) {
	assert.Equal(t, isPalindrome(-1), false)
	assert.Equal(t, isPalindrome(1), true)
	assert.Equal(t, isPalindrome(12), false)
	assert.Equal(t, isPalindrome(22), true)
	assert.Equal(t, isPalindrome(232), true)
	assert.Equal(t, isPalindrome(121212121), true)
}

func TestRomanToInt(t *testing.T) {
	assert.Equal(t, romanToInt("I"), 1)
	assert.Equal(t, romanToInt("II"), 2)
	assert.Equal(t, romanToInt("III"), 3)
	assert.Equal(t, romanToInt("IV"), 4)
	assert.Equal(t, romanToInt("V"), 5)
	assert.Equal(t, romanToInt("VI"), 6)
	assert.Equal(t, romanToInt("VII"), 7)
	assert.Equal(t, romanToInt("VIII"), 8)
	assert.Equal(t, romanToInt("IX"), 9)
	assert.Equal(t, romanToInt("X"), 10)
	assert.Equal(t, romanToInt("XI"), 11)
	assert.Equal(t, romanToInt("XII"), 12)
	assert.Equal(t, romanToInt("XIII"), 13)
	assert.Equal(t, romanToInt("XIV"), 14)
	assert.Equal(t, romanToInt("XV"), 15)
	assert.Equal(t, romanToInt("XX"), 20)
	assert.Equal(t, romanToInt("XXI"), 21)
	assert.Equal(t, romanToInt("LVIII"), 58)
	assert.Equal(t, romanToInt("XCIX"), 99)
	assert.Equal(t, romanToInt("MCMXCIV"), 1994)
}

func TestLongestCommonPrefix(t *testing.T) {
	assert.Equal(t, longestCommonPrefix([]string{"flower", "flow", "flight"}), "fl")
	assert.Equal(t, longestCommonPrefix([]string{"dog", "racecar", "car"}), "")
}

func TestIsValid(t *testing.T) {
	assert.Equal(t, isValid(""), true)
	assert.Equal(t, isValid("("), false)
	assert.Equal(t, isValid("()"), true)
	assert.Equal(t, isValid("()[]{}"), true)
	assert.Equal(t, isValid("(]"), false)
	assert.Equal(t, isValid("((((((((()))[[]]))"), false)
}
func TestMergeTwoLists(t *testing.T) {
	assert.Equal(t, mergeTwoLists(&ListNode{Val: 5}, nil).Val, 5)
	assert.Equal(t, mergeTwoLists(nil, &ListNode{Val: 5}).Val, 5)
}
func TestRemoveDuplicates(t *testing.T) {
	//assert.Equal(t, removeDuplicates([]int{1, 1, 2}), 2)
	assert.Equal(t, removeDuplicates([]int{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}), 5)
	//assert.Equal(t, removeDuplicates([]int{0, 1, 2, 3, 4, 5, 6}), 7)
	//assert.Equal(t, removeDuplicates([]int{0, 0, 0, 0}), 1)
}
