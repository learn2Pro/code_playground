# 402. Remove K Digits
class _402_Solution:
    # stack
    def removeKdigits(self, num: str, k: int) -> str:
        stack = []
        for digit in num:
            while k and stack and stack[-1] > digit:
                stack.pop()
                k -= 1
            stack.append(digit)
        return ''.join(stack[:-k or None]).lstrip('0') or '0'


# brute search
# def removeKdigits(self, num: str, k: int) -> str:
#     for i in range(min(len(num), k)):
#         size = len(num)
#         if size == 0: return '0'
#         num = min(num[:i] + num[i + 1:] for i in range(size)).lstrip('0')
#     return '0' if len(num) == 0 else num


if __name__ == '__main__':
    obj = _402_Solution()
    assert obj.removeKdigits("112", 1) == "11"
    assert obj.removeKdigits("9", 1) == "0"
    assert obj.removeKdigits("1432219", 3) == "1219"
    assert obj.removeKdigits("10200", 1) == "200"
    assert obj.removeKdigits("10", 2) == "0"
