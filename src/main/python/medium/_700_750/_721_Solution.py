# 721. Accounts Merge
from typing import List


class _721_Solution:
    class Dsu:
        def __init__(self, size):
            self.array = [-1] * size

        def find(self, search):
            if self.array[search] < 0: return search
            return self.find(self.array[search])

        def union(self, src, dst):
            ancestor0, ancestor1 = self.find(src), self.find(dst)
            if ancestor0 == ancestor1: return True
            s0, s1 = abs(self.array[ancestor0]), abs(self.array[ancestor1])
            if s0 >= s1:
                self.array[ancestor0] += self.array[ancestor1]
                self.array[ancestor1] = ancestor0
            else:
                self.array[ancestor1] += self.array[ancestor0]
                self.array[ancestor0] = ancestor1

    def accountsMerge(self, accounts: List[List[str]]) -> List[List[str]]:
        if not accounts: return accounts
        lookup, edges = {}, []
        for i, account in enumerate(accounts):
            for j in range(1, len(account)):
                if account[j] in lookup:
                    edges.append([lookup[account[j]], i])
                else:
                    lookup[account[j]] = i
        dsu, ans = self.Dsu(len(accounts)), []
        for edge in edges:
            dsu.union(edge[0], edge[1])
        for i in range(len(accounts)):
            parent = dsu.find(i)
            if parent == i: continue
            accounts[parent] += accounts[i][1:]
        for i in range(len(accounts)):
            parent = dsu.find(i)
            if parent == i:
                emails = list(set(accounts[i][1:]))
                emails.sort()
                ans.append([accounts[i][0]] + emails)
        return ans


if __name__ == '__main__':
    obj = _721_Solution()
    assert obj.accountsMerge(
        [["John", "johnsmith@mail.com", "john_newyork@mail.com"], ["John", "johnsmith@mail.com", "john00@mail.com"],
         ["Mary", "mary@mail.com"], ["John", "johnnybravo@mail.com"]]) == [
               ["John", "john00@mail.com", "john_newyork@mail.com", "johnsmith@mail.com"], ["Mary", "mary@mail.com"],
               ["John", "johnnybravo@mail.com"]]
