# 503. Next Greater Element II
from typing import List


class _503_Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        stack, n = [], len(nums)
        ans = [-1] * n
        for iter in range(2 * n):
            i, num = iter % n, nums[iter % n]
            while stack and num > nums[stack[-1]]:
                ans[stack.pop()] = num
            stack.append(i)
        return ans


'''
[1,2,1]
[]
[1,2,3,4,5,6,7]
[7,6,5,4,3,2,1]
[1,3,2,7,4,5,1,2,3]
[1,1,1,1,1,1]
[2,1,2,1,2,1,2,1]
[3,3,3,3,3,10,1,2,5,6,2,1]
'''
if __name__ == '__main__':
    tar = _503_Solution()
    assert tar.nextGreaterElements([3, 3, 3, 3, 3, 10, 1, 2, 5, 6, 2, 1]) == [10, 10, 10, 10, 10, -1, 2, 5, 6, 10, 3, 3]
    assert tar.nextGreaterElements([1, 2, 1]) == [2, -1, 2]
