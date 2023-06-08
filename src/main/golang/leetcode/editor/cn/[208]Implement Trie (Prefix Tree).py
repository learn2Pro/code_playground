
# leetcode submit region begin(Prohibit modification and deletion)
class Trie:

        def __init__(self):
            """
            Initialize your data structure here.
            """
            self.root = {}
            self.end_of_word = '#'

        def insert(self, word: str) -> None:
            """
            Inserts a word into the trie.
            """
            node = self.root  # node is a dict
            for c in word:
                node = node.setdefault(c, {})
            node[self.end_of_word] = self.end_of_word  # mark the end of word

        def search(self, word: str) -> bool:
            """
            Returns if the word is in the trie.
            """
            node = self._search_prefix(word)
            return node is not None and self.end_of_word in node  # node is not None and node has key '#'

        def _search_prefix(self, prefix: str) -> dict:
            node = self.root
            for c in prefix:
                if c not in node:
                    return None
                node = node[c]
            return node  # return the node of the last char of prefix

        def startsWith(self, prefix: str) -> bool:
            """
            Returns if there is any word in the trie that starts with the given prefix.
            """
            node = self._search_prefix(prefix)
            return node is not None



# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)
# leetcode submit region end(Prohibit modification and deletion)
