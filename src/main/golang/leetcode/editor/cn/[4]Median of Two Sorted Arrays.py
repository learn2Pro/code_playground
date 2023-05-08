from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
# import numpy as np
# class Solution:
#     def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
#         return np.median(nums1+nums2)

class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        if len(nums1) > len(nums2):
            return self.findMedianSortedArrays(nums2, nums1)
        m, n = len(nums1), len(nums2)
        inf = 2 ** 40
        left, right = 0, m
        median1, median2 = 0, 0
        while left <= right:
            i = (left + right) // 2
            j = (m + n + 1) // 2 - i
            nums_i_1 = (-inf if i == 0 else nums1[i - 1])
            nums_i = (inf if i == m else nums1[i])
            nums_j_1 = (-inf if j == 0 else nums2[j - 1])
            nums_j = (inf if j == n else nums2[j])
            if nums_i_1 <= nums_j:
                median1, median2 = max(nums_i_1, nums_j_1), min(nums_i, nums_j)
                left = i + 1
            else:
                right = i - 1
        return (median1 + median2) / 2 if (m + n) % 2 == 0 else median1

# leetcode submit region end(Prohibit modification and deletion)
