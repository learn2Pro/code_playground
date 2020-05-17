# 462. Minimum Moves to Equal Array Elements II
from typing import List


class _462_Solution:
    def minMoves2(self, nums: List[int]) -> int:
        if not nums: return 0
        mid = sorted(nums)[len(nums) // 2]
        return sum(abs(num - mid) for num in nums)

    def minMoves2(self, nums: List[int]) -> int:
        def swap(i0, i1):
            tmp = nums[i1]
            nums[i1] = nums[i0]
            nums[i0] = tmp

        def quickselect(k: int, lo: int, hi: int) -> int:
            pivot = nums[lo]
            s, e = lo, hi + 1
            while True:
                while s < hi:
                    s += 1
                    if nums[s] >= pivot: break
                while e > lo:
                    e -= 1
                    if nums[e] <= pivot: break
                if s >= e:
                    swap(lo, e)
                    break
                swap(s, e)
            if e - lo + 1 == k:
                return nums[e]
            elif e - lo + 1 > k:
                return quickselect(k, lo, e - 1)
            else:
                return quickselect(k - e + lo - 1, e + 1, hi)

        median = quickselect(len(nums) // 2 + 1, 0, len(nums) - 1)
        return sum(abs(num - median) for num in nums)


if __name__ == '__main__':
    obj = _462_Solution()
    assert obj.minMoves2([1, 2, 3]) == 2
    assert obj.minMoves2([1, 3, 2]) == 2
    assert obj.minMoves2([6, 6, 6, 6, 6, 6, 6, 7, 7]) == 2
