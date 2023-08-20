from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
        envelopes.sort(key=lambda x: (x[0], -x[1]))
        height = [x[1] for x in envelopes]

        def lengthOfLIS(nums):
            piles, n = 0, len(nums)
            top = [0] * n
            for i in range(n):
                poker = nums[i]
                left, right = 0, piles
                while left < right:
                    mid = (left + right) // 2
                    if top[mid] < poker:
                        left = mid + 1
                    else:
                        right = mid
                if left == piles:
                    piles += 1
                top[left] = poker

            return piles

        return lengthOfLIS(height)
# leetcode submit region end(Prohibit modification and deletion)
