# 274. H-Index
from typing import List

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


class _274_Solution:
    def hIndex(self, citations: List[int]) -> int:
        n = len(citations)
        counter = [0] * (n + 1)
        for citation in citations:
            if citation > n:
                counter[n] += 1
            else:
                counter[citation] += 1
        accumulate = 0
        for i in range(n, -1, -1):
            accumulate += counter[i]
            if accumulate >= i: return i
        return 0
    # def hIndex(self, citations: List[int]) -> int:
    #     if not citations: return 0
    #     citations.sort()
    #     count = 1
    #     for i in range(len(citations) - 1, -1, -1):
    #         if count > citations[i]:
    #             return count - 1
    #         count += 1
    #     return count - 1


if __name__ == '__main__':
    instance = _274_Solution()
    assert instance.hIndex([3, 0, 6, 1, 5]) == 3
    assert instance.hIndex([6, 6, 6, 6]) == 4
    assert instance.hIndex([0, 0, 0]) == 0
    assert instance.hIndex([1]) == 1
    assert instance.hIndex([1, 2]) == 1
    assert instance.hIndex([]) == 0
    assert instance.hIndex([0, 1, 1]) == 1
