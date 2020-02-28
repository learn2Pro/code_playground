# 166. Fraction to Recurring Decimal
'''
1
2
4
9
0
2
4
333
-2147483648
-1
'''


class _166_Solution:
    def fractionToDecimal(self, numerator: int, denominator: int) -> str:
        if denominator == 0 or numerator == 0: return "0"
        flag = (denominator > 0) == (numerator > 0)
        visited = {}
        ans = ""
        l, r = divmod(abs(numerator), abs(denominator))
        ans += str(l)
        if r != 0: ans += '.'
        i = len(ans)
        while r != 0:
            l, r = divmod(r * 10, abs(denominator))
            if (l, r) in visited:
                ans = ans[:visited[(l, r)]] + '(' + ans[visited[(l, r)]:] + ')'
                break
            visited[(l, r)] = i
            ans += str(l)
            i += 1
        return ans if flag else "-" + ans


if __name__ == '__main__':
    instance = _166_Solution
    assert instance.fractionToDecimal(instance, -50, -8) == "6.25"
    assert instance.fractionToDecimal(instance, -50, 8) == "-6.25"
    assert instance.fractionToDecimal(instance, 1, 6) == "0.1(6)"
    assert instance.fractionToDecimal(instance, 2, 0) == "0"
    assert instance.fractionToDecimal(instance, 0, 2) == "0"
    assert instance.fractionToDecimal(instance, 1, 2) == "0.5"
    assert instance.fractionToDecimal(instance, 2, 1) == "2"
    assert instance.fractionToDecimal(instance, 2, 3) == "0.(6)"
