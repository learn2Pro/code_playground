# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def getPermutation(self, n: int, k: int) -> str:
        ans = []
        nums = [i for i in range(1, n + 1)]
        k -= 1
        factorial = [1]
        for i in range(1, n):
            factorial.append(factorial[-1] * i)
        for i in reversed(range(n)):
            idx = k // factorial[i]
            ans.append(nums[idx])
            nums.pop(idx)
            k %= factorial[i]
        return "".join([str(i) for i in ans])
    # ans = ""
    # nums = [i for i in range(1, n + 1)]
    # k -= 1
    # factorial = [1] * n
    # for i in range(1, n):
    #     factorial[i] = factorial[i - 1] * i
    # for i in range(n - 1, -1, -1):
    #     idx = k // factorial[i]
    #     ans += str(nums[idx])
    #     nums.pop(idx)
    #     k %= factorial[i]
    # return ans
# leetcode submit region end(Prohibit modification and deletion)
