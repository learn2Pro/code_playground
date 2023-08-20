import collections
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        return [x[0] for x in collections.Counter(nums).most_common(k)]
# leetcode submit region end(Prohibit modification and deletion)
