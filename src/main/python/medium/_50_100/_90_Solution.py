# 90. Subsets II
from typing import List

'''
[1,2,2]
[2]
[2,2]
[]
[1,2]
[1,2,2,3]
[3,3,3]
[1,2,3]
'''
class _90_Solution:
    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        ans = []
        n = len(nums)

        def track(previous: List[int], index: int) -> None:
            ans.append(previous.copy())
            if index >= n:
                return
            for i in range(index, n):
                if i > index and nums[i] == nums[i - 1]: continue
                previous.append(nums[i])
                track(previous, i + 1)
                previous.pop()

        track([], 0)
        return ans


if __name__ == '__main__':
    instance = _90_Solution
    assert instance.subsetsWithDup(instance, [1, 2, 2]) == []
