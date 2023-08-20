#
# @lc app=leetcode id=15 lang=python3
#
# [15] 3Sum
#
from typing import List
# @lc code=start


class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        # nums.sort()
        # ans = []
        # for p0 in range(len(nums)-2):
        #     if p0 > 0 and nums[p0] == nums[p0-1]:
        #         continue
        #     for p1 in reversed(range(p0+2, len(nums))):
        #         if p1 != len(nums)-1 and nums[p1] == nums[p1+1]:
        #             continue

        #         target = -(nums[p0]+nums[p1])
        #         # print(p0, p1, target)
        #         l, r = p0+1, p1-1
        #         while l <= r:
        #             mid = (l+r)//2
        #             if nums[mid] == target:
        #                 ans.append([nums[p0], nums[mid], nums[p1]])
        #                 break
        #             elif nums[mid] > target:
        #                 r = mid-1
        #             else:
        #                 l = mid+1
        # return ans
        nums.sort()
        ans = []
        for p0 in range(len(nums)-2):
            if p0 > 0 and nums[p0] == nums[p0-1]:
                continue
            l, r = p0+1, len(nums)-1
            while l < r:
                s = nums[p0]+nums[l]+nums[r]
                if s < 0:
                    l += 1
                elif s > 0:
                    r -= 1
                else:
                    ans.append([nums[p0], nums[l], nums[r]])
                    l += 1
                    while l < r and nums[l] == nums[l-1]:
                        l += 1
        return ans


# @lc code=end
if __name__ == "__main__":
    s = Solution()
    print(s.threeSum([-2, 0, 1, 1, 2]))
    print(s.threeSum([-1, 0, 1, 2, -1, -4]))
    print(s.threeSum([0, 1, 1]))
    print(s.threeSum([0, 0, 0]))
    print(s.threeSum([-4, 0, 4]))
