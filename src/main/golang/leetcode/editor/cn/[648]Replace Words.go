package lc

import "strings"

//leetcode submit region begin(Prohibit modification and deletion)
type Trie struct {
	children [26]*Trie
	isEnd    bool
}

func (t *Trie) insert(word string) {
	curr := t
	for _, c := range word {
		idx := c - 'a'
		if curr.children[idx] == nil {
			curr.children[idx] = &Trie{}
		}
		curr = curr.children[idx]
	}
	curr.isEnd = true
}
func (t *Trie) searchPrefix(word string) string {
	curr := t
	var i int
	for ; i < len(word); i++ {
		idx := word[i] - 'a'
		if curr.isEnd || curr.children[idx] == nil {
			break
		}
		curr = curr.children[idx]
	}
	if curr.isEnd {
		return word[:i]
	} else {
		return ""
	}
}

func replaceWords(dictionary []string, sentence string) string {
	t := &Trie{}
	for _, dic := range dictionary {
		t.insert(dic)
	}
	var ans []string
	words := strings.Split(sentence, " ")
	for _, word := range words {
		item := t.searchPrefix(word)
		if len(item) == 0 {
			ans = append(ans, word)
		} else {
			ans = append(ans, item)
		}
	}
	return strings.Join(ans, " ")
}

//leetcode submit region end(Prohibit modification and deletion)
