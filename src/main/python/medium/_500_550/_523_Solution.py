# 523. Continuous Subarray Sum
from typing import List


class _523_Solution:
    def checkSubarraySum(self, nums: List[int], k: int) -> bool:
        acc = 0
        remain = {0: -1}
        for i in range(len(nums)):
            acc += nums[i]
            if k != 0: acc %= k
            if acc in remain:
                prev = remain[acc]
                if i - prev > 1: return True
            else:
                remain[acc] = i
        return False


'''
[23,2,4,6,7]
6
[23,2,4,6,7]
-6
[]
6
[1,2]
5
[1,2,2,32,32,32,3,1312,31,231,231,3,123,1,23,12,1,23,87,3,7668,768,6,87,86,78,687,6,86,7645,565,45,3,53,5,345,34,45,645,64,5656,4,57,68,79,789,78789,6,563,44,234,23,43,654,77,698,98,0,765652,43,78098,89]
3293829
[1,2,2,32,32,32,3,1312,31,231,231,3,123,1,23,12,1,23,87,3,7668,768,6,87,86,78,687,6,86,7645,565,45,3,53,5,345,34,45,645,64,5656,4,57,68,79,789,78789,6,563,44,234,23,43,654,77,698,98,0,765652,43,78098,89]
-1
[23,2,6,4,7]
0
[0]
0
[1,1,0,0]
0
'''
if __name__ == '__main__':
    obj = _523_Solution()
    assert obj.checkSubarraySum([23, 1, 0, 0], 0)
    assert obj.checkSubarraySum([0, 0], 0)
    assert not obj.checkSubarraySum([23, 2, 4, 6, 7], 0)
    assert not obj.checkSubarraySum([0], 0)
    assert obj.checkSubarraySum([1, 2, 3], 6)
    assert obj.checkSubarraySum([23, 2, 4, 6, 7], 6)
