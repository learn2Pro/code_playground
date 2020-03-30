# 399. Evaluate Division
from collections import deque
from typing import List


class _399_Solution:
    def calcEquation(self, equations: List[List[str]], values: List[float], queries: List[List[str]]) -> List[float]:
        self.edges = {}
        for lst, div in zip(equations, values):
            dst0 = self.edges.get(lst[0], [])
            dst0.append((lst[1], div))
            self.edges[lst[0]] = dst0
            dst1 = self.edges.get(lst[1], [])
            dst1.append((lst[0], 1 / div))
            self.edges[lst[1]] = dst1

        def calcEq(query: List[str]) -> float:
            if query[0] not in self.edges: return -1.0
            queue, visited = deque([(query[0], 1.0)]), set()
            while queue:
                node, v = queue.popleft()
                visited.add(node)
                if node == query[1]:
                    return v
                for dst, div in self.edges.get(node, []):
                    if dst in visited: continue
                    queue.append((dst, div * v))
            return -1.0

        ans = []
        for query in queries:
            div = calcEq(query)
            ans.append(div)
            if div != -1.0:
                self.edges[query[0]].append((query[1], div))
                self.edges[query[1]].append((query[0], 1 / div))
        return ans


if __name__ == '__main__':
    obj = _399_Solution()
    assert obj.calcEquation([["a", "b"], ["b", "c"]], [2.0, 3.0],
                            [["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"]]) == []
