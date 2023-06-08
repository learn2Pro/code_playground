# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def isAdditiveNumber(self, num: str) -> bool:
        def dfs(i, j, k):
            if k == len(num):
                return True
            # no leading zero
            if (num[i] == '0' and j - i > 1) or (num[j] == '0' and k - j > 1):
                return False
            # the next number is the sum of the previous two
            sum = str(int(num[i:j]) + int(num[j:k]))
            # branch pruning if only starts with sum
            if num[k:].startswith(sum):
                return dfs(j, k, k + len(sum))
            return False

        n = len(num)
        for i in range(1, n // 2 + 1):
            for j in range(i + 1, n):
                if dfs(0, i, j):
                    return True
        return False
# leetcode submit region end(Prohibit modification and deletion)
