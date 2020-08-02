from typing import List


# 713. Subarray Product Less Than K
class _713_Solution:
    def numSubarrayProductLessThanK(self, nums: List[int], k: int) -> int:
        if not nums or k <= 1: return 0
        lo = hi = 0
        partial, ans = nums[0], 0
        while lo < len(nums):
            if partial < k and hi < len(nums) - 1:
                hi += 1
                partial *= nums[hi]
            else:
                ans += (hi - lo) + (1 if partial < k else 0)
                partial //= nums[lo]
                lo += 1

        return ans

    # more concise
    def numSubarrayProductLessThanK(self, nums: List[int], k: int) -> int:
        if not nums or k <= 1: return 0
        prod, left, ans = 1, 0, 0
        for right in range(len(nums)):
            prod *= nums[right]
            while prod >= k:
                prod //= nums[left]
                left += 1
            ans += right - left + 1
        return ans


'''
[10,5,2,6]
100
[999]
10
[1,2,3]
2
[1,10,33]
0
[281,789,1,10,2]
111111
[1,1,1,1,1,1,1,2,2,2,2,2,2]
1
[1,1,1,1,1,1]
1
[1,1,1,1,2,2,2,2]
2
[2,2,2,2,1,1,1,3,3,3,3]
3
[2,2,2,2,1,1,1,1,1,1,2,2,2,2,2]
4
[3,3,1,1,3,3,1,1,2,2,2]
2
[1,1,1,1,1,1,1,1,1]
10
[2,2,2,2,2,2,2]
1
[1,1,1,1]
1
[1]
2
'''
if __name__ == '__main__':
    obj = _713_Solution()
    assert obj.numSubarrayProductLessThanK([1, 1, 1, 1, 2, 2, 2, 2], 2) == 10
    assert obj.numSubarrayProductLessThanK([1, 2, 3], 2) == 1
    assert obj.numSubarrayProductLessThanK([1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2], 1) == 0
    assert obj.numSubarrayProductLessThanK([1, 10, 33], 0) == 0
    assert obj.numSubarrayProductLessThanK([10, 5, 2, 6], 100) == 8
