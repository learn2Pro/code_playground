# 12. Integer to Roman

class _12_Solution:
    mapping = {1: 'I', 5: 'V', 10: 'X', 50: 'L', 100: 'C', 500: 'D', 1000: 'M'}
    subtract = {1000: 100, 500: 100, 100: 10, 50: 10, 10: 1, 5: 1}

    def intToRoman(self, num: int) -> str:
        ans = ""
        for threshold in [1000, 500, 100, 50, 10, 5, 1]:
            while num >= threshold:
                ans += self.mapping[threshold]
                num -= threshold
            if threshold > 1 and num >= threshold - self.subtract[threshold]:
                ans += self.mapping[self.subtract[threshold]] + self.mapping[threshold]
                num -= (threshold - self.subtract[threshold])
        return ans


if __name__ == '__main__':
    instance = _12_Solution
    assert instance.intToRoman(instance, 1994) == "MCMXCIV"
    assert instance.intToRoman(instance, 1) == "I"
    assert instance.intToRoman(instance, 3) == "III"
    assert instance.intToRoman(instance, 4) == "IV"
    assert instance.intToRoman(instance, 9) == "IX"
    assert instance.intToRoman(instance, 58) == "LVIII"
    assert instance.intToRoman(instance, 3999) == "MMMCMXCIX"
    assert instance.intToRoman(instance, 3998) == "MMMCMXCVIII"
