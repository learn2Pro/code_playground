'''
["MapSum", "insert", "sum", "insert", "sum"]
[[], ["apple",3], ["ap"], ["app",2], ["ap"]]
["MapSum", "insert","insert","insert","sum","sum","sum", "sum", "insert", "sum"]
[[], ["apple",3],["a",2],["ba",10],["bx"],["a"],["x"], ["ap"], ["app",2], ["ap"]]
'''
# 677. Map Sum Pairs
class MapSum:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.lookup = {}

    def insert(self, key: str, val: int) -> None:
        current = self.lookup
        for c in key:
            if c not in current: current[c] = {}
            current = current[c]
        current['_'] = val

    def sum(self, prefix: str) -> int:
        def dfs(lookup):
            nonlocal ans
            if not lookup:
                return
            if '_' in lookup: ans += lookup['_']
            for k, v in lookup.items():
                if k == '_': continue
                dfs(v)

        ans = 0
        current = self.lookup
        for p in prefix:
            if p not in current: return 0
            current = current[p]
        dfs(current)
        return ans
