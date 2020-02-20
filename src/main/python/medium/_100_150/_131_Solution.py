# 131. Palindrome Partitioning
from typing import List

'''
"aab"
"a"
""
"aa"
"abc"
'''
class _131_Solution:
    def partition(self, s: str) -> List[List[str]]:
        def check(s: str) -> bool:
            return s == s[::-1]

        ans = []
        n = len(s)

        def track(previous: [], index: int) -> None:
            if index >= n:
                ans.append(previous.copy())
                return
            for i in range(index + 1, n + 1):
                if not check(s[index:i]): continue
                previous.append(s[index:i])
                track(previous, i)
                previous.pop()

        track([], 0)
        return ans


if __name__ == '__main__':
    instance = _131_Solution
    assert instance.partition(instance, "aab") == [["a", "a", "b"], ["aa", "b"]]
