# 134. Gas Station
from typing import List

'''
gas  = [1,2,3,4,5]
cost = [3,4,5,1,2]
gas  = [2,3,4]
cost = [3,4,3]
'''


class _134_Solution:
    def canCompleteCircuit(self, gas: List[int], cost: List[int]) -> int:
        minSum, minIndex, sum = 0x7fffffff, -1, 0
        n = len(gas)
        for i in range(n):
            sum += gas[i] - cost[i]
            if sum < minSum:
                minSum = sum
                minIndex = i
        return -1 if sum < 0 else (minIndex + 1) % n


if __name__ == '__main__':
    instance = _134_Solution
    assert instance.canCompleteCircuit(instance, [1, 2, 3, 4, 5], [3, 4, 5, 1, 2]) == 3
    assert instance.canCompleteCircuit(instance, [2, 3, 4], [3, 4, 3]) == -1
