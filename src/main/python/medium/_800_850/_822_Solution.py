# 822. Card Flipping Game
import collections
import itertools
from typing import List


class _822_Solution:
    def flipgame(self, fronts: List[int], backs: List[int]) -> int:
        same = {x for i, x in enumerate(fronts) if x == backs[i]}
        ans = 2001
        for num in itertools.chain(fronts, backs):
            if num not in same:
                ans = min(ans, num)
        return ans % 2001


if __name__ == '__main__':
    obj = _822_Solution()
    assert obj.flipgame([1, 2, 4, 4, 7], [1, 3, 4, 1, 3]) == 2
