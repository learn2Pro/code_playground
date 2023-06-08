# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def wordPattern(self, pattern: str, s: str) -> bool:
        words = s.split(" ")
        if len(words) != len(pattern):
            return False
        dic, dic2 = {}, {}
        for i, c in enumerate(pattern):
            if c in dic:
                if (words[i] != dic[c]):
                    return False
            if words[i] in dic2:
                if (c != dic2[words[i]]):
                    return False
            dic[c] = words[i]
            dic2[words[i]] = c
        return True
# leetcode submit region end(Prohibit modification and deletion)
