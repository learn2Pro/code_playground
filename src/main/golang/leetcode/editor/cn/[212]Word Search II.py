import collections
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
from collections import defaultdict
class Trie:
    def __init__(self):
        self.children = defaultdict(Trie)
        self.word = ""

    def insert(self, word):
        cur = self
        for c in word:
            cur = cur.children[c]
        cur.word = word

class Solution:
    def findWords(self, board: List[List[str]], words: List[str]) -> List[str]:
        trie = Trie()
        for word in words:
            trie.insert(word)

        m, n = len(board), len(board[0])
        ans = []

        def dfs(i, j, node):
            if node.word:
                ans.append(node.word)
                node.word = ''
            if 0 <= i < m and 0 <= j < n and board[i][j] in node.children:
                c = board[i][j]
                board[i][j] = '#'
                dfs(i + 1, j, node.children[c])
                dfs(i - 1, j, node.children[c])
                dfs(i, j + 1, node.children[c])
                dfs(i, j - 1, node.children[c])
                board[i][j] = c

        for i in range(m):
            for j in range(n):
                dfs(i, j, trie)
        return ans
# leetcode submit region end(Prohibit modification and deletion)
