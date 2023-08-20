from typing import List
# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def intersection(self, nums1: List[int], nums2: List[int]) -> List[int]:
        nums1, nums2 = set(nums1), set(nums2)
        return [x for x in nums1 if x in nums2]
# leetcode submit region end(Prohibit modification and deletion)
