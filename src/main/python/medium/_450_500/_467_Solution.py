# 467. Unique Substrings in Wraparound String


class _467_Solution:
    def findSubstringInWraproundString(self, p: str) -> int:
        if not p: return 0
        chars = [0] * 26
        expected, partial = -1, 0
        for c in p:
            index = ord(c) - ord('a')
            if index == expected:
                partial += 1
                expected = (expected + 1) % 26
            else:
                partial = 1
                expected = (index + 1) % 26
            chars[index] = max(chars[index], partial)
        return sum(chars)


if __name__ == '__main__':
    obj = _467_Solution()
    assert obj.findSubstringInWraproundString("abcdxyziqoyyyxxzab") == 21
    assert obj.findSubstringInWraproundString("xyzabcdefghijklmn") == 153
    assert obj.findSubstringInWraproundString("zab") == 6
    assert obj.findSubstringInWraproundString("a") == 1
    assert obj.findSubstringInWraproundString("cac") == 2
