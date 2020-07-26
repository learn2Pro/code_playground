# 684. Redundant Connection
from typing import List

'''
[[1,2],[1,3],[2,3]]
[[1,2], [2,3], [3,4], [1,4], [1,5]]
[[1,2],[1,3],[2,3]]
[[1,5],[2,5],[1,3],[2,3],[4,5]]
'''


class _684_Solution:
    class Dsu:
        def __init__(self, size):
            self.array = [-1] * size

        def find(self, id):
            if self.array[id] < 0:
                return id
            return self.find(self.array[id])

        def union(self, src, dst):
            ancestor0, ancestor1 = self.find(src), self.find(dst)
            if ancestor0 == ancestor1: return False
            s0, s1 = abs(self.array[ancestor0]), abs(self.array[ancestor1])
            if s0 >= s1:
                self.array[ancestor0] += self.array[ancestor1]
                self.array[ancestor1] = ancestor0
            else:
                self.array[ancestor1] += self.array[ancestor0]
                self.array[ancestor0] = ancestor1
            return True

    def findRedundantConnection(self, edges: List[List[int]]) -> List[int]:
        if not edges or not edges[0]: return []
        dsu, ans = self.Dsu(len(edges) + 1), None
        for lst in edges:
            if not dsu.union(lst[0], lst[1]): return lst
