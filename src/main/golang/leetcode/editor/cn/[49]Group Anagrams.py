import collections
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        dic = collections.defaultdict(list)
        for str in strs:
            key = "".join(sorted(str))
            dic[key].append(str)
        return list(dic.values())
        # def cmp(str1: str, str2: str):
        #     if len(str1) != len(str2):
        #         return False
        #     dic = [0] * 26
        #     for c in str1:
        #         dic[ord(c) - ord('a')] += 1
        #     for c in str2:
        #         dic[ord(c) - ord('a')] -= 1
        #     for i in range(26):
        #         if dic[i] != 0:
        #             return False
        #     return True
        #
        # ans = []
        # n = len(strs)
        # used = [False] * n
        # for i in range(n):
        #     if used[i]:
        #         continue
        #     partial = [strs[i]]
        #     used[i] = True
        #     for j in range(i + 1, n):
        #         if used[j]:
        #             continue
        #         if cmp(strs[i], strs[j]):
        #             used[j] = True
        #             partial.append(strs[j])
        #     ans.append(partial)
        # return ans

# leetcode submit region end(Prohibit modification and deletion)
