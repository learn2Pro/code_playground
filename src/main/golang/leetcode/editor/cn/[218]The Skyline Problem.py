from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:

    def getSkyline(self, buildings: List[List[int]]) -> List[List[int]]:
        import heapq
        ans = []
        for l, r, h in buildings:
            ans.append((l, -h))
            ans.append((r, h))
        ans.sort()
        heap = [0]
        res = [[0, 0]]
        for x, h in ans:
            # print(x, h)
            if h < 0:
                heapq.heappush(heap, h)
                # print("h<0", heap)
            else:
                heap.remove(-h)
                heapq.heapify(heap)
                # print("h>0", heap)
            # print("before", res)
            if res[-1][1] != -heap[0]:
                res.append([x, -heap[0]])
            # print("after", res)
        return res[1:]
# leetcode submit region end(Prohibit modification and deletion)
