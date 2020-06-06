# 519. Random Flip Matrix
import random
from typing import List

'''
["Solution", "flip", "flip", "flip", "flip"]
[[2, 2], [], [], [], []]
["Solution", "flip", "flip", "flip", "flip","flip","flip","flip","flip","flip","reset","flip","flip"]
[[200, 200], [], [], [], [], [], [], [], [], [], [], [], []]
["Solution","flip","flip","reset","flip"]
[[1,2],[],[],[],[]]
'''
class _519_Solution:

    def __init__(self, n_rows: int, n_cols: int):
        self.visited = set()
        self.row = n_rows
        self.col = n_cols

    def flip(self) -> List[int]:
        choosed = random.randint(0, self.row * self.col - 1)
        while choosed in self.visited:
            choosed = random.randint(0, self.row * self.col - 1)
        self.visited.add(choosed)
        return divmod(choosed,self.col)

    def reset(self) -> None:
        self.visited.clear()

    def __init__(self, n_rows: int, n_cols: int):
        self.random = -1
        self.r, self.c = n_rows, n_cols
        self.ub = self.r * self.c

    def flip(self) -> List[int]:
        self.random = (self.random + 1) % self.ub
        return divmod(self.random, self.c)

    def reset(self) -> None:
        pass
