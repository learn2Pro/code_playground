# 152. Maximum Product Subarray
from typing import List


class _152_Solution:
    # def maxProduct(self, nums: List[int]) -> int:
    #     if not nums: return 0
    #     product = -0xffffffff
    #     n = len(nums)
    #     for i in range(n):
    #         p = nums[i]
    #         product = max(product, p)
    #         for j in range(i + 1, n):
    #             p *= nums[j]
    #             product = max(product, p)
    #     return product

    # dynamic prog
    def maxProduct(self, nums: List[int]) -> int:
        if not nums: return 0
        n = len(nums)
        minimal = maximal = product = nums[0]
        for i in range(1, n):
            minimal, maximal = min(minimal * nums[i], maximal * nums[i], nums[i]), max(minimal * nums[i],
                                                                                       maximal * nums[i], nums[i])
            product = max(maximal, product)
        return product


if __name__ == '__main__':
    instance = _152_Solution
    assert instance.maxProduct(instance, [2, 3, -2, 4]) == 6
