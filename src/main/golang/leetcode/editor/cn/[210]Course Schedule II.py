from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        graph = [[] for _ in range(numCourses)]  # graph[i] is a list of courses that i is a prerequisite of
        in_degree = [0] * numCourses  # in_degree[i] is the number of prerequisites of course i
        for k, v in prerequisites:
            graph[v].append(k)
            in_degree[k] += 1
        # bfs
        queue = [i for i in range(numCourses) if in_degree[i] == 0]
        ans = []
        while queue:
            curr = queue.pop(0)
            ans.append(curr)
            for nxt in graph[curr]:
                in_degree[nxt] -= 1
                if in_degree[nxt] == 0:
                    queue.append(nxt)
        return ans if len(ans) == numCourses else []
# leetcode submit region end(Prohibit modification and deletion)
