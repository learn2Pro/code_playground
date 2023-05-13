from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def getRow(self, rowIndex: int) -> List[int]:
        ans = [1]
        for j in range(rowIndex):
            ans = [1] + [ans[i] + ans[i + 1] for i in range(len(ans) - 1)] + [1]
        return ans
# leetcode submit region end(Prohibit modification and deletion)
