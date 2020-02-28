# 220. Contains Duplicate III
from typing import List

from sortedcontainers import SortedList

'''
[1,2,3,1]
3
0
[1]
2
0
[1,2]
1
0
[1,2]
1
1
[3,2,1]
2
0
[1,1,1]
1
0
[-1,-1]
1
-1
[-1,2147483647]
1
2147483647
'''


class _220_Solution:
    # o(n^2)
    # def containsNearbyAlmostDuplicate(self, nums: List[int], k: int, t: int) -> bool:
    #     if t == 0 and len(set(nums)) == len(nums): return False
    #     for i, num in enumerate(nums):
    #         for j in range(i + 1, min(len(nums), i + k + 1)):
    #             if abs(nums[i] - nums[j]) <= t: return True
    #     return False
    # o(n)
    def containsNearbyAlmostDuplicate(self, nums: List[int], k: int, t: int) -> bool:
        if not nums: return False
        if t == 0 and len(nums) == len(set(nums)):
            # Quick response for special case on t = 0
            # t = 0 requires at last one pair of duplicate elements
            return False
        n = len(nums)
        i, j = -k, min(n - 1, k)
        sorted = SortedList()
        # init
        for p in range(i, j + 1):
            if p < 0: continue
            sorted.add(nums[p])

        for step in range(n):
            gap = 0xffffffff
            l, r, idx = sorted.bisect_left(nums[step]), sorted.bisect_right(nums[step]), sorted.index(nums[step])
            if r - l >= 2 and t >= 0: return True
            if l - 1 >= 0:
                gap = min(nums[step] - sorted[l - 1], gap)
            if r < len(sorted):
                gap = min(gap, sorted[r] - nums[step])
            if gap <= t: return True
            # move on
            if i >= 0:
                sorted.remove(nums[i])
            if j + 1 < n: sorted.add(nums[j + 1])
            i += 1
            j += 1


if __name__ == '__main__':
    instance = _220_Solution
    assert not instance.containsNearbyAlmostDuplicate(instance, [1, 1], 1, -1)
    assert not instance.containsNearbyAlmostDuplicate(instance, [-1, -1], 1, -1)
    assert instance.containsNearbyAlmostDuplicate(instance, [1, 2, 3, 1], 3, 0)
    assert not instance.containsNearbyAlmostDuplicate(instance, [1, 5, 9, 1, 5, 9], 2, 3)
    assert instance.containsNearbyAlmostDuplicate(instance, [1, 0, 1, 1], 1, 2)
