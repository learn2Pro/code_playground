from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def maximumGap(self, nums: List[int]) -> int:
        if len(nums) < 2:
            return 0
        _max, _min = max(nums), min(nums)
        if _max == _min:
            return 0
        n = len(nums)
        # min, max
        d = max(1, (_max - _min) // (n - 1))
        bucket_size = (_max - _min) // d + 1
        buckets = [[-1, -1] for _ in range(bucket_size)]
        for num in nums:
            idx = (num - _min) // d
            if (buckets[idx][0] == -1):
                buckets[idx][0] = buckets[idx][1] = num
            else:
                buckets[idx][0] = min(buckets[idx][0], num)
                buckets[idx][1] = max(buckets[idx][1], num)
        ans, pre = 0, None
        for i in range(bucket_size):
            if buckets[i][0] == -1:
                continue
            if pre is not None:
                ans = max(ans, buckets[i][0] - buckets[pre][1])
            pre = i
        return ans
# leetcode submit region end(Prohibit modification and deletion)
