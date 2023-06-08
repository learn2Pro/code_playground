from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def binary_search(self, nums, target):
        l, r = 0, len(nums)
        while l < r:
            mid = (l + r) >> 1
            if nums[mid] < target:
                l = mid + 1
            else:
                r = mid
        return l

    def countSmaller(self, nums: List[int]) -> List[int]:
        sorted_nums = []
        res = []
        for num in nums[::-1]:
            idx = self.binary_search(sorted_nums, num)
            res.append(idx)
            sorted_nums.insert(idx, num)
        return res[::-1]
# leetcode submit region end(Prohibit modification and deletion)
