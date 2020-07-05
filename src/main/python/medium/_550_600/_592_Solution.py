# 592. Fraction Addition and Subtraction
import re
from functools import reduce


class _592_Solution:
    def fractionAddition(self, expression: str) -> str:
        if not expression:
            return "0/1"
        if expression[0] == "-":
            splits = re.split(r'[\+|\-]', expression[1:])
            splits[0] = "-" + splits[0]
        else:
            splits = re.split(r'[\+|\-]', expression)
        index = which = 0

        def gcd(a, b):
            while b:
                a, b = b, a % b
            return a

        def calc(s0: str, s1: str):
            nonlocal index, which
            index += len(splits[which])
            flag = True if expression[index] == "+" else False
            index += 1
            which += 1
            n0, d0 = int(s0.split("/")[0]), int(s0.split("/")[1])
            n1, d1 = int(s1.split("/")[0]), int(s1.split("/")[1])
            denominator = d0 * d1
            numerator = n0 * d1 + n1 * d0 if flag else n0 * d1 - n1 * d0
            divisor = gcd(numerator, denominator)
            return str(numerator // divisor) + "/" + str(denominator // divisor)

        return reduce(calc, splits)


'''
"-1/2+1/2"
"1/3-1/2"
"-1/2+1/2+1/3"
"5/3+1/3"
"0/1"
"0/1-1/2"
"-0/1+1/2"
"-1/10"
"-1/10-1/10+7/9+21/30"
"1/10+1/9+7/8-3/10"
'''
if __name__ == '__main__':
    obj = _592_Solution()
    assert obj.fractionAddition("-1/10-1/10+7/9+21/30") == "23/18"
    assert obj.fractionAddition("-1/2+1/2") == "0/1"
    assert obj.fractionAddition("-1/2+1/2+1/3") == "1/3"
    assert obj.fractionAddition("1/3-1/2") == "-1/6"
