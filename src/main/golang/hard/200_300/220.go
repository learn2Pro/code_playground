package hard

import "math/rand"

type node struct {
	ch       [2]*node
	priority int
	val      int
}

func (o *node) cmp(b int) int {
	switch {
	case b < o.val:
		return 0
	case b > o.val:
		return 1
	default:
		return -1
	}
}

func (o *node) rotate(d int) *node {
	x := o.ch[d^1]
	o.ch[d^1] = x.ch[d]
	x.ch[d] = o
	return x
}

type treap struct {
	root *node
}

func (t *treap) _put(o *node, val int) *node {
	if o == nil {
		return &node{priority: rand.Int(), val: val}
	}
	d := o.cmp(val)
	o.ch[d] = t._put(o.ch[d], val)
	if o.ch[d].priority > o.priority {
		o = o.rotate(d ^ 1)
	}
	return o
}

func (t *treap) put(val int) {
	t.root = t._put(t.root, val)
}

func (t *treap) _delete(o *node, val int) *node {
	if d := o.cmp(val); d >= 0 {
		o.ch[d] = t._delete(o.ch[d], val)
		return o
	}
	if o.ch[1] == nil {
		return o.ch[0]
	}
	if o.ch[0] == nil {
		return o.ch[1]
	}
	d := 0
	if o.ch[0].priority > o.ch[1].priority {
		d = 1
	}
	o = o.rotate(d)
	o.ch[d] = t._delete(o.ch[d], val)
	return o
}

func (t *treap) delete(val int) {
	t.root = t._delete(t.root, val)
}

func (t *treap) lowerBound(val int) (lb *node) {
	for o := t.root; o != nil; {
		switch c := o.cmp(val); {
		case c == 0:
			lb = o
			o = o.ch[0]
		case c > 0:
			o = o.ch[1]
		default:
			return o
		}
	}
	return
}

func containsNearbyAlmostDuplicate(nums []int, k, t int) bool {
	Abs := func(x, y int) int {
		if x > y {
			return x - y
		}
		return y - x
	}
	GetId := func(x, div int) int {
		if x >= 0 {
			return x / div
		}
		return (x+1)/div - 1
	}
	mp := make(map[int]int)
	for i, num := range nums {
		id := GetId(num, t+1)
		if _, ok := mp[id]; ok {
			return true
		}
		if v, ok := mp[id+1]; ok && Abs(num, v) <= t {
			return true
		}
		if v, ok := mp[id-1]; ok && Abs(num, v) <= t {
			return true
		}
		mp[id] = num
		if i >= k {
			delete(mp, GetId(nums[i-k], t+1))
		}
	}
	return false
}
func containsNearbyAlmostDuplicate1(nums []int, k, t int) bool {
	set := &treap{}
	for i, v := range nums {
		if lb := set.lowerBound(v - t); lb != nil && lb.val <= v+t {
			return true
		}
		set.put(v)
		if i >= k {
			set.delete(nums[i-k])
		}
	}
	return false
}
