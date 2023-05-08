from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def fourSum(self, nums: List[int], target: int) -> List[List[int]]:
        nums.sort()
        n = len(nums)
        ans = []
        for i in range(n - 3):
            if i > 0 and nums[i] == nums[i - 1]:
                continue
            for j in range(i + 1, n - 2):
                if j != i + 1 and nums[j] == nums[j - 1]:
                    continue
                l, r = j + 1, n - 1
                while l < r:
                    left, right = nums[l], nums[r]
                    sum = nums[i] + nums[j] + left + right
                    if sum == target:
                        ans.append([nums[i], nums[j], nums[l], nums[r]])
                        while l < r and nums[l] == left:
                            l += 1
                        while l < r and nums[r] == right:
                            r -= 1
                    elif sum < target:
                        while l < r and nums[l] == left:
                            l += 1
                    else:
                        while l < r and nums[r] == right:
                            r -= 1
        return ans
# leetcode submit region end(Prohibit modification and deletion)
