#
# @lc app=leetcode id=16 lang=python3
#
# [16] 3Sum Closest
#
from typing import List
# @lc code=start


class Solution:
    def threeSumClosest(self, nums: List[int], target: int) -> int:
        nums.sort()
        ans = nums[0]+nums[1]+nums[2]
        for p0 in range(len(nums)):
            if p0 > 0 and nums[p0] == nums[p0-1]:
                continue
            l, r = p0+1, len(nums)-1
            while l < r:
                s = nums[p0]+nums[l]+nums[r]
                # print(p0, l, r, nums[p0], nums[l], nums[r], s, target)
                if abs(s-target) < abs(ans-target):
                    ans = s
                if s < target:
                    l += 1
                else:
                    r -= 1
        return ans


# @lc code=end
if __name__ == "__main__":
    s = Solution()
    print(s.threeSumClosest([-1, 2, 1, -4], 1))
    print(s.threeSumClosest([0, 0, 0], 1))
    print(s.threeSumClosest([4, 0, 5, -5, 3, 3, 0, -4, -5], -2))
