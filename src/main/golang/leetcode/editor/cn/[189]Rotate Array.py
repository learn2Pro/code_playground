from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        n = len(nums)
        k = k % n
        nums[:] = nums[len(nums) - k:] + nums[:len(nums) - k]
# leetcode submit region end(Prohibit modification and deletion)
