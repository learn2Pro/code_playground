package medium

import (
	"sort"
)

func findBestValue(arr []int, target int) int {
	n := len(arr)
	abs := func(x int) int {
		if x < 0 {
			return -1 * x
		}
		return x
	}
	min := func(x, y int) int {
		if x < y {
			return x
		}
		return y
	}
	check := func(arr []int, x int) int {
		ret := 0
		for _, num := range arr {
			ret += min(num, x)
		}
		return ret
	}
	findLower := func(x int) int {
		l, r := 0, n
		for l < r {
			mid := l + (r-l)/2
			if arr[mid] < x {
				l = mid + 1
			} else {
				r = mid
			}
		}
		return r
	}
	sort.Ints(arr)
	var prefix = make([]int, n+1)
	for i := 1; i < n+1; i++ {
		prefix[i] = prefix[i-1] + arr[i-1]
	}

	ans := 0
	l, r := 0, arr[n-1]
	for l <= r {
		mid := l + (r-l)/2
		index := findLower(mid)
		cur := prefix[index] + (n-index)*mid
		if cur <= target {
			ans = mid
			l = mid + 1
		} else {
			r = mid - 1
		}
	}
	chooseSmall := check(arr, ans)
	chooseBig := check(arr, ans+1)
	if abs(chooseSmall-target) > abs(chooseBig-target) {
		ans++
	}
	return ans

}
