from typing import List
# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def containsDuplicate(self, nums: List[int]) -> bool:
        return len(set(nums)) != len(nums)
# leetcode submit region end(Prohibit modification and deletion)
