# 491. Increasing Subsequences
from typing import List


class _491_Solution:
    def findSubsequences(self, nums: List[int]) -> List[List[int]]:
        ans = set()
        if not nums: return list(ans)
        size = len(nums)

        def backtrack(index: int, previous: List[int]) -> None:
            if index >= size:
                if len(previous) >= 2:
                    ans.add(tuple(previous.copy()))
                return
            if not previous or nums[index] >= previous[-1]:
                previous.append(nums[index])
                backtrack(index + 1, previous)
                previous.pop()
            backtrack(index + 1, previous)

        backtrack(0, [])
        return list(map(list, ans))

    def findSubsequences(self, nums: List[int]) -> List[List[int]]:
        subs = {()}
        for num in nums:
            subs |= {sub + (num,)
                     for sub in subs
                     if not sub or sub[-1] <= num}
        return [list(sub) for sub in subs if len(sub) >= 2]


if __name__ == '__main__':
    target = _491_Solution()
    assert target.findSubsequences([4, 6, 7, 7]) == [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7, 7],
                                                     [4, 7, 7]]
