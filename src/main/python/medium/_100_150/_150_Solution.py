# 150. Evaluate Reverse Polish Notation
from typing import List


class _150_Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        stack = []
        arithmetic = {"+": lambda x, y: x + y, "-": lambda x, y: x - y, "*": lambda x, y: x * y,
                      "/": lambda x, y: int(x / y)}
        for token in tokens:
            if token == "+" or token == "-" or token == "*" or token == "/":
                right = stack.pop()
                left = stack.pop()
                stack.append(arithmetic[token](left, right))
            else:
                stack.append(int(token))
        return stack[-1] if stack else 0


if __name__ == '__main__':
    instance = _150_Solution
    assert instance.evalRPN(instance, ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]) == 22
    assert instance.evalRPN(instance, ["2", "1", "+", "3", "*"]) == 9
