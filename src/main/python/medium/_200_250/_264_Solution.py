# 264. Ugly Number II
class Ugly:
    def __init__(self):
        p2 = p3 = p5 = 0
        ans = [1]
        for i in range(1691):
            minimal = min(ans[p2] * 2, ans[p3] * 3, ans[p5] * 5)
            if minimal == ans[p2] * 2: p2 += 1
            if minimal == ans[p3] * 3: p3 += 1
            if minimal == ans[p5] * 5: p5 += 1
            ans.append(minimal)
        self.ugly = ans
class _264_Solution:
    u = Ugly()
    def nthUglyNumber(self, n: int) -> int:
        return self.u.ugly[n - 1]


if __name__ == '__main__':
    instance = _264_Solution()
    assert instance.nthUglyNumber(1) == 1
    assert instance.nthUglyNumber(10) == 12
