# 790. Domino and Tromino Tiling
class _790_Solution:
    def __init__(self):
        self.ans = [0] * 1001
        self.MOD = 10 ** 9 + 7
        a, b, c, d, e, accumulate = 0, 0, 0, 1, 1, 0
        self.ans[0], self.ans[1] = 0, 1
        for i in range(2, 1001):
            accumulate += a
            a, b, c, d, e = b, c, d, e, (2 * b + 2 * c + d + e + 2 * (accumulate if i >= 5 else 0)) % self.MOD
            self.ans[i] = e

    def numTilings(self, N: int) -> int:
        return self.ans[N] % self.MOD

    # use simplify
    def numTilings(self, N: int) -> int:
        MOD = 10 ** 9 + 7
        a, b, c = 0, 1, 1
        for i in range(2, N + 1):
            a, b, c = b, c, (2 * c + a) % MOD
        return c % MOD


if __name__ == '__main__':
    tar = _790_Solution()
    assert tar.numTilings(1) == 1
    assert tar.numTilings(2) == 2
    assert tar.numTilings(3) == 5
    assert tar.numTilings(4) == 11
    assert tar.numTilings(5) == 24
    assert tar.numTilings(6) == 53
    assert tar.numTilings(7) == 117
    assert tar.numTilings(7) == 117
