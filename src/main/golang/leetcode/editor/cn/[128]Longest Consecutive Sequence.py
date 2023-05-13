from typing import List
# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        nums = set(nums)
        ans = 0
        for num in nums:
            if num - 1 not in nums:
                tmp = 1
                while num + 1 in nums:
                    tmp += 1
                    num += 1
                ans = max(ans, tmp)
        return ans
# leetcode submit region end(Prohibit modification and deletion)
