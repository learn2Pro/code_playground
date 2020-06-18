from typing import List

# 525. Contiguous Array
class _525_Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        diff = {0: -1}
        counter, maximal = 0, 0
        for i, num in enumerate(nums):
            counter += 1 if num == 1 else -1
            if counter in diff:
                maximal = max(maximal, i - diff[counter])
            else:
                diff[counter] = i
        return maximal


if __name__ == '__main__':
    obj = _525_Solution()
    assert obj.findMaxLength([1, 1, 0]) == 2
