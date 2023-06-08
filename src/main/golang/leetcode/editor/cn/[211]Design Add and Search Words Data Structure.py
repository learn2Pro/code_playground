# leetcode submit region begin(Prohibit modification and deletion)
class WordDictionary:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.trie = {}

    def addWord(self, word: str) -> None:
        """
        Adds a word into the data structure.
        """
        node = self.trie
        for c in word:
            node = node.setdefault(c, {})
        node['#'] = '#'  # mark the end of word

    def search(self, word: str) -> bool:
        """
        Returns if the word is in the data structure.
        A word could contain the dot character '.' to represent any one letter.
        """
        return self._search(word, self.trie)

    def _search(self, word: str, node: dict) -> bool:
        if not word:
            return '#' in node
        if word[0] == '.':
            return any(self._search(word[1:], node[c]) for c in node if c != '#')
        else:
            if word[0] not in node:
                return False
            return self._search(word[1:], node[word[0]])
# Your WordDictionary object will be instantiated and called as such:
# obj = WordDictionary()
# obj.addWord(word)
# param_2 = obj.search(word)
# leetcode submit region end(Prohibit modification and deletion)
