# 791. Custom Sort String
import collections


class _791_Solution:
    # normal sort
    def customSortString(self, S: str, T: str) -> str:
        dict = [27] * 26
        for i, c in enumerate(S):
            dict[ord(c) - ord('a')] = i
        return ''.join(sorted(T, key=lambda unit: dict[ord(unit) - ord('a')]))

    # use bucket sort
    def customSortString(self, S: str, T: str) -> str:
        counter = collections.Counter(T)
        ans = []
        for c in S:
            ans.append(c * counter[c])
            counter[c] = 0
        for k, v in counter.items():
            ans.append(k * v)
        return ''.join(ans)
