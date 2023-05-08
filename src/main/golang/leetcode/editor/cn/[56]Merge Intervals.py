from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        intervals.sort(key=lambda lst: lst[0])
        ans = [intervals[0]]
        n = len(intervals)
        for i in range(1, n):
            if intervals[i][0] <= ans[-1][1]:
                left = ans.pop()
                ans.append([left[0], max(left[1], intervals[i][1])])
            else:
                ans.append(intervals[i])
        return ans
# leetcode submit region end(Prohibit modification and deletion)
