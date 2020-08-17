# 784. Letter Case Permutation
import itertools
from typing import List


class _784_Solution:
    def letterCasePermutation(self, S: str) -> List[str]:
        ans, current = [], []

        def backtrack(index):
            if index >= len(S):
                ans.append(''.join(current))
                return
            if str.isalpha(S[index]):
                current.append(S[index].lower())
                backtrack(index + 1)
                current.pop()
                current.append(S[index].upper())
                backtrack(index + 1)
                current.pop()
            else:
                current.append(S[index])
                backtrack(index + 1)
                current.pop()

        backtrack(0)
        return ans

    # use product
    def letterCasePermutation(self, S: str) -> List[str]:
        L = [{c.lower(), c.upper()} for c in S]
        return map(''.join, itertools.product(*L))
