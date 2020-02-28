# 187. Repeated DNA Sequences
from typing import List


class _187_Solution:
    def findRepeatedDnaSequences(self, s: str) -> List[str]:
        n = len(s)
        if n < 10: return []
        ans, visited = set(), set()
        for i in range(n - 9):
            if s[i:i + 10] in visited:
                ans.add(s[i:i + 10])
            visited.add(s[i:i + 10])
        return list(ans)


if __name__ == '__main__':
    instance = _187_Solution
    assert instance.findRepeatedDnaSequences(instance, "AAAAAAAAAAA") == ["AAAAAAAAAA"]
