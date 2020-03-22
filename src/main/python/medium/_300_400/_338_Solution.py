# 338. Counting Bits
from typing import List


class _338_Solution:
    def countBits(self, num: int) -> List[int]:
        dp = [0] * (num + 1)
        for i in range(1, num + 1):
            dp[i] = dp[i >> 1] + (i & 1)
        return dp

    # def countBits(self, num: int) -> List[int]:
    #     if num == 0: return [0]
    #     if num == 1: return [0, 1]
    #     step = 1
    #     ans = [0, 1]
    #     while step < num:
    #         n = len(ans)
    #         ans += ans[n - step:n]
    #         ans += [i + 1 for i in ans[n - step:n]]
    #         step <<= 1
    #     while len(ans) > num + 1: ans.pop()
    #     return ans

    # def countBits(self, num: int) -> List[int]:
    #     def bitCount(i: int) -> int:
    #         i = i - ((i >> 1) & 0x55555555)
    #         i = (i & 0x33333333) + ((i >> 2) & 0x33333333)
    #         i = (i + (i >> 4)) & 0x0f0f0f0f
    #         i = i + (i >> 8)
    #         i = i + (i >> 16)
    #         return i & 0x3f
    #
    #     ans = []
    #     for i in range(num + 1):
    #         ans.append(bitCount(i))
    #     return ans


if __name__ == '__main__':
    instance = _338_Solution()
    assert instance.countBits(4) == [0, 1, 1, 2, 1]
    assert instance.countBits(5) == [0, 1, 1, 2, 1, 2]
