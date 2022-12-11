package hard

func maxCoins(nums []int) (ans int) {
	Max := func(x, y int) int {
		if x > y {
			return x
		}
		return y
	}
	var burst func(arr []int, sum int)
	burst = func(arr []int, sum int) {
		if len(arr) == 0 {
			ans = Max(ans, sum)
			return
		}
		for i, num := range arr {
			var s int
			if len(arr) == 1 {
				s = num
			} else if i == 0 {
				s = num * arr[i+1]
			} else if i == len(arr)-1 {
				s = num * arr[i-1]
			} else {
				s = arr[i-1] * num * arr[i+1]
			}
			var x []int
			x = append(x, arr[:i]...)
			x = append(x, arr[i+1:]...)
			burst(x, sum+s)
		}
	}
	burst(nums, 0)
	return
}
