# 210. Course Schedule II
from typing import List

'''
2
[[1,0]]
3
[[1,0],[2,1],[2,0]]
'''


class _210_Solution:
    # # dfs
    # def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
    #     visited = [0] * numCourses
    #     ans = []
    #
    #     grid = [[] for _ in range(numCourses)]
    #
    #     for lst in prerequisites:
    #         grid[lst[1]].append(lst[0])
    #
    #     def dfs(i: int) -> bool:
    #         if visited[i] == -1:
    #             return False
    #         if visited[i] == 1:
    #             return True
    #         visited[i] = -1
    #         for dst in grid[i]:
    #             if not dfs(dst): return False
    #         visited[i] = 1
    #         ans.append(i)
    #         return True
    #
    #     for src in range(numCourses):
    #         if not dfs(src):
    #             return []
    #     return ans[::-1]

    # bfs [topological sort]
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        grid = [[] for _ in range(numCourses)]
        inDegree = [0] * numCourses
        for lst in prerequisites:
            grid[lst[1]].append(lst[0])
            inDegree[lst[0]] += 1
        queue = []
        ans = []
        for i in range(numCourses):
            if inDegree[i] > 0: continue
            queue.append(i)
        while queue:
            src = queue.pop(0)
            ans.append(src)
            for dst in grid[src]:
                inDegree[dst] -= 1
                if inDegree[dst] == 0:
                    queue.append(dst)
        return [] if len(ans) != numCourses else ans


if __name__ == '__main__':
    instance = _210_Solution
    assert instance.findOrder(instance, 3, [[1, 0], [2, 1], [2, 0]]) == [0, 1, 2]
    assert instance.findOrder(instance, 2, [[1, 0]]) == [0, 1]
