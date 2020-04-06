# 416. Partition Equal Subset Sum
from typing import List


class _416_Solution:
    # use dp
    def canPartition(self, nums: List[int]) -> bool:
        acc = sum(nums)
        if acc % 2 != 0: return False
        dp = [False] * (acc + 1)
        dp[0] = True
        for num in nums:
            for i in reversed(range(1, acc + 1)):
                if i < num: continue
                dp[i] = dp[i] or dp[i - num]
        return dp[acc // 2]

    # use bitset
    def canPartition(self, nums: List[int]) -> bool:
        acc, bits = 0, 1
        for num in nums:
            acc += num
            bits |= bits << num
        return acc % 2 == 0 and (bits >> (acc // 2)) & 1 == 1

    # use dfs
    def canPartition(self, nums: List[int]) -> bool:
        acc = sum(nums)
        if acc % 2 != 0: return False
        if max(nums) > acc // 2: return False

        def dfs(index: int, current: int) -> bool:
            if index < 0 or current >= acc // 2:
                return current == acc // 2
            return dfs(index - 1, current + nums[index]) or dfs(index - 1, current)

        return dfs(len(nums) - 1, 0)


if __name__ == '__main__':
    obj = _416_Solution()
    assert not obj.canPartition([1, 2, 5])
    assert obj.canPartition([1, 1])
