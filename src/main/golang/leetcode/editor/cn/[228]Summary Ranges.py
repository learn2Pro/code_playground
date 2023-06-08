from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def summaryRanges(self, nums: List[int]) -> List[str]:
        if nums is None or len(nums) == 0:
            return []
        ans = []
        start = end = nums[0]
        for i in range(1, len(nums)):
            num = nums[i]
            if num == end + 1:
                end = num
            else:
                if start == end:
                    ans.append(str(start))
                else:
                    ans.append(f"{start}->{end}")
                start = end = num
        ans.append(f"{start}->{end}" if start != end else str(start))
        return ans
# leetcode submit region end(Prohibit modification and deletion)
