package lc

//leetcode submit region begin(Prohibit modification and deletion)
type WordDictionary struct {
	children [26]*WordDictionary
	isEnd    bool
}
type Tuple struct {
	node  *WordDictionary
	index int
}

func Constructor() WordDictionary {
	return WordDictionary{}
}

func (this *WordDictionary) AddWord(word string) {
	node := this
	for _, c := range word {
		idx := c - 'a'
		if node.children[idx] == nil {
			node.children[idx] = &WordDictionary{}
		}
		node = node.children[idx]
	}
	node.isEnd = true
}
func (this *WordDictionary) SearchAll(word string) (res []*WordDictionary) {
	var queue = []Tuple{{node: this, index: 0}}
	for len(queue) > 0 {
		curr := queue[0]
		queue = queue[1:]
		if curr.node == nil {
			continue
		}
		if curr.index == len(word) {
			res = append(res, curr.node)
			continue
		}
		c := word[curr.index]
		if c == '.' {
			for i := 0; i < 26; i++ {
				if curr.node.children[i] != nil {
					queue = append(queue, Tuple{node: curr.node.children[i], index: curr.index + 1})
				}
			}
		} else {
			idx := c - 'a'
			if curr.node.children[idx] != nil {
				queue = append(queue, Tuple{node: curr.node.children[idx], index: curr.index + 1})
			}
		}
	}
	return
}

func (this *WordDictionary) Search(word string) bool {

	var dfs func(i int, node *WordDictionary) bool
	dfs = func(i int, node *WordDictionary) bool {
		if node == nil {
			return false
		}
		if i == len(word) {
			return node.isEnd
		}
		curr := word[i]
		if curr == '.' {
			for j := 0; j < 26; j++ {
				if dfs(i+1, node.children[j]) {
					return true
				}
			}
		} else {
			idx := curr - 'a'
			return dfs(i+1, node.children[idx])
		}
		return false
	}
	return dfs(0, this)
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * obj := Constructor();
 * obj.AddWord(word);
 * param_2 := obj.Search(word);
 */
//leetcode submit region end(Prohibit modification and deletion)
