from typing import List
# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def grayCode(self, n: int) -> List[int]:
        res = [0]
        for i in range(n):
            res += [x + 2 ** i for x in res[::-1]]
        return res
# leetcode submit region end(Prohibit modification and deletion)
