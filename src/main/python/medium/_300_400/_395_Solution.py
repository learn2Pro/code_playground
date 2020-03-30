# 395. Longest Substring with At Least K Repeating Characters
class _395_Solution:

    # backtrack
    # def longestSubstring(self, s: str, k: int) -> int:
    #     if not s or len(s) < k: return 0
    #     c = min(set(s), key=s.count)
    #     if s.count(c) >= k:
    #         return len(s)
    #     return max(self.longestSubstring(partial, k) for partial in s.split(c))

    def longestSubstring(self, s: str, k: int) -> int:
        def iterative(numTarget: int) -> int:
            lo, hi, maximal = 0, 0, 0
            holder = [0] * 26
            numUnique, numNoLessK = 0, 0
            while hi < len(s):
                if numUnique <= numTarget:
                    idx0 = ord(s[hi]) - ord('a')
                    if holder[idx0] == 0: numUnique += 1
                    if holder[idx0] == k - 1: numNoLessK += 1
                    holder[idx0] += 1
                    hi += 1
                while numUnique > numTarget:
                    idx0 = ord(s[lo]) - ord('a')
                    if holder[idx0] == 1: numUnique -= 1
                    if holder[idx0] == k: numNoLessK -= 1
                    holder[idx0] -= 1
                    lo += 1
                if numUnique == numTarget and numNoLessK == numUnique:
                    maximal = max(maximal, hi - lo)
            return maximal

        return max(map(iterative, range(1, 27)))

    # def longestSubstring(self, s: str, k: int) -> int:
    #     lo, hi, direction = 0, 0, 1
    #     counter, maximal = [0] * 26, 0
    #     n = len(s)
    #     while lo < n:
    #         counter[ord(s[hi]) - ord('a')] += direction
    #         if all(map(lambda x: x == 0 or x >= k, counter)):
    #             maximal = max(maximal, hi - lo + (0 if direction < 0 else 1))
    #         hi += direction
    #         if hi == n or hi <= lo:
    #             counter[ord(s[lo]) - ord('a')] -= 1
    #             lo += 1
    #             hi -= direction
    #             direction *= -1
    #     return maximal


'''
"aaabb"
3
"acd"
1
"ababbc"
2
""
0
"asdadas"
2
"bbaaacbd"
3
"baaabcb"
3
'''
if __name__ == '__main__':
    obj = _395_Solution()
    assert obj.longestSubstring("ababbc", 2) == 5
    assert obj.longestSubstring("baaabcb", 3) == 3
    assert obj.longestSubstring("aaabb", 3) == 3
    assert obj.longestSubstring("acd", 1) == 3
    assert obj.longestSubstring("asdadas", 2) == 7
    assert obj.longestSubstring("bbaaacbd", 3) == 3
    assert obj.longestSubstring("", 0) == 0
