# 718. Maximum Length of Repeated Subarray
import collections
from typing import List


class _718_Solution:
    def findLength(self, A: List[int], B: List[int]) -> int:
        m, n = len(A), len(B)
        dp, ans = [0] * (n + 1), 0
        for i in range(1, m + 1):
            t0 = dp[0]
            for j in range(1, n + 1):
                dp[j], t0 = t0 + 1 if A[i - 1] == B[j - 1] else 0, dp[j]
                ans = max(dp[j], ans)
        return ans

    def findLength(self, A: List[int], B: List[int]) -> int:
        def check(size):
            seen = {A[i:i + size] for i in range(len(A) - size + 1)}
            return any(B[i:i + size] in seen for i in range(len(B) - size + 1))

        A, B = ''.join(map(chr, A)), ''.join(map(chr, B))
        lo, hi = 0, min(len(A), len(B)) + 1
        while lo < hi:
            mi = (lo + hi) >> 1
            if check(size=mi):
                lo = mi + 1
            else:
                hi = mi
        return lo - 1

    # rolling-hash
    # hash(text[s+1:s+m+1]) = d(hash(text[s:m]) - text(s)*h)+text[s+m+1]) mod q
    # d: number in the text = 256
    # q: a prime number = 101
    # h: d^(m-1)
    def findLength(self, A, B):
        q, d = 113, 256

        def check(guess):
            def rollingHash(s, length):
                h = (d ** (length - 1)) % q
                p = 0
                for i in range(length):
                    p = (d * p + s[i]) % q
                # the 0-index
                yield p, 0
                for i in range(1, len(s) - length + 1):
                    p = (d * (p - s[i - 1] * h) + s[i + length - 1]) % q
                    yield p, i

            hashes = collections.defaultdict(list)
            for ha, start in rollingHash(A, guess):
                hashes[ha].append(start)
            for ha, start in rollingHash(B, guess):
                iarr = hashes.get(ha, [])
                if any(A[i:i + guess] == B[start:start + guess] for i in iarr):
                    return True
            return False

        lo, hi = 0, min(len(A), len(B)) + 1
        while lo < hi:
            mi = (lo + hi) // 2
            if check(mi):
                lo = mi + 1
            else:
                hi = mi
        return lo - 1


'''
[1,2,3,2,1]
[3,2,1,4,7]
[3,2,1]
[1,2,3,2,1]
[1]
[1,1,1,1,1]
[2,2]
[2,2,1,3,3]
[1]
[3,1]
[1,1,1,1]
[2,2,2,2,2]
'''
if __name__ == '__main__':
    obj = _718_Solution()
    assert obj.findLength([3, 2, 1], [1, 2, 3, 2, 1]) == 3
    assert obj.findLength([1, 2, 3, 2, 1], [3, 2, 1, 4, 7]) == 3
