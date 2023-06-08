from typing import List
# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def majorityElement(self, nums: List[int]) -> List[int]:
        if nums is None or len(nums) == 0:
            return []
        n1 = n2 = None
        c1 = c2 = 0
        for num in nums:
            if n1 == num:
                c1 += 1
            elif n2 == num:
                c2 += 1
            elif c1 == 0:
                n1 = num
                c1 = 1
            elif c2 == 0:
                n2 = num
                c2 = 1
            else:
                c1 -= 1
                c2 -= 1
        c1 = c2 = 0
        for num in nums:
            if num == n1:
                c1 += 1
            elif num == n2:
                c2 += 1
        ans = []
        if c1 > len(nums) // 3:
            ans.append(n1)
        if c2 > len(nums) // 3:
            ans.append(n2)
        return ans
# leetcode submit region end(Prohibit modification and deletion)
