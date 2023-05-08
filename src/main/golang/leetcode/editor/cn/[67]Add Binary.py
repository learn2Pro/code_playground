# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def addBinary(self, a: str, b: str) -> str:
        ans = ""
        carry = 0
        for c0, c1 in zip(reversed(a), reversed(b)):
            tmp = int(c0) + int(c1) + carry
            carry = tmp // 2
            ans = str(tmp % 2) + ans
        if len(a) > len(b):
            for c0 in reversed(a[:len(a) - len(b)]):
                tmp = int(c0) + carry
                carry = tmp // 2
                ans = str(tmp % 2) + ans
        else:
            for c0 in reversed(b[:len(b) - len(a)]):
                tmp = int(c0) + carry
                carry = tmp // 2
                ans = str(tmp % 2) + ans
        if carry:
            ans = str(carry) + ans
        return ans
# leetcode submit region end(Prohibit modification and deletion)
