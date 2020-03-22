# 347. Top K Frequent Elements
from typing import List

'''
[1,1,1,2,2,3]
2
[]
1
[1,2]
1
[1,1,2,2]
1
'''


class _347_Solution:
    # use bucket sort
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        if not nums: return None
        dict = {}
        for num in nums:
            dict[num] = dict.get(num, 0) + 1
        bucket = [[] for i in range(len(nums) + 1)]
        for left, value in dict.items():
            if not bucket[value]:
                bucket[value] = [left]
            else:
                bucket[value].append(left)
        ans = []
        for lst in reversed(bucket):
            ans += lst
        return ans[:k]

    # def topKFrequent(self, nums: List[int], k: int) -> List[int]:
    #     if not nums: return None
    #     dict = {}
    #     for num in nums:
    #         dict[num] = dict.get(num, 0) + 1
    #     ans, i = [], 0
    #     for item, _ in sorted(dict.items(), key=lambda element: -element[1]):
    #         if i >= k: break
    #         ans.append(item)
    #         i += 1
    #     return ans


if __name__ == '__main__':
    instance = _347_Solution()
    assert instance.topKFrequent([1, 1, 1, 2, 2, 3], 2) == [1, 2]
    assert instance.topKFrequent([1, 1, 1, 2, 2, 3], 4) == [1, 2, 3]
    assert instance.topKFrequent([1], 1) == [1]
