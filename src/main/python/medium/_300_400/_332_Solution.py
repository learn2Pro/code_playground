# 332. Reconstruct Itinerary
import collections
from typing import List

'''
[["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]
[["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
[["JFK","SFO"]]
[["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"],["SFO","CBD"]]
[["JFK","ATL"],["JFK","SFO"],["ATL","SFO"],["SFO","JFK"],["SFO","ATL"],["ATL","CBD"]]
'''


class _332_Solution:
    def findItinerary(self, tickets: List[List[str]]) -> List[str]:
        adj = collections.defaultdict(list)
        for src, dst in sorted(tickets)[::-1]:
            adj[src] .append (dst)
        ans = []

        def dfs(ata: str) -> None:
            while adj[ata]:
                dfs(adj[ata].pop())
            ans.append(ata)

        dfs("JFK")
        return ans[::-1]

    # dfs
    # def findItinerary(self, tickets: List[List[str]]) -> List[str]:
    #     if not tickets or not tickets[0]: return []
    #     adj = {}
    #     for lst in tickets:
    #         if lst[0] in adj:
    #             adj[lst[0]].append(lst[1])
    #         else:
    #             adj[lst[0]] = [lst[1]]
    #     for k, v in adj.items():
    #         v.sort()
    #     ans = []
    #
    #     def dfs(previous: List[str], size: int) -> None:
    #         nonlocal ans
    #         if len(ans) == 1: return
    #         if size == 0:
    #             ans.append(previous.copy())
    #             return
    #         src = previous[-1]
    #         if src not in adj: return
    #         for dst in adj[src]:
    #             previous.append(dst)
    #             adj[src].remove(dst)
    #             dfs(previous, size - 1)
    #             adj[src].append(dst)
    #             adj[src].sort()
    #             previous.pop()
    #
    #     dfs(["JFK"], len(tickets))
    #     return ans[0]


if __name__ == '__main__':
    instance = _332_Solution()
    assert instance.findItinerary([["JFK", "SFO"], ["JFK", "ATL"], ["SFO", "ATL"], ["ATL", "JFK"], ["ATL", "SFO"]]) == [
        "JFK", "ATL", "JFK", "SFO", "ATL", "SFO"]
    assert instance.findItinerary([["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]) == ["JFK", "MUC",
                                                                                                        "LHR", "SFO",
                                                                                                        "SJC"]
