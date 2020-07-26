# 658. Find K Closest Elements
import bisect
from typing import List


class _658_Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        arr.sort(key=lambda item: abs(item - x))
        return sorted(arr[:k])

    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        where = bisect.bisect_left(arr, x)
        left, right = max(0, where - k), min(len(arr) - 1, where + k)
        while right - left + 1 > k:
            if abs(arr[right] - x) >= abs(arr[left] - x):
                right -= 1
            elif abs(arr[right] - x) < abs(arr[left] - x):
                left += 1
        return arr[left:right + 1]

    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        lo, hi = 0, len(arr) - k
        while lo < hi:
            mid = (lo + hi) >> 1
            if arr[mid + k] - x < x - arr[mid]:
                lo = mid + 1
            else:
                hi = mid
        return arr[lo:lo + k]


'''
[1,2,3,4,5]
4
3
[1,2,3,4,5]
4
-1
[1]
1
-1
[1,6,7,10,20,23]
1
1
[1,6,7,10,20,23]
1
6
[1,6,7,8,20,23]
3
7
[1,1,1,10,10,10]
1
9
'''
if __name__ == "__main__":
    obj = _658_Solution()
    assert obj.findClosestElements([1, 6, 7, 8, 20, 23], 3, 7) == [6, 7, 8]
    assert obj.findClosestElements([1, 1, 1, 10, 10, 10], 1, 9) == [10]
    assert obj.findClosestElements([1], 1, -1) == [1]
    assert obj.findClosestElements([1, 2, 3, 4, 5], 4, -1) == [1, 2, 3, 4]
    assert obj.findClosestElements([1, 2, 3, 4, 5], 4, 3) == [1, 2, 3, 4]
