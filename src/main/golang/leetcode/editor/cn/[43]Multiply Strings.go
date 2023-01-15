package lc

//leetcode submit region begin(Prohibit modification and deletion)
func multiply(num1 string, num2 string) string {
	m, n := len(num1), len(num2)
	var ans = make([]int, m+n)
	for i := m - 1; i >= 0; i-- {
		for j := n - 1; j >= 0; j-- {
			s0, s1 := num1[i]-'0', num2[j]-'0'
			mul := int(s0*s1) + ans[i+j+1]
			ans[i+j+1] = mul % 10
			ans[i+j] += mul / 10
		}
	}
	var k = 0
	for ; k < len(ans); k++ {
		if ans[k] != 0 {
			break
		}
	}
	var res []byte
	for ; k < len(ans); k++ {
		res = append(res, byte(ans[k])+'0')
	}
	if len(res) == 0 {
		return "0"
	}
	return string(res)
}

//leetcode submit region end(Prohibit modification and deletion)
