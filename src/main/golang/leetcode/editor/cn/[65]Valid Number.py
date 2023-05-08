import re


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def isNumber(self, s: str) -> bool:
        return re.fullmatch(r'^[+-]?(\d+\.?|\.\d+)\d*([eE][+-]?\d+)?$', s.strip()) is not None
# leetcode submit region end(Prohibit modification and deletion)
