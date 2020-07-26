# 659. Split Array into Consecutive Subsequences
import collections
from typing import List


class _659_Solution:
    def isPossible(self, nums: List[int]) -> bool:
        ans = []
        for num in nums:
            settled = False
            for i in reversed(range(len(ans))):
                lst = ans[i]
                if num == lst[0] + 1:
                    lst[0] += 1
                    lst[1] += 1
                    settled = True
                    break
            if not settled:
                ans.append([num, 1])
        return all(map(lambda lst: lst[1] >= 3, ans))

    def isPossible(self, nums):
        counter = collections.Counter(nums)
        tails = collections.Counter()
        for num in nums:
            if counter[num] == 0:
                continue
            elif tails[num] > 0:
                tails[num] -= 1
                tails[num] += 1
            elif counter[num + 1] > 0 and counter[num + 2] > 0:
                tails[num + 2] += 1
                counter[num + 1] -= 1
                counter[num + 2] -= 1
            else:
                return False
            counter[num] -= 1
        return True


if __name__ == '__main__':
    obj = _659_Solution()
    assert obj.isPossible([1, 2, 3, 3, 4, 5])
    assert not obj.isPossible([1, 2, 3, 3, 4, 4, 5, 5])
