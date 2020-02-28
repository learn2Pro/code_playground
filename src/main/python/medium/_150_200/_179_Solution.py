# 179. Largest Number
import functools
from typing import List

'''
[10,2]
[3,30,34,5,9]
[]
[1,2]
[222,22]
[221,22]
[12,21]
[0,0,1,10]
[101,11]
'''


class _179_Solution:
    def largestNumber(self, nums: List[int]) -> str:
        def compare(x, y):
            s0, s1 = x + y, y + x
            if s0 > s1:
                return 1
            elif s0 < s1:
                return -1
            else:
                return 0

        if not nums: return ""
        ans = ''.join(sorted(map(str, nums), key=functools.cmp_to_key(compare), reverse=True)).lstrip('0')
        return ans if ans else '0'


if __name__ == '__main__':
    instance = _179_Solution
    assert instance.largestNumber(instance, [3, 30, 34, 5, 9]) == "9534330"
