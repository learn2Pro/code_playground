# 698. Partition to K Equal Sum Subsets
from typing import List

'''
[4,3,2,3,5,2,1]
4
[4,3,2,3,5,2,1]
2
[4,4]
2
[4,4]
1
[1,2,3,4,5,6]
4
[1,2,3,4,5,6]
6
[4,15,1,1,1,1,3,11,1,10]
3
[9,10,1,7,2,7,1,1,1,3]
3
'''


class _698_Solution:
    # use dfs version0
    def canPartitionKSubsets(self, nums: List[int], k: int) -> bool:
        if not nums: return True
        nums.sort(reverse=True)
        acc, n = sum(nums), len(nums)
        if acc % k != 0: return False
        target = [acc // k] * k

        def dfs(pos: int) -> bool:
            if pos == len(nums): return True
            for i in range(k):
                if target[i] < nums[pos]: continue
                target[i] -= nums[pos]
                if dfs(pos + 1): return True
                target[i] += nums[pos]
            return False

        return dfs(0)

    # use dfs version1
    def canPartitionKSubsets(self, nums: List[int], k: int) -> bool:
        if not nums: return True
        nums.sort(reverse=True)
        acc, n = sum(nums), len(nums)
        if acc % k != 0: return False
        if nums[0] > acc // k:  # 有超过目标的元素
            return False
        visited = set()

        def dfs(remain: int, index: int, partial: int) -> bool:
            if partial == acc // k:
                return dfs(remain - 1, 0, 0)
            if remain == 1:
                return True
            for i in range(index, n):
                if i not in visited and partial + nums[i] <= acc // k:
                    visited.add(i)
                    if (dfs(remain, i + 1, partial + nums[i])): return True
                    visited.remove(i)
            return False

        return dfs(k, 0, 0)


if __name__ == '__main__':
    obj = _698_Solution()
    assert obj.canPartitionKSubsets([9, 10, 1, 7, 2, 7, 1, 1, 1, 3], 3)
    assert obj.canPartitionKSubsets([4, 15, 1, 1, 1, 1, 3, 11, 1, 10], 3)
    assert obj.canPartitionKSubsets([4, 3, 2, 3, 5, 2, 1], 4)
