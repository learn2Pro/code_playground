# 456. 132 Pattern
from typing import List

'''
[1,2,3,4]
[1,3,-1,2]
[1,3,-1,4,3]
[1]
[2]
[1,3]
[3,1]
[1,3,2]
[1,1,1,3,2]
[1,-1,-1,3,-1,-1,2]
'''


class _456_Solution:
    # reversed
    def find132pattern(self, nums: List[int]) -> bool:
        if not nums: return False
        st, s3 = [], -0xffffffff
        for i in reversed(range(len(nums))):
            num = nums[i]
            if num < s3:
                return True
            else:
                while len(st) > 0 and num > st[-1]: s3 = st.pop()
            st.append(num)
        return False

    # order
    # def find132pattern(self, nums: List[int]) -> bool:
    #     if not nums: return False
    #     st, s1 = [], 0xffffffff
    #     for num in nums:
    #         if num > s1 and num < st[-1]:
    #             return True
    #         else:
    #             while len(st) > 0 and num >= st[-1]: s1 = min(s1, st.pop())
    #         st.append(num)
    #     return False


if __name__ == '__main__':
    obj = _456_Solution()
    assert obj.find132pattern([1, -1, -1, 3, -1, -1, 2]) == True
    assert obj.find132pattern([-2, 1, 1]) == False
    assert obj.find132pattern([8, 10, 4, 6, 5]) == True
    assert obj.find132pattern([1, 1, 1, 1, 1, 1, 1, 1, 1]) == False
    assert obj.find132pattern([1, 3, -1, 2]) == True
    assert obj.find132pattern([1, 3, 2]) == True
