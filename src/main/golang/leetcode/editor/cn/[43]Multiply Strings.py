# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def multiply(self, num1: str, num2: str) -> str:
        # def multi(num: str, c1: str) -> str:
        #     n = len(num)
        #     ans = ""
        #     carry = 0
        #     for i in reversed(range(n)):
        #         c0 = num[i]
        #         multi = carry + (int(c0) - int('0')) * (int(c1) - int('0'))
        #         carry, remain = multi // 10, multi % 10
        #         ans = str(remain) + ans
        #     if carry > 0:
        #         ans = str(carry) + ans
        #     return ans
        #
        # def plus(n0: str, n1: str) -> str:
        #     if len(n1) > len(n0):
        #         n0, n1 = n1, n0
        #     n1 = "0" * (len(n0) - len(n1)) + n1
        #     N = len(n0)
        #     ans, carry = "", 0
        #     for i in reversed(range(N)):
        #         c0, c1 = n0[i], n1[i]
        #         p = carry + (int(c0) - int('0')) + (int(c1) - int('0'))
        #         carry, remain = p // 10, p % 10
        #         ans = str(remain) + ans
        #     if carry > 0:
        #         ans = str(carry) + ans
        #     return ans
        #
        # if len(num2) > len(num1):
        #     num1, num2 = num2, num1
        # N = len(num2)
        # last = "0"
        # for i in reversed(range(N)):
        #     c = num2[i]
        #     toPlus = multi(num1, c) + "0" * (N - 1 - i)
        #     last = plus(toPlus, last)
        # return str(int(last))

        if num1 == "0" or num2 == "0":
            return "0"
        m, n = len(num1), len(num2)
        ans = [0] * (m + n)
        for i in reversed(range(m)):
            x = int(num1[i])
            for j in reversed(range(n)):
                ans[i + j + 1] += x * int(num2[j])
        for i in reversed(range(1, m + n)):
            ans[i - 1] += ans[i] // 10
            ans[i] %= 10
        index = 1 if ans[0] == 0 else 0
        return "".join(str(x) for x in ans[index:])
# leetcode submit region end(Prohibit modification and deletion)
