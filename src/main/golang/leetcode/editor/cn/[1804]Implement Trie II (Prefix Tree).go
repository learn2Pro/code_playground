package lc

//leetcode submit region begin(Prohibit modification and deletion)
type Trie struct {
	children [26]*Trie
	count1   int
	count2   int
	isEnd    bool
}

func Constructor() Trie {
	return Trie{}
}

func (this *Trie) Insert(word string) {
	curr := this
	for _, c := range word {
		idx := c - 'a'
		if curr.children[idx] == nil {
			curr.children[idx] = &Trie{}
		}
		curr = curr.children[idx]
		curr.count1 += 1
	}
	curr.isEnd = true
	curr.count2 += 1
}

func (this *Trie) CountWordsEqualTo(word string) int {
	curr := this
	for _, c := range word {
		idx := c - 'a'
		if curr.children[idx] == nil {
			return 0
		}
		curr = curr.children[idx]
	}
	if !curr.isEnd {
		return 0
	}
	return curr.count2
}

func (this *Trie) CountWordsStartingWith(prefix string) int {
	curr := this
	for _, c := range prefix {
		idx := c - 'a'
		if curr.children[idx] == nil {
			return 0
		}
		curr = curr.children[idx]
	}
	return curr.count1
}

func (this *Trie) Erase(word string) {
	curr := this
	for _, c := range word {
		idx := c - 'a'
		curr = curr.children[idx]
		curr.count1 -= 1
	}
	curr.count2 -= 1
}

/**
 * Your Trie object will be instantiated and called as such:
 * obj := Constructor();
 * obj.Insert(word);
 * param_2 := obj.CountWordsEqualTo(word);
 * param_3 := obj.CountWordsStartingWith(prefix);
 * obj.Erase(word);
 */
//leetcode submit region end(Prohibit modification and deletion)
