# 451. Sort Characters By Frequency
from collections import Counter


class _451_Solution:
    # use counter
    def frequencySort(self, s: str) -> str:
        counter = Counter(s)
        ans = ""
        for k, v in counter.most_common():
            ans += k * v
        return ans

    # use bucket sort
    def frequencySort(self, s: str) -> str:
        counter = Counter(s)
        bucket = [None] * (len(s) + 1)
        for k, v in counter.items():
            if bucket[v]:
                bucket[v].append(k)
            else:
                bucket[v] = [k]
        ans = ""
        for i in reversed(range(len(s) + 1)):
            lst = bucket[i]
            if not lst: continue
            for c in lst:
                ans += i * c
        return ans


if __name__ == '__main__':
    obj = _451_Solution()
    assert obj.frequencySort("eeeee") == "eeeee"
    assert obj.frequencySort("loveleetcode") == "eeeeoollvtdc"
    assert obj.frequencySort("tree") == "eetr"
