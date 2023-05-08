# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def __init__(self):
        self.romans = {
            "I": 1,
            "V": 5,
            "X": 10,
            "L": 50,
            "C": 100,
            "D": 500,
            "M": 1000,

        }

    def romanToInt(self, s: str) -> int:
        ans, n = 0, len(s)
        for i in range(n):
            if i < n - 1 and self.romans[s[i]] < self.romans[s[i + 1]]:
                ans -= self.romans[s[i]]
            else:
                ans += self.romans[s[i]]
        return ans
# leetcode submit region end(Prohibit modification and deletion)
