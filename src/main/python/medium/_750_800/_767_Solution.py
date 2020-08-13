# 767. Reorganize String
import heapq

from sortedcontainers import SortedDict


class _767_Solution:
    def reorganizeString(self, S: str) -> str:
        container, maximal = [0] * 26, 0
        for c in S:
            container[ord(c) - ord('a')] += 1
            maximal = max(maximal, container[ord(c) - ord('a')])
        if maximal == 1: return S
        for i in range(26):
            container[i] = container[i], chr(i + ord('a'))
        container.sort()
        if len(S) + 1 < 2 * maximal: return ""
        gap = len(S) // maximal + 1
        ans, p0, iter = [''] * gap * (maximal + 1), 0, 0
        for i in reversed(range(26)):
            cnt, c = container[i]
            if cnt == 0: continue
            while cnt:
                if p0 >= maximal * gap:
                    iter += 1
                    p0 = iter
                ans[p0] = c
                p0 += gap
                cnt -= 1
        return ''.join(ans)

    # arrange by aXaXaX
    def reorganizeString(self, S: str) -> str:
        N = len(S)
        ans = []
        for c, x in sorted((S.count(c), c) for c in set(S)):
            if 2 * c > N + 1: return ""
            ans.extend(c * x)
        ans[::2], ans[1::2] = ans[N // 2:], ans[:N // 2]
        return ''.join(ans)

    # use heap
    def reorganizeString(self, S: str) -> str:
        N, ans = len(S), []
        heap = [(-S.count(c), c) for c in set(S)]
        if any(-nc > (len(S) + 1) / 2 for nc, x in heap):
            return ""
        heapq.heapify(heap)
        while len(heap) >= 2:
            s0, c0 = heapq.heappop(heap)
            s1, c1 = heapq.heappop(heap)
            ans.extend([c0, c1])
            if s0 + 1: heapq.heappush(heap, (s0 + 1, c0))
            if s1 + 1: heapq.heappush(heap, (s1 + 1, c1))
        return "".join(ans) + (heap[0][1] if heap else "")


'''
"aab"
"aaaabbc"
"a"
"abcdefg"
"aeeebbccaaddaaaa"
"aaab"
"aaaa"
"ababab"
"cccbbb"
"cccbbbb"
"eqmeyggvp"
'''
if __name__ == '__main__':
    tar = _767_Solution()
    assert tar.reorganizeString("cccbbb") == "bcbcbc"
    assert tar.reorganizeString("aaaaxxx") == "axaxaxa"
    assert tar.reorganizeString("eqmeyggvp") == "geyqmgevp"
    assert tar.reorganizeString("aaaa") == ""
    assert tar.reorganizeString("aaab") == ""
    assert tar.reorganizeString("a") == "a"
    assert tar.reorganizeString("ddddbbc") == "dbdbdcd"
    assert tar.reorganizeString("ddb") == "dbd"
    assert tar.reorganizeString("aaab") == ""
