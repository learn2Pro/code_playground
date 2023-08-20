from typing import List
# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def maxSumSubmatrix(self, matrix: List[List[int]], k: int) -> int:
        def maxSumSubarray(arr, k):
            maxSum = float('-inf')
            prefix = 0
            prefixs = [float('inf')]
            for num in arr:
                bisect.insort(prefixs, prefix)
                prefix += num
                idx = bisect.bisect_left(prefixs, prefix - k)
                maxSum = max(maxSum, prefix - prefixs[idx])
            return maxSum

        m, n = len(matrix), len(matrix[0])
        res = float('-inf')
        for i in range(m):
            arr = [0] * n
            for j in range(i, m):
                for c in range(n):
                    arr[c] += matrix[j][c]
                res = max(res, maxSumSubarray(arr, k))
        return res
# leetcode submit region end(Prohibit modification and deletion)
