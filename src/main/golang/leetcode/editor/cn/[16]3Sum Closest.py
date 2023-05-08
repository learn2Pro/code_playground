from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def threeSumClosest(self, nums: List[int], target: int) -> int:
        nums.sort()
        n = len(nums)
        ans = 0x7fffffff
        for i in range(n - 2):
            l, r = i + 1, n - 1
            delta = 0x7fffffff
            while l < r:
                sum = nums[i] + nums[l] + nums[r]
                if abs(sum - target) < abs(delta):
                    delta = sum - target
                if sum < target:
                    l += 1
                else:
                    r -= 1
            if abs(delta) < abs(ans):
                ans = delta
        return target + ans

# leetcode submit region end(Prohibit modification and deletion)
