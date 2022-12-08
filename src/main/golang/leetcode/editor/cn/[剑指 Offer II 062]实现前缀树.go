package lc

//leetcode submit region begin(Prohibit modification and deletion)
type Trie struct {
	children [26]*Trie
	isEnd    bool
}

/** Initialize your data structure here. */
func Constructor() Trie {
	return Trie{}
}

/** Inserts a word into the trie. */
func (this *Trie) Insert(word string) {
	node := this
	for _, c := range word {
		idx := c - 'a'
		if node.children[idx] == nil {
			node.children[idx] = &Trie{}
		}
		node = node.children[idx]
	}
	node.isEnd = true
}
func (this *Trie) SearchPrefix(word string) *Trie {
	node := this
	for _, c := range word {
		idx := c - 'a'
		if node.children[idx] == nil {
			return nil
		}
		node = node.children[idx]
	}
	return node
}

/** Returns if the word is in the trie. */
func (this *Trie) Search(word string) bool {
	n := this.SearchPrefix(word)
	return n != nil && n.isEnd
}

/** Returns if there is any word in the trie that starts with the given prefix. */
func (this *Trie) StartsWith(prefix string) bool {
	n := this.SearchPrefix(prefix)
	return n != nil
}

/**
 * Your Trie object will be instantiated and called as such:
 * obj := Constructor();
 * obj.Insert(word);
 * param_2 := obj.Search(word);
 * param_3 := obj.StartsWith(prefix);
 */
//leetcode submit region end(Prohibit modification and deletion)
