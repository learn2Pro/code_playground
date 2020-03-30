from typing import List

'''
[[1,5,9],[10,11,13],[12,13,15]]
8
[[1,5,9],[10,11,13],[12,13,15]]
1
[[1,5,9],[10,11,13],[12,13,15]]
2
[[1,5,9],[10,11,13],[12,13,15]]
3
[[1,5,9],[10,11,13],[12,13,15]]
4
[[1,5,9],[10,11,13],[12,13,15]]
5
[[1,5,9],[10,11,13],[12,13,15]]
6
[[1,5,9],[10,11,13],[12,13,15]]
7
[[1,5,9],[10,11,13],[12,13,15]]
9
[[1],[10],[12]]
2
[[1]]
1
[[1,2,3]]
3
'''
class _378_Solution:
    # use binary search
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        def lessCount(mid: int, smaller: int, larger: int) -> (int, int, int):
            count, n = 0, len(matrix)
            row, col = n - 1, 0
            while row >= 0 and col < len(matrix[0]):
                if matrix[row][col] > mid:
                    larger = min(larger, matrix[row][col])
                    row -= 1
                else:
                    smaller = max(smaller, matrix[row][col])
                    count += row + 1
                    col += 1
            return count, smaller, larger

        m, n = len(matrix), len(matrix[0])
        start, end = matrix[0][0], matrix[-1][-1]
        k = min(k, m * n)
        while start < end:
            mid = (start + end) >> 1
            size, smaller, larger = lessCount(mid, matrix[0][0], matrix[-1][-1])
            if size < k:
                start = larger
            else:
                end = smaller
        return end
    # use heap
    # def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
    #     if not matrix or not matrix[0]: return -1
    #     m, n = len(matrix), len(matrix[0])
    #     heap = [(matrix[0][0], 0, 0)]
    #     visited = {(0, 0)}
    #     size, ans = 0, 0
    #     while size < min(m * n, k):
    #         ans, x, y = heapq.heappop(heap)
    #         size += 1
    #         if x + 1 < m and (x + 1, y) not in visited:
    #             heapq.heappush(heap, (matrix[x + 1][y], x + 1, y))
    #             visited.add((x + 1, y))
    #         if y + 1 < n and (x, y + 1) not in visited:
    #             heapq.heappush(heap, (matrix[x][y + 1], x, y + 1))
    #             visited.add((x, y + 1))
    #     return ans


if __name__ == '__main__':
    obj = _378_Solution()
    assert obj.kthSmallest([[1, 5, 9], [10, 11, 13], [12, 13, 15]], 1) == 1
    assert obj.kthSmallest([[1, 5, 9], [10, 11, 13], [12, 13, 15]], 8) == 13
