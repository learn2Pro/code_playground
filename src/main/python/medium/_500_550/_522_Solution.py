# 522. Longest Uncommon Subsequence II
from typing import List


class _522_Solution:
    def findLUSlength(self, strs: List[str]) -> int:
        strs.sort(key=len, reverse=True)
        size = len(strs)

        def isSubSeq(s0: str, s1: str) -> bool:
            p0 = p1 = 0
            n0, n1 = len(s0), len(s1)
            while p1 < n1 and p0 < n0:
                if s0[p0] == s1[p1]:
                    p0 += 1
                p1 += 1
            return p0 == n0

        for i in range(size):
            current = strs[i]
            earlyStop = False
            for j in range(size):
                if j == i: continue
                if isSubSeq(current, strs[j]):
                    earlyStop = True
                    break
            if not earlyStop: return len(current)
        return -1


'''
["aba","cdc","eae"]
["a","aa","aaa"]
["b","aaa","aaa"]
'''
if __name__ == '__main__':
    obj = _522_Solution()
    assert obj.findLUSlength(["b", "aaa", "aaa"]) == 1
