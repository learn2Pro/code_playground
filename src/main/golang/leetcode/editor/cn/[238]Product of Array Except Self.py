from typing import List
# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        n = len(nums)
        ans = [1] * n
        for i in range(1, n):
            ans[i] = ans[i - 1] * nums[i - 1]
        r = 1
        print(ans)
        for i in range(n - 1, -1, -1):
            ans[i] *= r
            r *= nums[i]
        print(ans)
        return ans
# leetcode submit region end(Prohibit modification and deletion)
