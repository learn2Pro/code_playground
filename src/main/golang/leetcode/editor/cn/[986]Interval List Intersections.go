package lc

//leetcode submit region begin(Prohibit modification and deletion)
func intervalIntersection(firstList [][]int, secondList [][]int) [][]int {
	Max := func(x, y int) int {
		if x > y {
			return x
		}
		return y
	}
	Min := func(x, y int) int {
		if x < y {
			return x
		}
		return y
	}
	var ans [][]int
	var i, j int
	for i < len(firstList) && j < len(secondList) {
		a1, a2 := firstList[i][0], firstList[i][1]
		b1, b2 := secondList[j][0], secondList[j][1]
		if b2 >= a1 && a2 >= b1 {
			ans = append(ans, []int{Max(a1, b1), Min(a2, b2)})
		}
		if b2 < a2 {
			j++
		} else {
			i++
		}
	}
	return ans
}

//leetcode submit region end(Prohibit modification and deletion)
