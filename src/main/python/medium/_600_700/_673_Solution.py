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

    class Solution:
        def findNumberOfLIS(self, nums: List[int]) -> int:
            if len(nums) < 2:
                return len(nums)

            decks, paths = [], []
            for n in nums:
                l, r = 0, len(decks) - 1
                while l <= r:
                    m = (l + r) // 2
                    if decks[m][-1] < n:
                        l = m + 1
                    else:
                        r = m - 1

                deck_idx = l
                if deck_idx > 0:
                    l, r = 0, len(decks[deck_idx - 1]) - 1
                    while l <= r:
                        m = (l + r) // 2
                        if decks[deck_idx - 1][m] >= n:
                            l = m + 1
                        else:
                            r = m - 1
                    n_paths = paths[deck_idx - 1][-1] - paths[deck_idx - 1][l]
                else:
                    n_paths = 1

                if deck_idx == len(decks):
                    decks.append([n])
                    paths.append([0, n_paths])
                else:
                    decks[deck_idx].append(n)
                    paths[deck_idx].append(n_paths + paths[deck_idx][-1])

            return paths[-1][-1]
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
    class SegTree:

        def __init__(self, size):
            self.seg = [(0, 1)] * (size << 2)  # length,count
            self.size = size

        def __merge(self, x, y):
            if x[0] == y[0]:
                if x[0] == 0:
                    return (0, 1)
                return (x[0], x[1] + y[1])
            return max(x, y)

        def update(self, i, value):
            if i < 0 or i >= self.size: return

            def update0(index, lo, hi):
                if lo == hi:
                    self.seg[index] = self.__merge(value, self.seg[index])
                    return
                mid = (lo + hi) >> 1
                if i <= mid:
                    update0(index * 2, lo, mid)
                else:
                    update0(index * 2 + 1, mid + 1, hi)
                self.seg[index] = self.__merge(self.seg[index * 2], self.seg[index * 2 + 1])

            update0(1, 0, self.size - 1)

        def query(self, i, j):
            if i > j: return 0, 1

            def query0(index, lo, hi, l, r):
                if l > r: return 0, 1
                if lo == l and hi == r:
                    return self.seg[index]
                mid = (lo + hi) >> 1
                return self.__merge(query0(index * 2, lo, mid, l, min(r, mid)),
                                    query0(index * 2 + 1, mid + 1, hi, max(l, mid + 1), r))

            return query0(1, 0, self.size - 1, i, j)

    def findNumberOfLIS(self, nums: List[int]) -> int:
        if not nums: return 0
        minimal, maximal = min(nums), max(nums)
        seg = self.SegTree(maximal - minimal + 1)
        for num in nums:
            l, c = seg.query(0, num - minimal - 1)
            seg.update(num - minimal, (l + 1, c))
        return seg.query(0, maximal - minimal)[1]


if __name__ == '__main__':
    instance = _673_Solution()
    assert instance.findNumberOfLIS([2, 2, 2, 2, 2, 3]) == 5
    assert instance.findNumberOfLIS([2, 2, 2, 2, 2]) == 5
    assert instance.findNumberOfLIS([1, 3, 5, 4, 7]) == 2
    assert instance.findNumberOfLIS([7, 2, 8, 1, 3, 4, 10, 6, 9, 5]) == 2
    assert instance.findNumberOfLIS([1, 3, 6, 7, 9, 4, 10, 5, 6]) == 1
