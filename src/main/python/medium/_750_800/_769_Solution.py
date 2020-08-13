# 769. Max Chunks To Make Sorted
from typing import List

'''
[4,3,2,1,0]
[1,0,2,3,4]
[2,1,0,4,3]
[0]
[0,1,2,3,4,5]
[5,3,1,0,2,4]
[4,3,2,1,0,5]
[1,4,3,6,0,7,8,2,5]
[6,7,0,1,2,3,4,5,8]
[5,3,2,0,4,1,7,6,8]
'''


class _769_Solution:
    def maxChunksToSorted(self, arr: List[int]) -> int:
        N = len(arr)
        chunk_min, chunk_max, previous, chunk = N, -1, -1, 0
        for i, item in enumerate(arr):
            chunk_max, chunk_min = max(chunk_max, item), min(item, chunk_min)
            if previous + 1 == chunk_min and i == chunk_max:
                chunk += 1
                previous, chunk_min = chunk_max, N
        return max(chunk, 1)

    # simplify
    def maxChunksToSorted(self, arr: List[int]) -> int:
        chunk_max, ans = -1, 0
        for i, item in enumerate(arr):
            chunk_max = max(chunk_max, item)
            if i == chunk_max: ans += 1
        return ans
