# 241. Different Ways to Add Parentheses
from functools import lru_cache
from typing import List


class _241_Solution:
    @lru_cache(None)
    def diffWaysToCompute(self, input: str) -> List[int]:
        if not input: return []
        ops = {"+": lambda x, y: x + y, "-": lambda x, y: x - y, "*": lambda x, y: x * y}
        memorize = {}

        def track(s: str) -> List[int]:
            if s in memorize: return memorize[s]
            inner = []
            for i in range(len(input)):
                if input[i] != '+' and input[i] != '-' and input[i] != '*': continue
                left, right = input[0:i], input[i + 1:]
                part0 = self.diffWaysToCompute(left)
                part1 = self.diffWaysToCompute(right)
                for num0 in part0:
                    for num1 in part1:
                        inner.append(ops[input[i]](num0, num1))
            if not inner:
                inner.append(int(input))
            memorize[s] = inner
            return inner

        return track(input)


if __name__ == '__main__':
    instance = _241_Solution
    assert instance.diffWaysToCompute(instance, "10*20") == [200]
    assert instance.diffWaysToCompute(instance, "2*3-4*5") == [-34, -14, -10, -10, 10]
    assert instance.diffWaysToCompute(instance, "2-1-1") == [0, 2]
