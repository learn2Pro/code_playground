# 275. H-Index II
'''
[3, 0, 6, 1, 5]
[6, 6, 6, 6]
[0, 0, 0]
[0]
[1]
[2]
[1, 2]
[]
[0, 1, 1]
'''
from typing import List


class _275_Solution:
    def hIndex(self, citations: List[int]) -> int:
        if not citations: return 0
        n = len(citations)
        if n == 1 and citations[0] >= 1: return 1
        lo, hi = 0, n - 1

        while lo <= hi:
            mid = (lo + hi) >> 1
            if citations[mid] < n - mid:
                lo = mid + 1
            else:
                hi = mid-1
        return n - hi
        # def hIndex(self, citations: List[int]) -> int:
        #     if not citations: return 0
        #     n = len(citations)
        #     if n == 1 and citations[0] >= 1: return 1
        #     lo, hi = 0, n - 1
        #
        #     while lo <= hi:
        #         mid = (lo + hi) >> 1
        #         if citations[mid] >= n - mid:
        #             hi = mid - 1
        #         else:
        #             lo = mid + 1
        #     return n - lo
    # def hIndex(self, citations: List[int]) -> int:
    #     if not citations: return 0
    #     n = len(citations)
    #     if n == 1 and citations[0] >= 1: return 1
    #     lo, hi = 0, n - 1
    #
    #     while lo < hi:
    #         mid = (lo + hi) >> 1
    #         if n - mid > citations[mid] and n - mid - 1 <= citations[mid + 1]:
    #             return n - mid - 1
    #         elif n - mid <= citations[mid]:
    #             hi = mid
    #         else:
    #             lo = mid + 1
    #     return 0 if hi == n - 1 else n - hi


if __name__ == '__main__':
    instance = _275_Solution()
    assert instance.hIndex([0, 0, 0]) == 0
    assert instance.hIndex([0, 1, 3, 5, 6]) == 3
    assert instance.hIndex([0, 1, 3, 5]) == 2
    assert instance.hIndex([0, 1, 1, 5, 6]) == 2
    assert instance.hIndex([6, 6, 6, 6]) == 4
    assert instance.hIndex([1, 2]) == 1
    assert instance.hIndex([]) == 0
    assert instance.hIndex([0, 1, 1]) == 1
    assert instance.hIndex([1]) == 1
