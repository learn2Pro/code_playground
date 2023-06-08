from typing import List
# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def containsNearbyAlmostDuplicate(self, nums: List[int], indexDiff: int, valueDiff: int) -> bool:
        if indexDiff < 0 or valueDiff < 0:
            return False
        buckets = {}
        for i, num in enumerate(nums):
            bucket = num // (valueDiff + 1)
            if bucket in buckets:
                return True
            if bucket - 1 in buckets and abs(buckets[bucket - 1] - num) <= valueDiff:
                return True
            if bucket + 1 in buckets and abs(buckets[bucket + 1] - num) <= valueDiff:
                return True
            buckets[bucket] = num
            if i >= indexDiff:
                del buckets[nums[i - indexDiff] // (valueDiff + 1)]
        return False
# leetcode submit region end(Prohibit modification and deletion)
