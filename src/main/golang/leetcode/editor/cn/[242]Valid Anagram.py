# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        from collections import Counter
        alpa = Counter(s)
        alpb = Counter(t)
        return alpa == alpb

# leetcode submit region end(Prohibit modification and deletion)
