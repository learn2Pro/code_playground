# 825. Friends Of Appropriate Ages
import bisect
from typing import List

'''
[120,100,70]
[]
[1,2,3]
[16,16]
[1,1,1,1]
[100,100,100,90,80]
[16,17,18]
[20,30,100,110,120]
[1,2,3,4,5,6,7,8,9,10,20,30,40,50,60,70,80,90,100,101,110,105,120]
'''
class _825_Solution:
    def numFriendRequests(self, ages: List[int]) -> int:
        ages.sort()
        N = len(ages)
        ans = 0
        for age in ages:
            l, r = bisect.bisect_right(ages, age * 0.5 + 7), bisect.bisect_right(ages, age)
            ans += max(0, (r - l - 1))
        return ans


if __name__ == '__main__':
    tar = _825_Solution()
    assert tar.numFriendRequests([1, 2, 3]) == 0
    assert tar.numFriendRequests([120, 100, 70]) == 3
