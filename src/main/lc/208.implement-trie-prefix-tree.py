#
# @lc app=leetcode id=208 lang=python3
#
# [208] Implement Trie (Prefix Tree)
#

# @lc code=start
class Trie:

    def __init__(self):
        self.word = {}

    def insert(self, word: str) -> None:
        curr = self.word
        for c in word:
            if c not in curr:
                curr[c] = {}
            curr = curr[c]
        curr['end'] = True

    def search(self, word: str) -> bool:
        curr = self.word
        for c in word:
            if c not in curr:
                return False
            curr = curr[c]
        return 'end' in curr

    def startsWith(self, prefix: str) -> bool:
        curr = self.word
        for c in prefix:
            if c not in curr:
                return False
            curr = curr[c]
        return True


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)
# @lc code=end

if __name__ == "__main__":
    s = Trie()
    s.insert('apple')
    print(s.search('apple'))
    print(s.search('app'))
    print(s.startsWith('app'))
    s.insert('app')
    print(s.search('app'))
