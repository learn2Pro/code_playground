from typing import List
# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def findRepeatedDnaSequences(self, s: str) -> List[str]:
        if len(s) <= 10:
            return []
        res = []
        dic = {}
        for i in range(len(s) - 9):
            if s[i:i+10] not in dic:
                dic[s[i:i+10]] = 1
            else:
                dic[s[i:i+10]] += 1
                if dic[s[i:i+10]] == 2:
                    res.append(s[i:i+10])
        return res
# leetcode submit region end(Prohibit modification and deletion)
