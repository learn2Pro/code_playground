# 22. Generate Parentheses
from typing import List


class _22_Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        ans = []

        def backtrack(previous: str, left: int, right: int) -> None:
            if left == right == 0: ans.append(previous);return;
            if left > 0: backtrack(previous + '(', left - 1, right)
            if left < right: backtrack(previous + ')', left, right - 1)

        backtrack("", n, n)
        return ans


if __name__ == '__main__':
    instance = _22_Solution
    assert instance.generateParenthesis(instance, 0) == [""]
    assert instance.generateParenthesis(instance, 1) == ["()"]
    assert instance.generateParenthesis(instance, 2) == ["(())", "()()"]
    assert instance.generateParenthesis(instance, 3) == ["((()))", "(()())", "(())()", "()(())", "()()()"]
