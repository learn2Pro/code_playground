package medium

import "sort"

func findClosestElements(arr []int, k int, x int) []int {
	l, r := 0, len(arr)-k
	for l < r {
		mid := l + (r-l)/2
		if x-arr[mid] > arr[mid+k]-x {
			l = mid + 1
		} else {
			r = mid
		}
	}
	return arr[l : l+k]
}
func findClosestElements3(arr []int, k int, x int) []int {
	l, r := 0, len(arr)-1
	remain := len(arr) - k
	for ; remain > 0; remain-- {
		if x-arr[l] <= arr[r]-x {
			r--
		} else {
			l++
		}
	}
	return arr[l : l+k]
}

func findClosestElements2(arr []int, k int, x int) []int {
	r := sort.SearchInts(arr, x)
	l := r - 1
	for ; k > 0; k-- {
		if l < 0 {
			r++
		} else if r >= len(arr) || x-arr[l] <= arr[r]-x {
			l--
		} else {
			r++
		}
	}
	return arr[l+1 : r]
}

func findClosestElements1(arr []int, k int, x int) []int {
	abs := func(x int) int {
		if x < 0 {
			return -x
		}
		return x
	}
	sort.SliceStable(arr, func(i, j int) bool {
		return abs(arr[i]-x) < abs(arr[j]-x)
	})
	arr = arr[:k]
	sort.Ints(arr)
	return arr
}
