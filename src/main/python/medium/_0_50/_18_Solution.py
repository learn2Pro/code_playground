# 18. 4Sum
from typing import List


class _18_Solution:
    def fourSum(self, nums: List[int], target: int) -> List[List[int]]:
        nums.sort()
        N = len(nums)
        ans = []
        for lo in range(N - 3):
            if lo > 0 and nums[lo] == nums[lo - 1]: continue
            for i in range(lo + 1, N - 2):
                if i > lo + 1 and nums[i] == nums[i - 1]: continue
                l, r = i + 1, N - 1
                while l < r:
                    acc = nums[lo] + nums[i] + nums[l] + nums[r]
                    if acc > target:
                        r -= 1
                    elif acc < target:
                        l += 1
                    else:
                        ans.append([nums[lo], nums[i], nums[l], nums[r]])
                        while l < r and nums[l + 1] == nums[l]: l += 1
                        while l < r and nums[r - 1] == nums[r]: r -= 1
                        l += 1
                        r -= 1

        return ans


if __name__ == '__main__':
    instance = _18_Solution
    assert instance.fourSum(instance, [0, 0, 0, 0], 0) == [[0, 0, 0, 0]]
    assert instance.fourSum(instance, [1], 1) == []
    assert instance.fourSum(instance, [1, 0, -1], 1) == []
    assert instance.fourSum(instance, [1, 0, -1, 0], 10) == []
    assert instance.fourSum(instance, [1, 0, -1, 0], 0) == [[-1, 0, 0, 1]]
    assert instance.fourSum(instance, [1, 0, -1, 0, -2, 2], 0) == [[-2, -1, 1, 2], [-2, 0, 0, 2], [-1, 0, 0, 1]]
