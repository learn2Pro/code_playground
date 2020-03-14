# 306. Additive Number
class _306_Solution:
    def isAdditiveNumber(self, num: str) -> bool:
        def addStr(l: str, r: str) -> str:
            n0, n1 = len(l), len(r)
            size = max(n0, n1)
            s0, s1 = l.zfill(size), r.zfill(size)
            carry = 0
            ans = ""
            for i in range(size - 1, -1, -1):
                carry, remain = divmod(int(s0[i]) + int(s1[i]) + carry, 10)
                ans += str(remain)
            if carry != 0: ans += str(carry)
            return ans[::-1]

        def backtrack(left: str, right: str, index: int) -> bool:
            if index >= len(num):
                return True
            sumOfStr = addStr(left, right)
            if sumOfStr == num[index:index + len(sumOfStr)]:
                return backtrack(right, sumOfStr, index + len(sumOfStr))
            else:
                return False

        for i in range(1, len(num) // 2 + 1):
            if num[0:i].startswith("0") and num[0:i] != "0": continue
            for j in range(i + 1, len(num)):
                if num[i:j].startswith("0") and num[i:j] != "0": continue
                if backtrack(num[0:i], num[i:j], j): return True
        return False


'''
"112358"
"199100199"
"214748367812147483679"
"011"
"10111"
"10235"
"1203"
"199001200"
"1023"
"011"
"001199200"
"100111"
'''

if __name__ == '__main__':
    instance = _306_Solution()
    assert not instance.isAdditiveNumber("100111")
    assert not instance.isAdditiveNumber("1023")
    assert instance.isAdditiveNumber("011")
    assert not instance.isAdditiveNumber("001199200")
    assert not instance.isAdditiveNumber("199001200")
    assert instance.isAdditiveNumber("214748367812147483679")
    assert instance.isAdditiveNumber("011")
    assert instance.isAdditiveNumber("10111")
    assert not instance.isAdditiveNumber("1203")
    assert not instance.isAdditiveNumber("10235")
    assert instance.isAdditiveNumber("112358")
    assert instance.isAdditiveNumber("199100199")
