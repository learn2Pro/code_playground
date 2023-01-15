package lc

import "github.com/emirpasic/gods/trees/redblacktree"

//leetcode submit region begin(Prohibit modification and deletion)
type ExamRoom struct {
	rbt      *redblacktree.Tree
	startMap map[int][]int
	endMap   map[int][]int
	N        int
}

func Constructor(n int) ExamRoom {
	dist := func(arr []int) int {
		x, y := arr[0], arr[1]
		if x == -1 || y == n {
			return y - x - 1
		}
		return (y - x) >> 1
	}
	rbt := redblacktree.NewWith(func(a, b interface{}) int {
		a0, a1 := a.([]int), b.([]int)
		d0, d1 := dist(a0), dist(a1)
		if d0 == d1 {
			return a0[0] - a1[0]
		}
		return d1 - d0
	})
	room := ExamRoom{rbt: rbt, startMap: make(map[int][]int), endMap: make(map[int][]int), N: n}
	room.Add([]int{-1, n})
	return room
}

func (this *ExamRoom) Seat() int {
	arr := this.rbt.Left().Key.([]int)
	var seat int
	if arr[0] == -1 {
		seat = 0
	} else if arr[1] == this.N {
		seat = this.N - 1
	} else {
		seat = arr[0] + (arr[1]-arr[0])/2
	}
	this.Del(arr)
	this.Add([]int{arr[0], seat})
	this.Add([]int{seat, arr[1]})
	return seat
}

func (this *ExamRoom) Leave(p int) {
	l, _ := this.startMap[p]
	r, _ := this.endMap[p]
	this.Del([]int{l[0], l[1]})
	this.Del([]int{r[0], r[1]})
	this.Add([]int{r[0], l[1]})

}
func (this *ExamRoom) Add(s []int) {
	this.rbt.Put(s, struct{}{})
	this.startMap[s[0]] = s
	this.endMap[s[1]] = s
}
func (this *ExamRoom) Del(s []int) {
	this.rbt.Remove(s)
	delete(this.startMap, s[0])
	delete(this.endMap, s[1])
}

/**
 * Your ExamRoom object will be instantiated and called as such:
 * obj := Constructor(n);
 * param_1 := obj.Seat();
 * obj.Leave(p);
 */
//leetcode submit region end(Prohibit modification and deletion)
