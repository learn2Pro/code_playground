# 6 ZigZag Conversion

class _6_Solution:
    def convert(self, s: str, numRows: int) -> str:
        if len(s) == 0: return ""
        if numRows == 1: return s
        ans = ""
        #   -             -
        #    - *gap1* - *gap0* -
        #        -
        #
        # 0->2n-2
        # 1->2n-3
        # ...
        # n-1->n-1
        for i in range(numRows):
            gap0 = 2 * i
            gap1 = 2 * numRows - 2 - gap0
            pointer, j = i, 0
            if i < len(s): ans += s[i]
            while pointer < len(s):
                incr = (gap1 if j % 2 == 0 else gap0)
                pointer += incr
                if pointer < len(s) and incr != 0: ans += s[pointer]
                j += 1
        return ans


if __name__ == '__main__':
    instance = _6_Solution
    assert instance.convert(instance, "AB", 3) == "AB"
    assert instance.convert(instance, "A", 2) == "A"
    assert instance.convert(instance, "A", 1) == "A"
    assert instance.convert(instance, "", 4) == ""
    assert instance.convert(instance, "PAYPALISHIRING", 4) == "PINALSIGYAHRPI"
    assert instance.convert(instance, "PAYPALISHIRING", 3) == "PAHNAPLSIIGYIR"
