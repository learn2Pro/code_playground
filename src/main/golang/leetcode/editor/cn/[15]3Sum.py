# leetcode submit region begin(Prohibit modification and deletion)
from typing import List


class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        n = len(nums)
        ans = []
        previous = -10 ** 5 - 1
        for i in range(0, n - 2):
            target = nums[i]
            if target == previous:
                continue
            previous = target
            l, r = i + 1, n - 1
            while l < r:
                left, right = nums[l], nums[r]
                if left + right == -target:
                    ans.append([target, left, right])
                    while l < r and nums[l] == left: l += 1
                    while l < r and nums[r] == right: r -= 1
                elif left + right > -target:
                    while l < r and nums[r] == right: r -= 1
                else:
                    while l < r and nums[l] == left: l += 1
        print(ans)
        return ans
# leetcode submit region end(Prohibit modification and deletion)
