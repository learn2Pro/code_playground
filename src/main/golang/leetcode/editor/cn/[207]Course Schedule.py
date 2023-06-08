from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        # topo sort
        # 1. build graph
        graph = [[] for _ in range(numCourses)]
        in_degree = [0] * numCourses
        for u, v in prerequisites:
            graph[v].append(u)
            in_degree[u] += 1
        # 2. bfs
        queue = [i for i in range(numCourses) if in_degree[i] == 0]
        while queue:
            u = queue.pop(0)
            for v in graph[u]:
                in_degree[v] -= 1
                if in_degree[v] == 0:
                    queue.append(v)
        return sum(in_degree) == 0
# leetcode submit region end(Prohibit modification and deletion)
