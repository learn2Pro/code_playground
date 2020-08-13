# 763. Partition Labels
import collections
from typing import List


class _763_Solution:
    def partitionLabels(self, S: str) -> List[int]:
        lst = [-1] * 26
        for i in range(len(S)):
            lst[ord(S[i]) - ord('a')] = i
        pointer, ans, curr = 0, [], -1
        while pointer < len(S):
            right = pointer
            while pointer <= right:
                right = max(right, lst[ord(S[pointer]) - ord('a')])
                pointer += 1
            ans.append(right - curr)
            curr = right
        return ans


if __name__ == '__main__':
    tar = _763_Solution()
    assert tar.partitionLabels("ababcbacadefegdehijhklij") == [9, 7, 8]
