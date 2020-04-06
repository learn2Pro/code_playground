# 427. Construct Quad Tree
from typing import List


class _427_Solution:
    class Node:
        def __init__(self, val, isLeaf, topLeft, topRight, bottomLeft, bottomRight):
            self.val = val
            self.isLeaf = isLeaf
            self.topLeft = topLeft
            self.topRight = topRight
            self.bottomLeft = bottomLeft
            self.bottomRight = bottomRight

    def backtrack(self, grid: List[List[Node]]) -> 'Node':
        if len(grid) == 1: return grid[0][0]
        n = len(grid)
        size = n // 2
        next = [[None] * size for _ in range(size)]
        for i in range(size * size):
            r, c = divmod(i, size)
            row0, row1 = 2 * r, 2 * (r + 1)
            col0, col1 = 2 * c, 2 * (c + 1)
            quad = []
            for x in range(row0, row1):
                for y in range(col0, col1):
                    quad.append(grid[x][y])
            if all(q.val == quad[0].val and q.isLeaf for q in quad):
                next[r][c] = self.Node(quad[0].val, True, None, None, None, None)
            else:
                next[r][c] = self.Node(quad[0].val, False, quad[0], quad[1], quad[2], quad[3])
        return self.backtrack(next)

    def construct(self, grid: List[List[int]]) -> 'Node':
        n = len(grid)
        nodes = [[None] * n for _ in range(n)]
        for i in range(n):
            for j in range(n):
                nodes[i][j] = self.Node(grid[i][j], True, None, None, None, None)
        return self.backtrack(nodes)
