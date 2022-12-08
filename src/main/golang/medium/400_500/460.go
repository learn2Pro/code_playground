package medium

type Node struct {
	key, value int
	prev, next *Node
	freq       int
}
type LinkedList struct {
	head, tail *Node
	size       int
}

func NewNode(key, value, freq int) *Node {
	return &Node{key: key, value: value, freq: freq}
}
func NewList() *LinkedList {
	lst := &LinkedList{
		head: NewNode(0, 0, 0),
		tail: NewNode(0, 0, 0),
	}
	lst.head.next, lst.tail.prev = lst.tail, lst.head
	return lst
}
func (lst *LinkedList) addLast(n *Node) {
	lst.tail.prev.next, lst.tail.prev, n.prev, n.next = n, n, lst.tail.prev, lst.tail
	lst.size += 1
}
func (lst *LinkedList) remove(n *Node) *Node {
	n.prev.next, n.next.prev = n.next, n.prev
	lst.size -= 1
	return n
}
func (lst *LinkedList) removeFirst() *Node {
	return lst.remove(lst.head.next)
}

type LFUCache struct {
	route    map[int]*Node
	freq     map[int]*LinkedList
	minFreq  int
	capacity int
}

func Constructor(capacity int) LFUCache {
	return LFUCache{
		route:    make(map[int]*Node),
		freq:     make(map[int]*LinkedList),
		capacity: capacity,
	}
}

func (this *LFUCache) Get(key int) int {
	if node, ok := this.route[key]; ok {
		this.incrFreq(node)
		return node.value
	} else {
		return -1
	}
}

func (this *LFUCache) Put(key int, value int) {
	if node, ok := this.route[key]; ok {
		this.incrFreq(node)
	} else {
		for len(this.route) == this.capacity { //evict
			this.removeLeastFreq()
		}
		n := NewNode(key, value, 1)
		this.route[key] = n
		if l2, ok := this.freq[1]; ok {
			l2.addLast(n)
		} else {
			this.freq[1] = NewList()
			this.freq[1].addLast(n)
		}
		this.minFreq = 1
	}
}
func (this *LFUCache) removeLeastFreq() {
	lst := this.freq[this.minFreq]
	if lst == nil {
		return
	}
	n := lst.removeFirst()
	if lst.size == 0 {
		if n.freq == this.minFreq {
			this.minFreq += 1
		}
	}
	delete(this.route, n.key)
}
func (this *LFUCache) incrFreq(node *Node) {
	f := node.freq
	lst := this.freq[f]
	lst.remove(node)
	if lst.size == 0 {
		delete(this.freq, f)
		if this.minFreq == f {
			this.minFreq += 1
		}
	}
	node.freq += 1
	if l2, ok := this.freq[f+1]; ok {
		l2.addLast(node)
	} else {
		this.freq[f+1] = NewList()
		this.freq[f+1].addLast(node)
	}
}
