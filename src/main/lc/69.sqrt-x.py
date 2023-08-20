#
# @lc app=leetcode id=69 lang=python3
#
# [69] Sqrt(x)
#

# @lc code=start
class Solution:
    def mySqrt(self, x: int) -> int:
        if x <= 1:
            return x
        l, r = 0, x//2
        while l <= r:
            mid = (l+r)//2
            if mid**2 <= x and (mid+1)**2 > x:
                return mid
            elif mid**2 < x:
                l = mid+1
            else:
                r = mid-1


# @lc code=end
if __name__ == "__main__":
    s = Solution()
    print(s.mySqrt(0))
    print(s.mySqrt(1))
    print(s.mySqrt(2))
    print(s.mySqrt(3))
    print(s.mySqrt(4))
    print(s.mySqrt(10))
    print(s.mySqrt(20))
    print(s.mySqrt(100))
