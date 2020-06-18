# 560. Subarray Sum Equals K
from typing import List


class _560_Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        total, visited = 0, {0: 1}
        ans = 0
        for num in nums:
            total += num
            if total - k in visited: ans += visited[total - k]
            visited[total] = visited.get(total, 0) + 1
        return ans

'''
[1,1,1]
2
[0]
0
[1,-1]
0
[0,0]
0
[1,0,0,1]
0
[1,2,3,4,434,3,43,2,12,121,-212,21,-767,554,-454,-76,98]
101
'''
if __name__ == '__main__':
    obj = _560_Solution()
    assert obj.subarraySum([1, 0, 0, 1], 0) == 3
    assert obj.subarraySum([0, 0], 0) == 3
    assert obj.subarraySum([1, 1, 1], 2) == 2
