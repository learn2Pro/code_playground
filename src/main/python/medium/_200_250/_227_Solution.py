# 227. Basic Calculator II
import re


class _227_Solution:
    def calculate(self, s: str) -> int:
        stack = []
        ops = {"+": lambda x, y: x + y, "-": lambda x, y: x - y, "*": lambda x, y: x * y, '/': lambda x, y: x // y}
        previousOp = None
        repair, repairOp = None, None
        splits = re.split("[+|*|/|\\-]", s)

        def calc():
            nonlocal repairOp, previousOp, repair
            r, l = stack.pop(), stack.pop()
            if repairOp and repairOp != previousOp:
                if repairOp == "-":
                    l = repair - l
                elif repairOp == "+":
                    l = l - repair
            ans = ops[previousOp](l, r)
            if repairOp and repairOp != previousOp:
                ans = ops[repairOp](repair, ans)
            previousOp = None
            stack.append(ans)
            return previousOp

        i = len(splits[0])
        stack.append(int(splits[0]))
        for idx in range(1, len(splits)):
            partial = splits[idx]
            c = s[i]
            i += len(partial) + 1
            stack.append(int(partial))
            if not previousOp and (c == '+' or c == '-'):
                previousOp = repairOp = c
                repair = stack[-2]
            elif not previousOp and (c == '*' or c == '/'):
                previousOp = c
            previousOp = calc()
        return stack[-1]


if __name__ == '__main__':
    instance = _227_Solution
    assert instance.calculate(instance, " 33+55 / 21 ") == 35
    assert instance.calculate(instance, "14-3/2") == 13
    assert instance.calculate(instance, "0-0") == 0
    assert instance.calculate(instance, " 33+5 / 2 ") == 35
    assert instance.calculate(instance, " 3+5 / 2 ") == 5
    assert instance.calculate(instance, " 3/2 ") == 1
    assert instance.calculate(instance, "3+2*2") == 7
