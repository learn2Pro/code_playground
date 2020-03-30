# 397. Integer Replacement
class _397_Solution:

    # dp
    def integerReplacement(self, n: int) -> int:
        count = 0
        while n != 1:
            if n % 2 == 0:
                n //= 2
            elif n % 4 == 1 or n == 3:
                n -= 1
            else:
                n += 1
            count += 1
        return count

    # dfs
    def integerReplacement(self, n: int) -> int:
        def dfs(previous: int, step: int) -> int:
            if previous == 1: return step
            minimal = 0x7fffffff
            if previous % 2 == 0:
                minimal = min(minimal, dfs(previous // 2, step + 1))
            else:
                minimal = min(minimal, dfs(previous + 1, step + 1), dfs(previous - 1, step + 1))
            return minimal

        return dfs(n, 0)
