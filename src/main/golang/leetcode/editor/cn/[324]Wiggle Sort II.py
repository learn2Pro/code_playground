from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def wiggleSort(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        n = len(nums)
        arr = sorted(nums)
        print(arr)
        for i in range(1, n, 2):
            nums[i] = arr.pop()
        for i in range(0, n, 2):
            nums[i] = arr.pop()

# leetcode submit region end(Prohibit modification and deletion)
