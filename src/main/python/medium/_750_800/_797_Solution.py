# 797. All Paths From Source to Target
from typing import List


class _797_Solution:
    # dfs
    def allPathsSourceTarget(self, graph: List[List[int]]) -> List[List[int]]:
        visited = set()
        ans, N = [], len(graph)

        def dfs(node, path):
            if node == N - 1:
                ans.append(path.copy())
                return
            visited.add(node)
            for dst in graph[node]:
                if dst in visited: continue
                path.append(dst)
                dfs(dst, path)
                path.pop()

        dfs(0, [0])
        return ans

    # bfs
    def allPathsSourceTarget(self, graph: List[List[int]]) -> List[List[int]]:
        ans, N = [], len(graph)
        queue = [[0]]
        while queue:
            path = queue.pop(0)
            if path[-1] == N - 1:
                ans.append(path)
                continue
            for dst in graph[path[-1]]:
                queue.append(path+[dst])
        return ans


'''
[[1,2],[3],[3],[]]
[[1, 2], [2, 3], [4, 5], [2, 6], [7, 8], [9, 12], [1, 5], [3, 4], [7, 3], [], [], [2, 9]]
'''
if __name__ == '__main__':
    tar = _797_Solution()
    assert tar.allPathsSourceTarget(
        [[1, 2], [2, 3], [4, 5], [2, 6], [7, 8], [9, 12], [1, 5], [3, 4], [7, 3], [], [], [], [2, 9]]) == [
               [0, 1, 2, 4, 7, 3, 6, 5, 12]]
    assert tar.allPathsSourceTarget([[1, 2], [3], [3], []]) == [[0, 1, 3], [0, 2, 3]]
