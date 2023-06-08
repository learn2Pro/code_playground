from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def hIndex(self, citations: List[int]) -> int:
        n = len(citations)
        l, r = 0, n
        while l < r:
            mid = (l + r) // 2
            if citations[mid] < n - mid:
                l = mid + 1
            else:
                r = mid
        return n - l
# leetcode submit region end(Prohibit modification and deletion)
