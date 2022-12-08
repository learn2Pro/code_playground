package medium

type Node1 struct {
	Prev, Next *Node1
	key, Val   int
}

func NewNode(k, v int) *Node1 {
	return &Node1{key: k, Val: v}
}

type LRUCache struct {
	route      map[int]*Node1
	head, tail *Node1
	capacity   int
	size       int
}

func (lst *LRUCache) addLast(n *Node1) {
	lst.tail.Prev.Next, lst.tail.Prev, n.Prev = n, n, lst.tail.Prev
	n.Next = lst.tail
	lst.size += 1
}
func (lst *LRUCache) remove(n *Node1) *Node1 {
	prev, next := n.Prev, n.Next
	prev.Next, next.Prev = next, prev
	n.Prev, n.Next = nil, nil
	lst.size -= 1
	return n
}
func (lst *LRUCache) makeRecently(n *Node1) {
	lst.remove(n)
	lst.addLast(n)
}
func (lst *LRUCache) removeFirst() *Node1 {
	fst := lst.head.Next
	return lst.remove(fst)
}

func Constructor(capacity int) LRUCache {
	lru := LRUCache{
		route:    make(map[int]*Node1),
		head:     NewNode(0, 0),
		tail:     NewNode(0, 0),
		capacity: capacity,
	}
	lru.head.Next, lru.tail.Prev = lru.tail, lru.head
	return lru
}

func (this *LRUCache) Get(key int) int {
	if v, ok := this.route[key]; ok {
		this.makeRecently(v)
		return v.Val
	} else {
		return -1
	}
}

func (this *LRUCache) Put(key int, value int) {
	if v, ok := this.route[key]; ok {
		v.Val = value
		this.makeRecently(v)
	} else {
		n := NewNode(key, value)
		this.route[key] = n
		this.addLast(n)
	}
	for this.size > this.capacity { //evict
		n := this.removeFirst()
		delete(this.route, n.key)
	}
}
