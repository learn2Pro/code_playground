from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        ans = 0
        for i in range(32):
            total = sum((num >> i) & 1 for num in nums)
            if total % 3:
                if i==31:
                    ans-= 1 << i
                else:
                    ans |= 1 << i
        return ans

# leetcode submit region end(Prohibit modification and deletion)
