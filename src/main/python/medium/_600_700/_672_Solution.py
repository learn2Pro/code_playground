# 672. Bulb Switcher II
class _672_Solution:
    def flipLights(self, n: int, m: int) -> int:
        if n == 0 or m == 0:
            return 1
        elif m == 1 or m + n <= 4:
            return min(2 ** n, 4, m + n)
        elif m * 4 == 8:
            return min(2 ** n, 7)
        else:
            return min(2 ** n, 8)

    def flipLights(self, n: int, m: int) -> int:
        n = min(n, 3)
        if m == 0:
            return 1
        elif m == 1:
            return [2, 3, 4][n - 1]
        elif m == 2:
            return [2, 4, 7][n - 1]
        return [2, 4, 8][n - 1]
