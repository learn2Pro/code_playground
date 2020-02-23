# 139. Word Break
from typing import List


class _139_Solution:
    # bfs
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        queue = [s]
        visited = set()
        while queue:
            current = queue.pop(0)
            for word in wordDict:
                if word == current: return True
                if current.startswith(word):
                    suffix = current[len(word):]
                    if suffix not in visited:
                        queue.append(suffix)
                        visited.add(suffix)
        return False
    # dynamic prog
    # def wordBreak(self, s: str, wordDict: List[str]) -> bool:
    #     if not s: return False
    #     n = len(s)
    #     dict = set(wordDict)
    #     dp = [False] * (n + 1)
    #     dp[0] = True
    #     for i in range(1, n + 1):
    #         for j in range(i):
    #             if dp[j] and s[j:i] in dict:
    #                 dp[i] = True
    #                 break
    #     return dp[-1]


# def wordBreak(self, s: str, wordDict: List[str]) -> bool:
#     dict = set(wordDict)
#
#     def track(input: str) -> bool:
#         if input in dict: return True
#         for i in range(1, len(input) + 1):
#             if input[:i] in dict and track(input[i:]):
#                 return True
#         return False
#
#     return track(s)


if __name__ == '__main__':
    instance = _139_Solution
    assert instance.wordBreak(instance, "", []) == False
    assert instance.wordBreak(instance, "leetcode", ["leet", "code"]) == True
    assert instance.wordBreak(instance, "applepenapple", ["apple", "pen"]) == True
    assert instance.wordBreak(instance, "catsandog", ["cats", "dog", "sand", "and", "cat"]) == False
    assert instance.wordBreak(instance,
                              "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",
                              ["a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa",
                               "aaaaaaaaaa"]) == False
