# 400. Nth Digit
class _400_Solution:
    def findNthDigit(self, n: int) -> int:
        if n == 0: return 0
        curr = i = 0
        while n > curr:
            n -= curr
            i += 1
            curr = 9 * i * (10 ** (i - 1))
        which = 10 ** (i - 1) + (n - 1) // i
        remain = (n - 1) % i
        return int(str(which)[remain])


if __name__ == '__main__':
    obj = _400_Solution()
    assert obj.findNthDigit(3) == 3
    assert obj.findNthDigit(11) == 0
    assert obj.findNthDigit(12) == 1
