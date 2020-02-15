# 77. Combinations
import itertools
from typing import List

'''
4
4
4
2
4
5
2
2
1
1
'''


class _77_Solution:
    # def combine(self, n: int, k: int) -> List[List[int]]:
    #     iterable = [i + 1 for i in range(n)]
    #     pool = tuple(iterable)
    #     n = len(pool)
    #     if k > n:
    #         return
    #     indices = list(range(k))
    #     yield tuple(pool[i] for i in indices)
    #     while True:
    #         for i in reversed(range(k)):
    #             if indices[i] != i + n - k:
    #                 break
    #         else:
    #             return
    #         indices[i] += 1
    #         for j in range(i + 1, k):
    #             indices[j] = indices[j - 1] + 1
    #         yield tuple(pool[i] for i in indices)
    def combine(self, n: int, k: int) -> List[List[int]]:
        if k > n: return []
        ans = []
        curr = [0] * k
        i = 0
        while i >= 0:
            curr[i] += 1
            if curr[i] > n:
                i -= 1
            elif i == k - 1:
                yield curr
            else:
                i += 1
                curr[i] = curr[i - 1]


# def combine(self, n: int, k: int) -> List[List[int]]:
#     comb_range = range(1, n + 1)
#     all_combos = itertools.combinations(comb_range, k)
#     return list(all_combos)

# def combine(self, n: int, k: int) -> List[List[int]]:
#     if k > n: return []
#     size = min(n, k)
#     ans = []
#     visited = set()
#
#     def track(previous: List[int], start: int) -> None:
#         if len(previous) == size:
#             ans.append(previous.copy())
#             return
#         for i in range(start, n):
#             if i in visited: continue
#             previous.append(i + 1)
#             visited.add(i)
#             track(previous, i + 1)
#             previous.pop()
#             visited.remove(i)
#
#     track([], 0)
#     return ans


if __name__ == '__main__':
    instance = _77_Solution
    instance.combine(instance, 4, 2) == [[2, 4], [3, 4], [2, 3], [1, 2], [1, 3], [1, 4]]
