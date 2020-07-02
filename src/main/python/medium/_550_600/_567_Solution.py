# 567. Permutation in String

'''
"ab"
"eidbaooo"
"o"
"eidbaooo"
"b"
"eidbaooo"
"ab"
"eidboaoo"
'''


class _567_Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        if len(s1) > len(s2): return False
        chars, win = [0] * 26, [0] * 26
        n = len(s1)
        for c in s1:
            chars[ord(c) - ord('a')] += 1
        for i in range(n):
            win[ord(s2[i]) - ord('a')] += 1
        for step in range(n, len(s2)):
            if win == chars: return True
            # move
            win[ord(s2[step - n]) - ord('a')] -= 1
            win[ord(s2[step]) - ord('a')] += 1
        return win == chars


'''
"ab"
"eidbaooo"
"o"
"eidbaooo"
"b"
"eidbaooo"
"ab"
"eidboaoo"
'''
if __name__ == '__main__':
    obj = _567_Solution()
    assert obj.checkInclusion("waw", "baww")
    assert obj.checkInclusion("ab", "eidbaooo")
