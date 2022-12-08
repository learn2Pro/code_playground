package lc

//leetcode submit region begin(Prohibit modification and deletion)
type Node struct {
	Prev, Next *Node
	key, Val   int
}

func NewNode(k, v int) *Node {
	return &Node{key: k, Val: v}
}

type LRUCache struct {
	route          map[int]*Node
	head, tail     *Node
	capacity, size int
}

func (lst *LRUCache) addLast(n *Node) {
	lst.tail.Prev.Next, lst.tail.Prev, n.Prev, n.Next = n, n, lst.tail.Prev, lst.tail
	lst.size += 1
}
func (lst *LRUCache) remove(n *Node) *Node {
	n.Prev.Next, n.Next.Prev = n.Next, n.Prev
	lst.size -= 1
	return n

}
func (lst *LRUCache) makeRecently(n *Node) {
	lst.remove(n)
	lst.addLast(n)
}
func (lst *LRUCache) removeFirst() *Node {
	return lst.remove(lst.head.Next)
}

func Constructor(capacity int) LRUCache {
	lru := LRUCache{
		route:    make(map[int]*Node),
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

/**
 * Your LRUCache object will be instantiated and called as such:
 * obj := Constructor(capacity);
 * param_1 := obj.Get(key);
 * obj.Put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)
