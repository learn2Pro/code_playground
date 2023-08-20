from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def increasingTriplet(self, nums: List[int]) -> bool:
        fst, snd = nums[0], float('inf')
        for i in range(1, len(nums)):
            if nums[i] > snd:
                return True
            if nums[i] > fst:
                snd = nums[i]
            else:
                fst = nums[i]
        return False
# leetcode submit region end(Prohibit modification and deletion)
