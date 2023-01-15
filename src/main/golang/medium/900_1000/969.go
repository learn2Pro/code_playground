package medium

func pancakeSort(arr []int) (ans []int) {

	reverse := func(x, y int) {
		for x < y {
			arr[x], arr[y] = arr[y], arr[x]
			x, y = x+1, y-1
		}
	}
	var sort func(n int)
	sort = func(n int) {
		if n == 1 {
			return
		}
		var index int
		var maximal = arr[0]
		for i := 1; i < n; i++ {
			if arr[i] > maximal {
				maximal, index = arr[i], i
			}
		}
		if index != 0 {
			reverse(0, index)
			ans = append(ans, index+1)
		}
		reverse(0, n-1)
		ans = append(ans, n)
		sort(n - 1)
	}
	sort(len(arr))
	return
}
