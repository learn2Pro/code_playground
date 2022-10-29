package medium

func longestPalindrome(s string) string {
	palindrome := func(l int, r int) string {
		for l >= 0 && r < len(s) && s[l] == s[r] {
			l--;r++
		}
		return s[l+1 : r]
	}
	maxRes := func(fst string, snd string) string {
		if len(snd) > len(fst) {
			return snd
		} else {
			return fst
		}
	}
	var ans string
	for i := 0; i < len(s); i++ {
		ans = maxRes(maxRes(ans, palindrome(i, i)), palindrome(i, i+1))
	}
	return ans

}
