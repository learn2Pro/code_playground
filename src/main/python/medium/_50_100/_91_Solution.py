# 91. Decode Ways

'''
"12"
""
"0"
"1"
"37"
"12121312931381921"
"011"
"0011"
"11000"
"10"
'''


class _91_Solution:
    def numDecodings(self, s: str) -> int:
        n = len(s)
        if n == 0: return 0
        dp = [0] * (n + 1)
        dp[0] = 1
        dp[1] = 0 if s[0] == '0' else 1
        for i in range(2, n + 1):
            if s[i - 1] != '0':
                dp[i] += dp[i - 1]
            if s[i - 2:i] >= '10' and s[i - 2:i] <= '26':
                dp[i] += dp[i - 2]
        return dp[n]


if __name__ == '__main__':
    instance = _91_Solution
    assert instance.numDecodings(instance, "011") == 0
    assert instance.numDecodings(instance, "01") == 0
    assert instance.numDecodings(instance, "101") == 1
    assert instance.numDecodings(instance, "10") == 1
    assert instance.numDecodings(instance, "1") == 1
    assert instance.numDecodings(instance, "") == 0
    assert instance.numDecodings(instance, "0") == 0
    assert instance.numDecodings(instance, "37") == 1
    assert instance.numDecodings(instance, "12") == 2
    assert instance.numDecodings(instance, "226") == 3
