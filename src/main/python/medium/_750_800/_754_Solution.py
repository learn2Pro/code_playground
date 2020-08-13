# 754. Reach a Number
class _754_Solution:
    def reachNumber(self, target: int) -> int:
        target = abs(target)
        curr = 0
        while target > 0:
            curr += 1
            target -= curr
        return curr if target % 2 == 0 else curr + 1 if (target - curr - 1) % 2 == 0 else curr + 2
