# 673. Number of Longest Increasing Subsequence
from typing import List

'''
[10,9,2,5,3,7,101,18]
[1,1,1]
[4,10,4,3,8,9]
[3]
[2,3]
[1, 3, 6, 7, 9, 4, 10, 5, 6]
[7, 2, 8, 1, 3, 4, 10, 6, 9, 5]
'''


class _673_Solution:
    # dp
    def findNumberOfLIS(self, nums: List[int]) -> int:
        if not nums: return 0
        dp, cnt = [1] * len(nums), [1] * len(nums)
        n, maximal, count = len(nums), 1, 0
        for i in range(n):
            for j in range(i):
                if nums[i] <= nums[j]: continue
                if dp[i] == dp[j] + 1:
                    cnt[i] += cnt[j]
                elif dp[j] + 1 > dp[i]:
                    dp[i] = dp[j] + 1
                    cnt[i] = cnt[j]
                maximal = max(maximal, dp[i])
        for index, val in enumerate(dp):
            if val == maximal:
                count += cnt[index]
        return count

    # patience sort
    # def findNumberOfLIS(self, nums: List[int]) -> int:
    #
    #     def sort(inner: List[int]):
    #         ans = []
    #         for num in nums:
    #             idx = bisect.bisect_left(ans, num)
    #             if idx >= len(ans):
    #                 ans.append(num)
    #             else:
    #                 ans[idx] = num
    #             yield idx, num
    #
    #     def findNumber(inner: List[int]):
    #         piles = [[]]
    #         for idx, num in sort(inner):
    #             if idx + 1 >= len(piles):
    #                 piles.append([])
    #             indexArr = []
    #             if not piles[idx]:
    #                 indexArr.append(-1)
    #             else:
    #                 for i, (left, _) in enumerate(piles[idx]):
    #                     if left >= num: continue
    #                     indexArr.append(i)
    #             piles[idx + 1].append((num, indexArr))
    #         queue = []
    #         for i in range(len(piles[-1])):
    #             queue.append((len(piles), i))
    #         count = 0
    #         while queue:
    #             index, next = queue.pop(0)
    #             if next == -1:
    #                 count += 1
    #                 continue
    #             else:
    #                 for i in piles[index - 1][next][1]:
    #                     queue.append((index - 1, i))
    #         return count
    #
    #     if not nums: return 0
    #     return findNumber(nums)


if __name__ == '__main__':
    instance = _673_Solution()
    assert instance.findNumberOfLIS([1, 3, 6, 7, 9, 4, 10, 5, 6]) == 1
    assert instance.findNumberOfLIS([7, 2, 8, 1, 3, 4, 10, 6, 9, 5]) == 2
