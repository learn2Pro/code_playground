# 692. Top K Frequent Words
import collections
import heapq
from typing import List


class _692_Solution:
    # use sort
    def topKFrequent(self, words: List[str], k: int) -> List[str]:
        counter = collections.Counter(words)
        unique = list(counter.keys())
        unique.sort(key=lambda x: (-counter[x], x))
        return unique[:k]

    def topKFrequent(self, words: List[str], k: int) -> List[str]:
        counter = collections.Counter(words)
        lst = [(-f, w) for w, f in counter.items()]
        heapq.heapify(lst)
        return [heapq.heappop(lst)[1] for _ in range(k)]


if __name__ == '__main__':
    obj = _692_Solution()
    assert obj.topKFrequent(["i", "love", "leetcode", "i", "love", "coding"], 3) == ["i", "love", "coding"]
