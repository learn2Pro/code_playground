from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        """
        Do not return anything, modify nums1 in-place instead.
        """
        if not nums2:
            return
        i, j = m - 1, n - 1
        k = m + n - 1
        while k >= 0:
            if nums1[i] > nums2[j]:
                nums1[k] = nums1[i]
                i -= 1
                k -= 1
            elif nums2:
                nums1[k] = nums2[j]
                j -= 1
                k -= 1
            if i < 0:
                nums1[:k + 1] = nums2[:j + 1]
                break
            if j < 0:
                break


# leetcode submit region end(Prohibit modification and deletion)
if __name__ == '__main__':
    sol = Solution()
    sol.merge([1], 1, [], 0)
    sol.merge([0], 0, [1], 1)
