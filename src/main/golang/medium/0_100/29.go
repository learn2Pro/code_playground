package medium

func letterCombinations(digits string) []string {
	mapping := map[rune][]rune{
		'2': []rune{'a', 'b', 'c'},
		'3': []rune{'d', 'e', 'f'},
		'4': []rune{'g', 'h', 'i'},
		'5': []rune{'j', 'k', 'l'},
		'6': []rune{'m', 'n', 'o'},
		'7': []rune{'p', 'q', 'r', 's'},
		'8': []rune{'t', 'u', 'v'},
		'9': []rune{'w', 'x', 'y', 'z'},
	}
	var ans []string
	var tracker []rune
	var backtrack func(index int)
	backtrack = func(index int) {
		if index == len(digits) {
			if len(tracker) > 0 {
				ans = append(ans, string(tracker))
			}
			return
		}
		if chars, ok := mapping[rune(digits[index])]; ok {
			for _, c := range chars {
				tracker = append(tracker, c)
				backtrack(index + 1)
				tracker = tracker[:len(tracker)-1]
			}
		}
	}
	backtrack(0)
	return ans
}
