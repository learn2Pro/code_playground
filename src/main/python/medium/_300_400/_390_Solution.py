# 390. Elimination Game
class _390_Solution:
    # use iterative
    def lastRemaining(self, n: int) -> int:
        step, head = 1, 1
        remain, left = n, True
        while remain > 1:
            if left or remain % 2 == 1:
                head += step
            step *= 2
            remain //= 2
            left = not left
        return head
        # ML(n)+MR(n) == 1+n
    # def lastRemaining(self, n: int) -> int:
    #     if n == 1:
    #         return 1
    #     else:
    #         return 2 * (1 + n // 2 - self.lastRemaining(n // 2))
