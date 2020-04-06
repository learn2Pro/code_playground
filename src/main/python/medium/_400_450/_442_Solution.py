# 442. Find All Duplicates in an Array
from collections import Counter
from typing import List


class _442_Solution:
    def findDuplicates(self, nums: List[int]) -> List[int]:
        if not nums: return []
        ans = []
        for num in nums:
            if nums[abs(num) - 1] < 0:
                ans.append(abs(num))
            else:
                nums[abs(num) - 1] *= -1
        return ans

    # use counter
    def findDuplicates(self, nums: List[int]) -> List[int]:
        return [k for k, v in Counter(nums).most_common() if v > 1]
