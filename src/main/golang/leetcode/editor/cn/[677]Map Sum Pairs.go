package lc

//leetcode submit region begin(Prohibit modification and deletion)
type Trie struct {
	children [26]*Trie
	value    int
	isEnd    bool
}
type MapSum struct {
	t       *Trie
	mapping map[string]int
}

func Constructor() MapSum {
	return MapSum{t: &Trie{}, mapping: make(map[string]int)}
}

func (this *MapSum) Insert(key string, val int) {
	var delta = val
	if v, ok := this.mapping[key]; ok {
		delta = val - v
	}
	curr := this.t
	for _, c := range key {
		idx := c - 'a'
		if curr.children[idx] == nil {
			curr.children[idx] = &Trie{value: delta}
		} else {
			curr.children[idx].value += delta
		}
		curr = curr.children[idx]
	}
	curr.isEnd = true
	this.mapping[key] = val
}

func (this *MapSum) Sum(prefix string) int {
	curr := this.t
	for _, c := range prefix {
		idx := c - 'a'
		if curr.children[idx] == nil {
			return 0
		}
		curr = curr.children[idx]
	}
	return curr.value
}

/**
 * Your MapSum object will be instantiated and called as such:
 * obj := Constructor();
 * obj.Insert(key,val);
 * param_2 := obj.Sum(prefix);
 */
//leetcode submit region end(Prohibit modification and deletion)
