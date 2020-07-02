# 556. Next Greater Element III
from bisect import bisect


class _556_Solution:
    def nextGreaterElement(self, n: int) -> int:
        numOfStr = list(str(n))
        size = len(numOfStr)
        i, j = size - 2, size - 1
        while i >= 0 and numOfStr[i] >= numOfStr[i + 1]:
            i -= 1
        if i == -1: return -1
        while numOfStr[j] <= numOfStr[i]:
            j -= 1
        numOfStr[i], numOfStr[j] = numOfStr[j], numOfStr[i]
        ans = int("".join(numOfStr[:i + 1] + numOfStr[i + 1:][::-1]))
        if ans > 0x7fffffff or ans == n:
            return -1
        return ans

    def nextGreaterElement(self, n: int) -> int:
        nums = list(str(n))
        if len(nums) <= 1:
            return -1
        stack = [nums[-1]]
        for i in range(len(nums) - 1)[::-1]:
            if nums[i] >= stack[-1]:
                stack.append(nums[i])
            else:
                ind = bisect(stack, nums[i])
                temp, stack[ind] = stack[ind], nums[i]
                ans = int(''.join(nums[:i] + [temp] + stack))
                if ans > 0x7fffffff: return -1
                return ans
        return -1


'''
12
123
1234
4321
4312
8974
2147483647
'''
if __name__ == '__main__':
    obj = _556_Solution()
    assert obj.nextGreaterElement(321) == -1
    assert obj.nextGreaterElement(432189) == 432198
    assert obj.nextGreaterElement(8974) == 9478
    assert obj.nextGreaterElement(123) == 132
    assert obj.nextGreaterElement(12) == 21
    assert obj.nextGreaterElement(21) == -1
