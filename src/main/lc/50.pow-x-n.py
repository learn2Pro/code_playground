#
# @lc app=leetcode id=50 lang=python3
#
# [50] Pow(x, n)
#

# @lc code=start
class Solution:
    def myPow(self, x: float, n: int) -> float:
        # return x**n
        if n == 0:
            return 1.0
        if n < 0:
            return 1/self.myPow(x, -n)
        if n % 2 == 1:
            return x*(self.myPow(x*x, n//2))
        else:
            return self.myPow(x*x, n//2)


# @lc code=end
if __name__ == "__main__":
    s = Solution()
    assert s.myPow(2., -2) == 0.25
