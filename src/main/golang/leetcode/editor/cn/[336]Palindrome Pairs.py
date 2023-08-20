from typing import List
# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def palindromePairs(self, words: List[str]) -> List[List[int]]:
        def is_palindrome(word):
            return word == word[::-1]

        word2idx = {word: i for i, word in enumerate(words)}
        res = []
        for i, word in enumerate(words):
            n = len(word)
            for j in range(n + 1):
                prefix = word[:j]
                suffix = word[j:]
                if is_palindrome(prefix):
                    back = suffix[::-1]
                    if back in word2idx and word2idx[back] != i:
                        res.append([word2idx[back], i])
                if j != n and is_palindrome(suffix):
                    back = prefix[::-1]
                    if back in word2idx and word2idx[back] != i:
                        res.append([i, word2idx[back]])
        return res
# leetcode submit region end(Prohibit modification and deletion)
