# 373. Find K Pairs with Smallest Sums
import heapq
from typing import List

'''
[1,7,11]
[2,4,6]
3
[1,1,2]
[1,2,3]
2
[1,2]
[3]
4
[]
[1]
2
'''


class _373_Solution:
    def kSmallestPairs(self, nums1: List[int], nums2: List[int], k: int) -> List[List[int]]:
        if not nums1 or not nums2: return []
        heap, ans = [(nums1[0] + nums2[0], 0, 0)], []
        n, m = len(nums1), len(nums2)
        k = min(k, n * m)
        visited = {(0, 0)}
        for _ in range(k):
            _, x, y = heapq.heappop(heap)
            ans.append([nums1[x], nums2[y]])
            if x + 1 < n and (x + 1, y) not in visited:
                heapq.heappush(heap, (nums1[x + 1] + nums2[y], x + 1, y))
                visited.add((x + 1, y))
            if y + 1 < m and (x, y + 1) not in visited:
                heapq.heappush(heap, (nums1[x] + nums2[y + 1], x, y + 1))
                visited.add((x, y + 1))
        return ans

    # full scan
    # def kSmallestPairs(self, nums1: List[int], nums2: List[int], k: int) -> List[List[int]]:
    #     if not nums1 or not nums2: return []
    #     heap, ans = [], []
    #     n, m = len(nums1), len(nums2)
    #     k = min(k, n * m)
    #     for i in range(min(n, k)):
    #         for j in range(min(m, k)):
    #             heapq.heappush(heap, (nums1[i] + nums2[j], [nums1[i], nums2[j]]))
    #     for _ in range(k):
    #         ans.append(heapq.heappop(heap)[1])
    #     return ans


if __name__ == '__main__':
    obj = _373_Solution()
    assert obj.kSmallestPairs([1, 1, 2], [1, 2, 3], 10) == [[1, 1], [1, 1], [2, 1], [1, 2], [1, 2], [2, 2], [1, 3],
                                                            [1, 3], [2, 3]]
