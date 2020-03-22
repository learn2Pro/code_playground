# 368. Largest Divisible Subset
from typing import List


class _368_Solution:
    # use built-in
    def largestDivisibleSubset(self, nums: List[int]) -> List[int]:
        S = {-1: set()}
        for num in sorted(nums):
            maximal = max((S[d] for d in S if num % d == 0), key=len) | {num}
            S[num] = maximal
        return sorted(list(max(S.values(), key=len)))
    # use pre index
    # def largestDivisibleSubset(self, nums: List[int]) -> List[int]:
    #     nums.sort()
    #     n = len(nums)
    #     dp, pre, index, maximal = [0] * n, [-1] * n, -1, 0
    #     for i in range(n):
    #         dp[i] = 1
    #         pre[i] = -1
    #         for j in range(i - 1, -1, -1):
    #             if nums[i] % nums[j] == 0 and dp[j] + 1 > dp[i]:
    #                 dp[i] = dp[j] + 1
    #                 pre[i] = j
    #         if dp[i] > maximal:
    #             index = i
    #             maximal = dp[i]
    #     ans = []
    #     while index != -1:
    #         ans.append(nums[index])
    #         index = pre[index]
    #     return ans[::-1]
    # def largestDivisibleSubset(self, nums: List[int]) -> List[int]:
    #     nums.sort()
    #     n = len(nums)
    #     dp, lookup, ans, maximal = [0] * n, [[] for _ in range(n)], [], 0
    #     for i in range(n):
    #         dp[i] = 1
    #         lookup[i] = [nums[i]]
    #         for j in range(i - 1, -1, -1):
    #             if nums[i] % nums[j] == 0 and dp[j] + 1 > dp[i]:
    #                 dp[i] = dp[j] + 1
    #                 lookup[i] = lookup[j] + [nums[i]]
    #         if dp[i] > maximal:
    #             ans = lookup[i]
    #             maximal = dp[i]
    #     return ans


'''
[1,2,3]
[2,1]
[3,2,1]
[1,2,3,4,5,6,7,8]
[10,9,8,20,1,3,7]
[]
[1, 2, 4, 8, 7, 4]
'''
if __name__ == '__main__':
    obj = _368_Solution()
    assert obj.largestDivisibleSubset([4, 8, 10, 240]) == [4, 8, 240]
    assert obj.largestDivisibleSubset([]) == []
    assert obj.largestDivisibleSubset([1, 1, 1, 1, 1]) == [1, 1, 1, 1, 1]
    assert obj.largestDivisibleSubset([1, 2, 3]) == [1, 2]
    assert obj.largestDivisibleSubset([1, 2, 4, 8]) == [1, 2, 4, 8]
    assert obj.largestDivisibleSubset([1, 2, 4, 8, 7, 4]) == [1, 2, 4, 4, 8]
