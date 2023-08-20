import collections
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        c1, c2 = collections.Counter(nums1), collections.Counter(nums2)
        return list((c1 & c2).elements())
# leetcode submit region end(Prohibit modification and deletion)
