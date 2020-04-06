# 424. Longest Repeating Character Replacement
'''
"ABAB"
2
"AABABBA"
2
"AABABBA"
1
""
1
"AA"
3
"CABDEFGHTYQQW"
1
"AAAAAAAAAA"
1
"ABABABABABAAB"
1
"ABCCC"
1
"A"
0
"ABCC"
0
"BAAAB"
2
'''


class _424_Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        word = [0] * 26
        i, j = 0, 0
        maximal, max_char = 0, 0
        while j < len(s):
            c = s[j]
            word[ord(c) - ord('A')] += 1
            all = j - i + 1
            max_char = max(max_char, word[ord(c) - ord('A')])
            remain = all - max_char
            if remain <= k:
                maximal = max(maximal, all)
                j += 1
            else:
                word[ord(s[i]) - ord('A')] -= 1
                i += 1
                j += 1
        return maximal


if __name__ == '__main__':
    obj = _424_Solution()
    assert obj.characterReplacement("BAAAB", 2) == 5
    assert obj.characterReplacement("ABABABABABAAB", 1) == 4
    assert obj.characterReplacement("ABAB", 2) == 4
    assert obj.characterReplacement("AABABBA", 1) == 4
