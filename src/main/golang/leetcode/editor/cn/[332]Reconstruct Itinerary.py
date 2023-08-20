from typing import List
# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def findItinerary(self, tickets: List[List[str]]) -> List[str]:
        # topo sort
        from collections import defaultdict
        graph = defaultdict(list)
        for u, v in tickets:
            graph[u].append(v)
        for u in graph:
            graph[u].sort(reverse=True)
        res = []
        def dfs(u):
            while graph[u]:
                v = graph[u].pop()
                dfs(v)
            res.append(u)
        dfs('JFK')
        return res[::-1]
# leetcode submit region end(Prohibit modification and deletion)
