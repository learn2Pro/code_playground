# 310. Minimum Height Trees
from typing import List


class _310_Solution:
    def findMinHeightTrees(self, n: int, edges: List[List[int]]) -> List[int]:
        if n == 0: return []
        if n == 1: return [0]
        adj = [set() for _ in range(n)]
        for edge in edges:
            adj[edge[0]].add(edge[1])
            adj[edge[1]].add(edge[0])
        queue = [i for i in range(n) if len(adj[i]) == 1]
        while n > 2:
            size = len(queue)
            n -= size
            for _ in range(size):
                src = queue.pop(0)
                dst = adj[src].pop()
                adj[dst].remove(src)
                if len(adj[dst]) == 1: queue.append(dst)
        return queue


'''
4
[[1, 0], [1, 2], [1, 3]]
6
[[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]
1
[]
2
[[1,0]]
'''
if __name__ == '__main__':
    instance = _310_Solution()
    assert instance.findMinHeightTrees(4, [[1, 0], [1, 2], [1, 3]]) == [1]
    assert instance.findMinHeightTrees(1, []) == [0]
    assert instance.findMinHeightTrees(2, [[1, 0]]) == [0, 1]
    assert instance.findMinHeightTrees(6, [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]) == [3, 4]
