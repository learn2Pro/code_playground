# 781. Rabbits in Forest
import collections
from math import ceil
from typing import List


class _781_Solution:
    def numRabbits(self, answers: List[int]) -> int:
        colors, accumulate = {}, 0
        for answer in answers:
            if answer == 0:
                accumulate += 1
                continue
            if answer in colors:
                remain = colors[answer] - 1
                if remain == 0:
                    accumulate += answer + 1
                    del colors[answer]
                else:
                    colors[answer] = remain
            else:
                colors[answer] = answer
        for k, _ in colors.items():
            accumulate += k + 1
        return accumulate

    # more concise
    def numRabbits(self, answers: List[int]) -> int:
        colors, accumulate = {}, 0
        for answer in answers:
            colors[answer] = colors.get(answer, 0) + 1
        for k, v in colors.items():
            accumulate += ceil(v / (k + 1)) * (k + 1)
        return accumulate

    # use counter
    def numRabbits(self, answers: List[int]) -> int:
        colors, accumulate = collections.Counter(answers), 0
        for k, v in colors.items():
            accumulate += ceil(v / (k + 1)) * (k + 1)
        return accumulate



'''
[1,0,1,0,0]
[1,1,2]
[10,10,10]
[]
[1,1,1]
[0]
'''
if __name__ == '__main__':
    tar = _781_Solution()
    assert tar.numRabbits([1, 0, 1, 0, 0]) == 5
