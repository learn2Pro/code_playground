# 820. Short Encoding of Words
from typing import List

'''
["time", "me", "bell"]
["t","a","b"]
["ttt","tt","t"]
["tab","b","cab","ctab"]
["cd","dc"]
["a","a","a"]
'''


class _820_Solution:
    # use reverse sort
    def minimumLengthEncoding(self, words: List[str]) -> int:
        sort_words = sorted([word[::-1] for word in words])
        current_word, ans = '', 0
        for word in sort_words:
            if not word.startswith(current_word):
                ans += len(current_word) + 1
            current_word = word
        ans += len(current_word) + 1
        return ans

    # use set
    def minimumLengthEncoding(self, words: List[str]) -> int:
        words_set = set(words)
        for word in words:
            for i in range(1, len(word)):
                words_set.discard(word[i:])
        return sum(len(x) + 1 for x in words_set)

    # use trie
    def minimumLengthEncoding(self, words: List[str]) -> int:
        class Trie:
            def __init__(self):
                self.lookup = {}

            def insert(self, word):
                current = self.lookup
                for c in word:
                    if c not in current: current[c] = {}
                    current = current[c]
                current['_'] = word

            def accumulate(self):
                ans = 0

                def dfs(current):
                    nonlocal ans
                    if '_' in current and len(current) == 1:
                        ans += len(current['_']) + 1
                        return
                    for k, v in current.items():
                        if k == '_': continue
                        dfs(current[k])

                dfs(self.lookup)
                return ans

        trie = Trie()
        for word in words:
            trie.insert(word[::-1])
        return trie.accumulate()


if __name__ == '__main__':
    obj = _820_Solution()
    assert obj.minimumLengthEncoding(["time", "me", "bell"]) == 10
