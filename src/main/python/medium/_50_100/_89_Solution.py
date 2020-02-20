# 89. Gray Code
from typing import List
import numpy as np


class _89_Solution:
    def grayCode(self, n: int) -> List[int]:
        ans = []
        ans.append(0)
        for i in range(1, n + 1):
            for j in reversed(ans):
                ans.append(j | (1 << (i - 1)))

        return ans


if __name__ == '__main__':
    instance = _89_Solution
    assert instance.grayCode(instance, 0) == [0]
    assert instance.grayCode(instance, 1) == [0, 1]
    assert instance.grayCode(instance, 2) == [0, 1, 3, 2]
    assert instance.grayCode(instance, 3) == [0, 1, 3, 2, 6, 7, 5, 4]
