# 423. Reconstruct Original Digits from English
class _423_Solution:
    def originalDigits(self, s: str) -> str:
        if not s: return s
        mapping = {0: "zero", 1: "one", 2: "two", 3: "three", 4: "four", 5: "five", 6: "six", 7: "seven", 8: "eight",
                   9: "nine"}
        bits = [0] * 26
        for c in s:
            bits[ord(c) - ord('a')] += 1
        ans = ""
        ord0, ord1 = [0, 2, 4, 5, 6, 7, 8, 9, 1, 3], ['z', 'w', 'u', 'f', 'x', 's', 'g', 'i', 'o', 't']
        for num, label in zip(ord0, ord1):
            while bits[ord(label) - ord('a')] > 0:
                for c in mapping[num]:
                    bits[ord(c) - ord('a')] -= 1
                ans += str(num)
        return ''.join(sorted(ans))

    # use counter
    def originalDigits(self, s: str) -> str:
        res = ""
        res += "0" * s.count('z')
        res += "1" * (s.count('o') - s.count('z') - s.count('w') - s.count('u'))
        res += "2" * s.count('w')
        res += "3" * (s.count('h') - s.count('g'))
        res += "4" * s.count('u')
        res += "5" * (s.count('f') - s.count('u'))
        res += "6" * s.count('x')
        res += "7" * (s.count('s') - s.count('x'))
        res += "8" * s.count("g")
        res += "9" * (s.count('i') - s.count('x') - s.count("g") - s.count('f') + s.count('u'))
        return res


if __name__ == '__main__':
    obj = _423_Solution()
    assert obj.originalDigits("zeroonetwothreefourfivesixseveneightnine") == "0123456789"
