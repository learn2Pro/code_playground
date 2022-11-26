package hard

func maxSlidingWindow(nums []int, k int) (ans []int) {
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
