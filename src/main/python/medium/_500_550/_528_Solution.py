# 528. Random Pick with Weight
import bisect
import random
from typing import List


class _528_Solution:

    def __init__(self, w: List[int]):
        self.sumArr, self.all = [0] * (len(w) + 1), 0
        for i in range(len(w)):
            self.sumArr[i + 1] = self.sumArr[i] + w[i]
            self.all += w[i]

    def pickIndex(self) -> int:
        choose = random.randint(0, self.all - 1)
        return bisect.bisect(self.sumArr, choose) - 1


'''
["Solution","pickIndex"]
[[[1]],[]]
["Solution","pickIndex"]
[[[2,8]],[]]
["Solution","pickIndex"]
[[[2,8,3,10,19,31]],[]]
'''
if __name__ == '__main__':
    obj = _528_Solution([1])
    assert obj.pickIndex() == 0
