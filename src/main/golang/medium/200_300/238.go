package medium

func productExceptSelf(nums []int) (ans []int) {

	n := len(nums)
	ans0 := make([]int, n)
	ans1 := make([]int, n)
	ans0[0], ans0[n-1] = 1, 1
	ans1[0], ans1[n-1] = 1, 1
	for i := 1; i < n; i++ {
		ans0[i] = ans0[i-1] * nums[i-1]
	}
	for j := n - 2; j >= 0; j-- {
		ans1[j] = ans1[j+1] * nums[j+1]
	}
	for i := 0; i < n; i++ {
		ans = append(ans, ans0[i]*ans1[i])
	}
	return ans
}
