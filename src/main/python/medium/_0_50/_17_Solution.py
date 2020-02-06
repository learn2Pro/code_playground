# 17. Letter Combinations of a Phone Number
from typing import List


class _17_Solution:
    mapping = {'1': [''], '2': ['a', 'b', 'c'], '3': ['d', 'e', 'f'], '4': ['g', 'h', 'i'], '5': ['j', 'k', 'l'],
               '6': ['m', 'n', 'o'], '7': ['p', 'q', 'r', 's'], '8': ['t', 'u', 'v'], '9': ['w', 'x', 'y', 'z']}

    def letterCombinations(self, digits: str) -> List[str]:
        ans = []
        if len(digits) <= 0: return ans
        index = [0] * len(digits)
        while index[0] < len(self.mapping[digits[0]]):
            curr = ''
            for i, k in enumerate(digits):
                curr += self.mapping[k][index[i]]
                if i == len(digits) - 1:
                    index[i] += 1
                for j in range(len(digits) - 1, 0, -1):
                    if index[j] >= len(self.mapping[digits[j]]):
                        index[j] = 0
                        index[j - 1] += 1
            ans.append(curr)
        return ans


if __name__ == '__main__':
    instance = _17_Solution
    assert instance.letterCombinations(instance, "1") == ['']
    assert instance.letterCombinations(instance, "92121") == ["w", "x", "y", "z"]
    assert instance.letterCombinations(instance, "239") == ["w", "x", "y", "z"]
    assert instance.letterCombinations(instance, "9") == ["w", "x", "y", "z"]
    assert instance.letterCombinations(instance, "2") == ["a", "b", "c"]
    assert instance.letterCombinations(instance, "23") == ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
