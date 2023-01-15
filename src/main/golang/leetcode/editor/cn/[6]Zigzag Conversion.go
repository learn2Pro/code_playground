package lc

import "strings"

//leetcode submit region begin(Prohibit modification and deletion)
func convert(s string, numRows int) string {
	if numRows == 1 {
		return s
	}
	var array = make([][]rune, numRows)
	var index int
	var direction = 1
	for _, c := range s {
		array[index] = append(array[index], c)
		index += direction
		if index == 0 {
			direction = 1
		} else if index == numRows-1 {
			direction = -1
		}
	}
	var ans []string
	for _, runes := range array {
		ans = append(ans, string(runes))
	}
	return strings.Join(ans, "")
}

//leetcode submit region end(Prohibit modification and deletion)
