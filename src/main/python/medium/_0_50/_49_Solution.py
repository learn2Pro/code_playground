# 49. Group Anagrams
from typing import List


class _49_Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        dict = {}

        def buildKey(input: str) -> str:
            arr = [0] * 26
            for c in input:
                arr[ord(c) - ord('a')] += 1
            output = ""
            for i, sz in enumerate(arr):
                if sz > 0: output += "(" + str(i) + ")" + str(sz) + "_"
            return output

        for word in strs:
            key = buildKey(word)
            if key in dict:
                dict[key].append(word)
            else:
                dict[key] = [word]
        return list(dict.values())


if __name__ == '__main__':
    instance = _49_Solution
    assert instance.groupAnagrams(instance, []) == []
    assert instance.groupAnagrams(instance, ["eat", "tea", "tan", "ate", "nat", "bat"]) == [['eat', 'tea', 'ate'],
                                                                                            ['tan', 'nat'], ['bat']]
