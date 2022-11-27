package medium

func corpFlightBookings(bookings [][]int, n int) (ans []int) {
	diff := make([]int, n)
	for _, booking := range bookings {
		s, e, v := booking[0]-1, booking[1]-1, booking[2]
		diff[s] += v
		if e+1 < n {
			diff[e+1] -= v
		}
	}
	ans = append(ans, diff[0])
	for i := 1; i < n; i++ {
		ans = append(ans, ans[i-1]+diff[i])
	}
	return
}
