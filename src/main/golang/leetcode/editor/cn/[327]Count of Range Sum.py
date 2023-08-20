from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def countRangeSum(self, nums: List[int], lower: int, upper: int) -> int:
        import bisect
        prefix = [0]
        for num in nums:
            prefix.append(prefix[-1] + num)
        ans = 0
        sorted_prefix = []
        for num in prefix:
            l = bisect.bisect_left(sorted_prefix, num - upper)
            r = bisect.bisect_right(sorted_prefix, num - lower)
            ans += r - l
            bisect.insort(sorted_prefix, num)
        return ans
# leetcode submit region end(Prohibit modification and deletion)
