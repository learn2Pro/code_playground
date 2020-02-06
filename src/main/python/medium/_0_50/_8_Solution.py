# 8. String to Integer (atoi)
class _8_Solution:
    def myAtoi(self, str: str) -> int:
        trim = str.strip()
        if len(trim) == 0: return 0
        sign = -1 if trim[0] == '-' else 1
        start = 1 if trim[0] == '-' or trim[0] == '+' else 0
        ans = 0
        for i in range(start, len(trim)):
            if trim[i].isdigit():
                ans = ans * 10 + int(trim[i])
                if ans > 0x7fffffff:
                    if sign < 0:
                        return -2147483648
                    else:
                        return 2147483647
            else:
                return int(sign * ans)
        return int(sign * ans)


if __name__ == '__main__':
    instance = _8_Solution
    assert instance.myAtoi(instance, "+1") == 1
    assert instance.myAtoi(instance, "-91283472332") == -2147483648
    assert instance.myAtoi(instance, "") == 0
    assert instance.myAtoi(instance, "2147483647") == 2147483647
    assert instance.myAtoi(instance, "-2147483648") == -2147483648
    assert instance.myAtoi(instance, "42") == 42
    assert instance.myAtoi(instance, "   -42") == -42
    assert instance.myAtoi(instance, "4193 with words") == 4193
    assert instance.myAtoi(instance, "words and 987") == 0
    assert instance.myAtoi(instance, "-91283472332") == -2147483648
    assert instance.myAtoi(instance, "91283472332") == 2147483647
