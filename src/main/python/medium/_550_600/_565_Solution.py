# 565. Array Nesting
from typing import List


class _565_Solution:
    def arrayNesting(self, nums: List[int]) -> int:
        visited, size = set(), 0
        for s in nums:
            if s in visited: continue
            step = s
            last = len(visited)
            while step not in visited:
                visited.add(step)
                step = nums[step]
            size = max(size, len(visited) - last)
        return size

'''
[5,4,0,3,1,6,2]
[0,1,2]
[1,2,0]
[]
[10,9,5,4,1,2,0,3,7,6,8]
'''
if __name__ == '__main__':
    obj = _565_Solution()
    assert obj.arrayNesting([1, 2, 0]) == 3
    assert obj.arrayNesting([0, 1, 2]) == 1
