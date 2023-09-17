#
# @lc app=leetcode id=169 lang=python3
#
# [169] Majority Element
#
from typing import List
# @lc code=start


class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        # from collections import Counter
        # return Counter(nums).most_common(1)[0][0]
        # nums.sort()
        # return nums[len(nums)//2]
        candidate = 0
        count = 0
        for num in nums:
            if count == 0:
                candidate = num
            if candidate == num:
                count += 1
            else:
                count -= 1
        return candidate


# @lc code=end
if __name__ == "__main__":
    s = Solution()
    assert s.majorityElement([3, 2, 3]) == 3
