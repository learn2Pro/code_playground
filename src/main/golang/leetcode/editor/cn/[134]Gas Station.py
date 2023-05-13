from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def canCompleteCircuit(self, gas: List[int], cost: List[int]) -> int:
        n = len(gas)
        spare, minimal = 0, float('inf')
        ans = 0
        for i in range(n):
            spare += gas[i] - cost[i]
            if spare < minimal:
                minimal = spare
                ans = i
        return -1 if spare < 0 else (ans + 1) % n

    # leetcode submit region end(Prohibit modification and deletion)
