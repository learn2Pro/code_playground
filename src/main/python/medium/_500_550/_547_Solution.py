# 547. Friend Circles
from typing import List


class _547_Solution:
    class Dsu:
        def __init__(self, size):
            self.size = size
            self.array = [-1] * size

        def find(self, x):
            if self.array[x] < 0: return x
            return self.find(self.array[x])

        def union(self, x, y):
            i0, i1 = self.find(x), self.find(y)
            if i0 == i1: return False
            s0, s1 = abs(self.array[i0]), abs(self.array[i1])
            if s0 > s1:
                self.array[i0] += self.array[i1]
                self.array[i1] = i0
            else:
                self.array[i1] += self.array[i0]
                self.array[i0] = i1
            return True

    def findCircleNum(self, M: List[List[int]]) -> int:
        if not M or not M[0]: return 0
        m = len(M)
        dsu = self.Dsu(m)
        for i in range(m):
            for j in range(m):
                if M[i][j] == 1: dsu.union(i, j)
        circle = 0
        for i in dsu.array:
            if i < 0: circle += 1
        return circle

    def findCircleNum(self, M: List[List[int]]) -> int:
        visited, m = set(), len(M)

        def dfs(start):
            for i in range(m):
                if i not in visited and M[start][i] == 1:
                    visited.add(i)
                    dfs(i)

        circle = 0
        for src in range(m):
            if src not in visited:
                visited.add(src)
                dfs(src)
                circle += 1
        return circle


'''
[[1,1,0],[1,1,0],[0,0,1]]
[[1,1,0],[1,1,1],[0,1,1]]
[[1]]
[[1,0],[0,1]]
[[1,0,0,0,0,0],[0,1,0,0,0,0],[0,0,1,0,0,0],[0,0,0,1,0,0],[0,0,0,0,1,0],[0,0,0,0,0,1]]
[[1,0,0,0,1,0],[0,1,0,0,0,0],[0,0,1,0,0,0],[0,0,0,1,0,1],[0,0,0,0,1,0],[0,0,0,0,0,1]]
'''
if __name__ == '__main__':
    obj = _547_Solution()
    assert obj.findCircleNum([[1, 1, 0],
                              [1, 1, 0],
                              [0, 0, 1]]) == 2
