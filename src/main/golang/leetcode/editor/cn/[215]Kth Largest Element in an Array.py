from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:

        n = len(nums)

        def quickSort(nums, l, r):
            if l >= r:
                return nums[l]
            i, j = l, r
            while i < j:
                while i < j and nums[j] >= nums[l]:
                    j -= 1
                while i < j and nums[i] <= nums[l]:
                    i += 1
                nums[i], nums[j] = nums[j], nums[i]
            nums[i], nums[l] = nums[l], nums[i]
            if i == n - k:
                return nums[i]
            elif i < n - k:
                return quickSort(nums, i + 1, r)
            else:
                return quickSort(nums, l, i - 1)

        return quickSort(nums, 0, len(nums) - 1)
# leetcode submit region end(Prohibit modification and deletion)
