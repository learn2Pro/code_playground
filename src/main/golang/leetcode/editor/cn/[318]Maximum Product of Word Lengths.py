from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def maxProduct(self, words: List[str]) -> int:
        words = [(len(word), set(word)) for word in words]
        words.sort(key=lambda x: x[0], reverse=True)
        res = 0
        for i in range(len(words)):
            for j in range(i + 1, len(words)):
                if not words[i][1] & words[j][1]:
                    res = max(res, words[i][0] * words[j][0])
                    break
        return res
# leetcode submit region end(Prohibit modification and deletion)
