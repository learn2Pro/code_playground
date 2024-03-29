package hard

type mqueue []int

func (t *mqueue) Len() int          { return len(*t) }
func (t *mqueue) Get(i int) (v int) { a := *t; v = a[i]; return }
func (t *mqueue) push(n int) {
	for t.Len() > 0 && n > t.Get(t.Len()-1) {
		a := *t
		*t = a[:a.Len()-1]
	}
	*t = append(*t, n)
}
func (t *mqueue) max() (v int) { a := *t; v = a[0]; return }
func (t *mqueue) pop(n int) {
	a := *t
	if a[0] == n {
		*t = a[1:]
	}
}

func maxSlidingWindow(nums []int, k int) (ans []int) {
	mq := &mqueue{}
	n := len(nums)
	for i := 0; i < n; i++ {
		mq.push(nums[i])
		if i >= k {
			mq.pop(nums[i-k])
		}
		if i >= k-1 {
			ans = append(ans, mq.max())
		}
	}
	return
}

func maxSlidingWindow1(nums []int, k int) (ans []int) {
	var mqueue []int
	for i, num := range nums {
		for len(mqueue) > 0 && num > mqueue[len(mqueue)-1] {
			mqueue = mqueue[:len(mqueue)-1]
		}
		mqueue = append(mqueue, num)
		if i >= k {
			if nums[i-k] == mqueue[0] {
				mqueue = mqueue[1:]
			}
		}
		if i >= k-1 {
			ans = append(ans, mqueue[0])
		}
	}
	return
}
