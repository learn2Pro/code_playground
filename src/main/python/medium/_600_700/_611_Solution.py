# 611. Valid Triangle Number
import bisect
from typing import List


class _611_Solution:
    def triangleNumber(self, nums: List[int]) -> int:
        if len(nums) < 3:
            return 0
        nums.sort()
        size, ans = len(nums), 0
        for i in range(size - 2):
            for j in range(i + 1, size - 1):
                target = nums[i] + nums[j]
                index = bisect.bisect_left(nums, target, j + 1)
                ans += index - j - 1
        return ans

    def triangleNumber(self, nums: List[int]) -> int:
        if len(nums) < 3:
            return 0
        nums.sort()
        size, ans = len(nums), 0
        for i in range(size - 2):
            if nums[i] == 0: continue
            k = i + 2
            for j in range(i + 1, size - 1):
                if nums[j] == 0: continue
                target = nums[i] + nums[j]
                while k < size and target > nums[k]: k += 1
                ans += k - j - 1
        return ans

    # use two sum
    def triangleNumber(self, nums: List[int]) -> int:
        if len(nums) < 3:
            return 0
        nums.sort()
        size, ans = len(nums), 0
        for i in range(2, size):
            s, e = 0, i - 1
            while s < e:
                if nums[s] + nums[e] > nums[i]:
                    ans += e - s
                    e -= 1
                else:
                    s += 1
        return ans


'''
[2,2,3,4]
[2,2,3]
[]
[2]
[1,2]
[1,1,2]
[10,9,8,7,100,2,3,4,112,212,434,656]
[0,0,0]
[0]
[0,0]
[0,1,2,3]
[0,1,2,2,3,4]
[0,9,7]
'''
if __name__ == "__main__":
    obj = _611_Solution()
    assert obj.triangleNumber([0, 9, 7]) == 0
    assert obj.triangleNumber([2, 2, 3, 4]) == 3
