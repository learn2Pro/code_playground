# 29. Divide Two Integers

class _29_Solution:
    def divide(self, dividend: int, divisor: int) -> int:
        sig = (dividend < 0) is (divisor < 0)
        a, b, ans = abs(dividend), abs(divisor), 0
        while a >= b:
            x = 0
            while a >= b << (x + 1): x += 1
            ans += 1 << x
            a -= b << x
        return min(ans if sig else -ans, 2147483647)


if __name__ == '__main__':
    instance = _29_Solution
    assert instance.divide(instance, 2147483647, 1) == 2147483647
    assert instance.divide(instance, -2147483648, 1) == -2147483648
    assert instance.divide(instance, -2147483648, -1) == 2147483647
    assert instance.divide(instance, 4, 2) == 2
    assert instance.divide(instance, 3, 2) == 1
