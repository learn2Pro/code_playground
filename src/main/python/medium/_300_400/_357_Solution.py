# 357. Count Numbers with Unique Digits
class _357_Solution:
    def countNumbersWithUniqueDigits(self, n: int) -> int:
        if n == 0: return 1
        if n == 1: return 10
        ans, multi = 10, 9
        for i in range(0, min(9, n - 1)):
            multi *= (9 - i)
            ans += multi
        return ans
