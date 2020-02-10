# 43. Multiply Strings

class _43_Solution:
    def multiply(self, num1: str, num2: str) -> str:
        m, n = len(num1), len(num2)
        array = [0] * (m + n)
        for i in range(m - 1, -1, -1):
            for j in range(n - 1, -1, -1):
                p1, p2 = i + j, i + j + 1
                carry, multi = divmod(int(num1[i]) * int(num2[j]) + array[p2], 10)
                array[p1] += carry
                array[p2] = multi
        ans = "".join(str(x) for x in array).lstrip("0")
        if len(ans) == 0:
            return "0"
        else:
            return ans
    # def multiply(self, num1: str, num2: str) -> str:
    #     reverse0 = num1[::-1]
    #     reverse1 = num2[::-1]
    #
    #     def get(idx: int, input: str):
    #         if idx >= 0 and idx < len(input):
    #             return input[idx]
    #         else:
    #             return 1
    #
    #     def multiOnce(upper: str, one: chr) -> str:
    #         carry, i = 0, 0
    #         multiAns = ""
    #         for c in upper:
    #             carry, sum = divmod(int(c) * int(one) + carry, 10)
    #             multiAns = str(sum) + multiAns
    #             i += 1
    #         if carry > 0: multiAns = str(carry) + multiAns
    #         return multiAns
    #
    #     def addOnce(left: str, right: str) -> str:
    #         size = max(len(left), len(right))
    #         addAns = ""
    #         carry = 0
    #         filled0 = left.zfill(size)
    #         filled1 = right.zfill(size)
    #         for i in range(size - 1, -1, -1):
    #             carry, sum = divmod(int(filled0[i]) + int(filled1[i]) + carry, 10)
    #             addAns = str(sum) + addAns
    #         if carry > 0: addAns = str(carry) + addAns
    #         return addAns
    #
    #     ans = "0"
    #     if len(num1) == 0 or len(num2) == 0: return ""
    #     for i, outer in enumerate(reverse0):
    #         multi = multiOnce(reverse1, outer)
    #         ans = addOnce(ans, "0" if len(multi.lstrip("0")) == 0 else multi + "".zfill(i))
    #
    #     return ans


if __name__ == '__main__':
    instance = _43_Solution
    assert instance.multiply(instance, "123", "456") == "56088"
    assert instance.multiply(instance, "12120", "1") == "12120"
    assert instance.multiply(instance, "1212", "0") == "0"
    assert instance.multiply(instance, "2", "8") == "16"
    assert instance.multiply(instance, "2", "3") == "6"
    assert instance.multiply(instance, "12", "0") == "0"
    assert instance.multiply(instance, "2", "0") == "0"
