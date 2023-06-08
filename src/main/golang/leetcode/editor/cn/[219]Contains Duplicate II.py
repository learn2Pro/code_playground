import collections
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def containsNearbyDuplicate(self, nums: List[int], k: int) -> bool:
        locations = collections.defaultdict(int)
        for i, num in enumerate(nums):
            if num in locations and i - locations[num] <= k:
                return True
            locations[num] = i
        return False
# leetcode submit region end(Prohibit modification and deletion)
