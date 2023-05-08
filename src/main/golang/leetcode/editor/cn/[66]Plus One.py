from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:
        for i in reversed(range(len(digits))):
            digits[i] += 1
            digits[i] %= 10
            if digits[i] != 0: return digits
        digits.insert(0, 1)
        return digits
# leetcode submit region end(Prohibit modification and deletion)
