# 756. Pyramid Transition Matrix
import collections
from itertools import product
from typing import List


class _756_Solution:
    # use intuition
    def pyramidTransition(self, bottom: str, allowed: List[str]) -> bool:
        lst = [c for c in bottom]
        dict = collections.defaultdict(set)
        for combine in allowed:
            dict[combine[0:2]].add(combine)

        def dfs(remain):
            if len(lst) <= 1:
                return True
            if remain == 1:
                c1 = lst.pop(0)
                if dfs(len(lst)): return True
                lst.insert(0, c1)
            else:
                for candidate in dict.get(''.join(lst[:2]), set()):
                    c = lst.pop(0)
                    lst.append(candidate[2])
                    if dfs(remain - 1): return True
                    lst.pop()
                    lst.insert(0, c)
            return False

        return dfs(len(lst))

    # use solution
    def pyramidTransition(self, bottom: str, allowed: List[str]) -> bool:
        dict = collections.defaultdict(set)
        for u, v, w in allowed:
            dict[u, v].add(w)

        # build next row in pyramid
        def build(A, lst, index=0):
            if index + 1 == len(A):
                yield ''.join(lst)
                return
            for w in dict[A[index], A[index + 1]]:
                lst.append(w)
                for result in build(A, lst, index + 1):
                    yield result
                lst.pop()

        def solve(row):
            if len(row) == 1:
                return True
            return any(solve(cand) for cand in build(row, []))

        return solve(bottom)

    def pyramidTransition(self, bottom: str, allowed: List[str]) -> bool:
        triples = collections.defaultdict(set)
        for triple in allowed:
            triples[triple[0], triple[1]].add(triple[2])

        def solve(row):
            if len(row) == 1:
                return True
            else:
                adjacent = zip(row, row[1:])
                tops = product(*[triples[a, b] for a, b in adjacent])
                return any(map(solve, tops))

        return solve(bottom)


'''
"BCD"
["BCG","CDE","GEA","FFF"]
"AABA"
["AAA", "AAB", "ABA", "ABB", "BAC"]
"AABA"
[]
"ABCDEFGA"
["AAC","ABC","ABD","ABG","BCA","BCE","DEF","EFG","FGC","GAD"]
'''
if __name__ == '__main__':
    tar = _756_Solution()
    assert tar.pyramidTransition("BCD", ["BCG", "CDE", "GEA", "FFF"])
