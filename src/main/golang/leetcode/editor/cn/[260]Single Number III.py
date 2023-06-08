from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def singleNumber(self, nums: List[int]) -> List[int]:
        all = 0
        for num in nums:
            all ^= num
        last_bit = all & -all
        fst = snd = 0
        for num in nums:
            if last_bit & num:
                fst ^= num
            else:
                snd ^= num
        return [fst, snd]
# leetcode submit region end(Prohibit modification and deletion)
