# 785. Is Graph Bipartite?
from typing import List


class _785_Solution:
    def isBipartite(self, graph: List[List[int]]) -> bool:
        color = [0] * len(graph)
        color[0] = 1
        for src, lst in enumerate(graph):
            for dst in lst:
                if color[dst] == 0:
                    color[dst] = -color[src]
                elif color[src] * color[dst] > 0:
                    return False
        return True

    # use dfs
    def isBipartite(self, graph: List[List[int]]) -> bool:
        N = len(graph)
        color = [0] * len(graph)
        for src in range(N):
            if color[src] != 0: continue
            stack, color[src] = [src], 1
            while stack:
                src = stack.pop()
                for dst in graph[src]:
                    if color[dst] * color[src] > 0: return False
                    if color[dst] == 0:
                        color[dst] = - color[src]
                        stack.append(dst)
        return True

    # use union find
    def isBipartite(self, graph: List[List[int]]) -> bool:
        class Dsu:
            def __init__(self, size):
                self.array = [-1] * size

            def find(self, index):
                if self.array[index] < 0:
                    return index
                return self.find(self.array[index])

            def union(self, src, dst):
                i0, i1 = self.find(src), self.find(dst)
                if i0 == i1: return False
                self.array[i0] = i1
                return True

        N = len(graph)
        dsu = Dsu(N)
        for src, lst in enumerate(graph):
            for dst in lst:
                if dsu.find(src) == dsu.find(dst): return False
                dsu.union(lst[0], dst)

        return True


if __name__ == '__main__':
    tar = _785_Solution()
    assert tar.isBipartite([[1, 3], [0, 2], [1, 3], [0, 2]])
    assert not tar.isBipartite([[1, 2, 3], [0, 2], [0, 1, 3], [0, 2]])
    assert tar.isBipartite([[2], [], [0]])
