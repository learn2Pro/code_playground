from typing import List
# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def generate(self, numRows: int) -> List[List[int]]:
        ans = [[1]]
        for i in range(1, numRows):
            ans.append([1] + [ans[-1][j] + ans[-1][j + 1] for j in range(i - 1)] + [1])
        return ans
# leetcode submit region end(Prohibit modification and deletion)
