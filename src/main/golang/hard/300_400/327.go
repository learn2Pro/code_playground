package hard

import "sort"

type segTree []struct {
	l, r, val int
}

func (t segTree) build(o, l, r int) {
	t[o].l, t[o].r = l, r
	if l == r {
		return
	}
	mid := l + (r-l)/2
	t.build(o*2, l, mid)
	t.build(o*2+1, mid+1, r)

}
func (t segTree) inc(o, i int) {
	l, r := t[o].l, t[o].r
	if l == r {
		t[o].val++
		return
	}
	mid := l + (r-l)/2
	if i <= mid {
		t.inc(o<<1, i)
	} else {
		t.inc(o<<1|1, i)
	}
	t[o].val = t[o*2].val + t[o*2+1].val

}
func (t segTree) query(o, l, r int) int {
	if l <= t[o].l && t[o].r <= r {
		return t[o].val
	}
	mid := t[o].l + (t[o].r-t[o].l)/2
	if r <= mid {
		return t.query(o*2, l, r)
	}
	if l > mid {
		return t.query(o*2+1, l, r)
	}
	return t.query(o*2, l, r) + t.query(o*2+1, l, r)
}
func countRangeSum(nums []int, lower int, upper int) (cnt int) {
	n := len(nums)

	// 计算前缀和 preSum，以及后面统计时会用到的所有数字 allNums
	allNums := make([]int, 1, 3*n+1)
	preSum := make([]int, n+1)
	for i, v := range nums {
		preSum[i+1] = preSum[i] + v
		allNums = append(allNums, preSum[i+1], preSum[i+1]-lower, preSum[i+1]-upper)
	}

	// 将 allNums 离散化
	sort.Ints(allNums)
	k := 1
	kth := map[int]int{allNums[0]: k}
	for i := 1; i <= 3*n; i++ {
		if allNums[i] != allNums[i-1] {
			k++
			kth[allNums[i]] = k
		}
	}

	// 遍历 preSum，利用线段树计算每个前缀和对应的合法区间数
	t := make(segTree, 4*k)
	t.build(1, 1, k)
	t.inc(1, kth[0])
	for _, sum := range preSum[1:] {
		left, right := kth[sum-upper], kth[sum-lower]
		cnt += t.query(1, left, right)
		t.inc(1, kth[sum])
	}
	return
}
func countRangeSum2(nums []int, lower int, upper int) int {
	var mergeCount func(slice []int) int
	mergeCount = func(slice []int) int {
		n := len(slice)
		if n <= 1 {
			return 0
		}
		n1 := append([]int{}, slice[:n/2]...)
		n2 := append([]int{}, slice[n/2:]...)

		var cnt = mergeCount(n1) + mergeCount(n2)
		l, r := 0, 0
		for _, v := range n1 {
			for l < len(n2) && n2[l]-v < lower {
				l++
			}
			for r < len(n2) && n2[r]-v <= upper {
				r++
			}
			cnt += (r - l)
		}

		p0, p1 := 0, 0
		for i := 0; i < len(slice); i++ {
			if p0 < len(n1) && (p1 == len(n2) || n1[p0] <= n2[p1]) {
				slice[i] = n1[p0]
				p0++
			} else {
				slice[i] = n2[p1]
				p1++
			}
		}
		return cnt
	}
	n := len(nums)
	prefix := make([]int, n+1)
	for i := 1; i <= n; i++ {
		prefix[i] = prefix[i-1] + nums[i-1]
	}
	return mergeCount(prefix)
}

func countRangeSum1(nums []int, lower int, upper int) int {
	n := len(nums)
	prefix := make([]int, n+1)
	for i := 1; i <= n; i++ {
		prefix[i] = prefix[i-1] + nums[i-1]
	}
	var ans int
	for i := 0; i < n; i++ {
		for j := i; j < n; j++ {
			if prefix[j+1]-prefix[i] >= lower && prefix[j+1]-prefix[i] <= upper {
				ans += 1
			}
		}
	}
	return ans
}
