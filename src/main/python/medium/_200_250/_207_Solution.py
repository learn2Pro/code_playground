# 207. Course Schedule
from typing import List


class _207_Solution:
    # topologic sort
    # dfs
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        adjacent = [[] for _ in range(numCourses)]
        visited = [0] * numCourses
        for lst in prerequisites:
            adjacent[lst[0]].append(lst[1])

        def dfs(i: int) -> bool:
            if visited[i] == -1: return False
            if visited[i] == 1: return True
            visited[i] = -1
            for dst in adjacent[i]:
                if not dfs(dst):
                    return False
            visited[i] = 1
            return True

        for src in range(numCourses):
            if not dfs(src):
                return False
        return True
    # bfs
    # def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
    #     if not prerequisites or not prerequisites[0]: return True
    #     roots = [0] * numCourses
    #     adjacent = [[0] * numCourses for i in range(numCourses)]
    #     for lst in prerequisites:
    #         adjacent[lst[0]][lst[1]] = 1
    #         roots[lst[1]] += 1
    #     queue = []
    #     for i, v in enumerate(roots):
    #         if v >= 1: continue
    #         queue.append(i)
    #     count = 0
    #     while queue:
    #         current = queue.pop(0)
    #         count += 1
    #         for i in range(numCourses):
    #             if adjacent[current][i] == 0: continue
    #             roots[i] -= 1
    #             if roots[i] == 0: queue.append(i)
    #     return count == numCourses


if __name__ == '__main__':
    instance = _207_Solution
    assert instance.canFinish(instance, 2, [[1, 0]])
    assert not instance.canFinish(instance, 2, [[1, 0], [0, 1]])
