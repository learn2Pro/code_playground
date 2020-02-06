# 16 3Sum Closest

from typing import List

class _16_Solution:
    def threeSumClosest(self, nums: List[int], target: int) -> int:
        N = len(nums)
        nums.sort()
        ans, min = (0, 0x7fffffff)
        for i in range(N):
            if i > 0 and nums[i - 1] == nums[i]: continue
            l, r = (i + 1, N - 1)
            while l < r:
                sum = nums[l] + nums[i] + nums[r]
                if (abs(sum - target) < min):
                    min = abs(sum - target)
                    ans = sum
                if sum > target:
                    r -= 1
                elif sum < target:
                    l += 1
                else:
                    while l < r and nums[l] == nums[l + 1]: l += 1
                    while l < r and nums[r] == nums[r - 1]: r -= 1
                    l += 1
                    r -= 1
        return ans


if __name__ == '__main__':
    instance = _16_Solution
    assert instance.threeSumClosest(instance, [1, 1, -1, -1, 3], -1) == -1
    assert instance.threeSumClosest(instance, [-1, 2, 1, -4], 1) == 2
