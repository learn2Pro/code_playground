import bisect
from typing import List


class PatienceSort:
    def sort(self, nums: List[int]):
        ans = []
        for num in nums:
            idx = bisect.bisect_left(ans, num)
            if idx >= len(ans):
                ans.append(num)
            else:
                ans[idx] = num
            yield idx, num

    def lst(self, nums: List[int]) -> List[int]:
        piles = [[]]
        for idx, num in self.sort(nums):
            if idx + 1 >= len(piles):
                piles.append([])
            piles[idx + 1].append((num, len(piles[idx]) - 1))
        prev, n = 0, len(piles)
        ans = []
        for pile in range(len(piles) - 1, 0, -1):
            x, prev = piles[pile][prev]
            ans.append(x)
        ans.reverse()
        return ans


if __name__ == '__main__':
    instance = PatienceSort()
    assert instance.lst([7, 2, 8, 1, 3, 4, 10, 6, 9, 5]) == [1, 3, 6, 7, 9, 10]
    assert instance.lst([1, 3, 6, 7, 9, 4, 10, 5, 6]) == [1, 3, 6, 7, 9, 10]
