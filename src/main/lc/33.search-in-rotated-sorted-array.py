#
# @lc app=leetcode id=33 lang=python3
#
# [33] Search in Rotated Sorted Array
#
from typing import List
# @lc code=start


class Solution:
    def search(self, nums: List[int], target: int) -> int:
        n = len(nums)
        l, r = 0, n-1
        while l <= r:
            mid = (l+r)//2
            num = nums[mid]
            if num == target:
                return mid
            elif num < target:
                if target >= nums[0] > num:
                    r = mid-1
                else:
                    l = mid+1

            else:
                if target < nums[0] <= num:
                    l = mid+1
                else:
                    r = mid-1

        return l if l < n and nums[l] == target else -1


# @lc code=end
if __name__ == "__main__":
    s = Solution()
    print(s.search([5, 1, 3], 5))
    print(s.search([3, 1], 1))
    print(s.search([3, 5, 1], 3))
    print(s.search([3, 1], 3))
    print(s.search([1, 3], 1))
    print(s.search([3, 1, 2], 0))
    print(s.search([3, 1, 2], 1))
    print(s.search([1, 2, 3], 4))
    print(s.search([4, 5, 6, 7, 0, 1, 2], 0))
    print(s.search([0, 1, 2, 4, 5, 6, 7], 0))
    print(s.search([4, 5, 6, 7, 0, 1, 2], 3))
    print(s.search([1], 0))
