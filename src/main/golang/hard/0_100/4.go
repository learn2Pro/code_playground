package hard

import (
	"math"
	"sort"
)

func findMedianSortedArrays(nums1 []int, nums2 []int) float64 {
	m, n := len(nums1), len(nums2)
	arr := make([]int, 0, m+n)
	l, r := 0, 0
	for i := 0; i < m+n; i++ {
		if l == m {
			arr = append(arr, nums2[r:]...)
			break
		}
		if r == n {
			arr = append(arr, nums1[l:]...)
			break
		}
		if nums1[l] < nums2[r] {
			arr = append(arr, nums1[l])
			l++
		} else {
			arr = append(arr, nums2[r])
			r++
		}
	}
	if (m+n)%2 == 0 {
		return float64(arr[(m+n)/2]+arr[(m+n)/2-1]) / 2
	} else {
		return float64(arr[(m+n)/2])
	}
}
func findMedianSortedArrays3(nums1 []int, nums2 []int) float64 {
	if len(nums1) > len(nums2) {
		nums1, nums2 = nums2, nums1
	}
	m, n := len(nums1), len(nums2)
	total_left := (m + n + 1) / 2
	l, r := 0, m
	for l < r {
		i := l + (r-l+1)/2
		j := total_left - i
		//nums1[i-1]<=nums[j] && nums2[j-1]<=nums[i]
		if nums1[i-1] > nums2[j] {
			r = i - 1
		} else {
			l = i
		}
	}
	i, j := l, total_left-l
	var nums1Left, nums1Right, nums2Left, nums2Right int
	if i == 0 {
		nums1Left = math.MinInt32
	} else {
		nums1Left = nums1[i-1]
	}
	if i == m {
		nums1Right = math.MaxInt32
	} else {
		nums1Right = nums1[i]
	}
	if j == 0 {
		nums2Left = math.MinInt32
	} else {
		nums2Left = nums2[j-1]
	}
	if j == n {
		nums2Right = math.MaxInt32
	} else {
		nums2Right = nums2[j]
	}
	Min := func(i, j int) int {
		if i < j {
			return i
		}
		return j
	}
	Max := func(i, j int) int {
		if i > j {
			return i
		}
		return j
	}
	if (m+n)%2 == 0 {
		return float64(Max(nums1Left, nums2Left)+Min(nums1Right, nums2Right)) / 2
	} else {
		return float64(Max(nums1Left, nums2Left))
	}
}
func findMedianSortedArrays2(nums1 []int, nums2 []int) float64 {
	arr := make([]int, 0, len(nums1)+len(nums2))
	arr = append(arr, nums1...)
	arr = append(arr, nums2...)
	size := len(nums1) + len(nums2)
	sort.Ints(arr)
	if size%2 == 0 {
		return float64(arr[size/2]+arr[size/2-1]) / 2
	} else {
		return float64(arr[size/2])
	}
}
func findMedianSortedArrays1(nums1 []int, nums2 []int) float64 {
	m, n := len(nums1), len(nums2)
	x, y := 0, 0
	getMedian := func(nums []int) float64 {
		size := len(nums)
		if size%2 == 0 {
			return float64(nums[size/2]+nums[size/2-1]) / 2
		} else {
			return float64(nums[size/2])
		}
	}
	if m == 0 {
		return getMedian(nums2)
	}
	if n == 0 {
		return getMedian(nums1)
	}
	for x+y < (m+n-1)/2 {
		if nums1[x] > nums2[y] {
			y = sort.Search(n, func(i int) bool {
				return nums2[i] > nums1[x]
			})
		} else {
			x = sort.Search(m, func(i int) bool {
				return nums1[i] > nums2[y]
			})
		}
	}
	getItem := func(i int, nums []int) int {
		if i >= len(nums) {
			return nums[i-1]
		} else {
			return nums[i]
		}
	}
	Min := func(i, j int) int {
		if i < j {
			return i
		}
		return j
	}
	if (m+n)%2 == 0 {
		return float64(getItem(x, nums1)+getItem(y, nums2)) / 2
	} else {
		return float64(Min(getItem(x, nums1), getItem(y, nums2)))
	}
}
