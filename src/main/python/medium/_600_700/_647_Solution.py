# 647. Palindromic Substrings
class _647_Solution:
    def countSubstrings(self, s: str) -> int:
        size, ans = len(s), 0

        def check(start, end):
            nonlocal ans
            while start >= 0 and end < size and s[start] == s[end]:
                ans += 1
                start -= 1
                end += 1

        for i in range(size):
            check(i, i)
        for i in range(size):
            check(i, i + 1)
        return ans

    def countSubstrings(self, s: str) -> int:
        length = len(s)

        self.count = 0
        for i in range(length):
            self.helper(s, i, i)
        for i in range(length):
            self.helper(s, i, i + 1)
        return self.count

    def helper(self, s: str, l: int, r: int):
        while l >= 0 and r < len(s) and s[l] == s[r]:
            self.count += 1
            l -= 1
            r += 1

    def countSubstrings(self, S):
        def manachers(S):
            A = '@#' + '#'.join(S) + '#$'
            size = len(A)
            lps = [0] * size
            center, right = 0, 0
            for i in range(1, size - 1):
                if i < right:
                    lps[i] = min(right - i, lps[2 * center - i])
                while A[i - lps[i] - 1] == A[i + lps[i] + 1]:
                    lps[i] += 1
                if i + lps[i] > right:
                    center, right = i, i + lps[i]
            return sum((v + 1) // 2 for v in lps)

        return manachers(S)


if __name__ == '__main__':
    obj = _647_Solution()
    assert obj.countSubstrings("aaabc") == 8
    assert obj.countSubstrings("aabc") == 4
    assert obj.countSubstrings("aaa") == 6
