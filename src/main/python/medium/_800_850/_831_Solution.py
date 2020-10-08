# 831. Masking Personal Information
'''
"LeetCode@LeetCode.com"
"1(234)567-890"
"86-(10)12345678"
"86-(10)123456+78"
"86-(10)12345(67)8"
"771234567899"
"+(501321)-50-23431"
"+86(88)1513-7-74"
'''


class _831_Solution:
    def maskPII(self, S: str) -> str:
        if '@' in S:
            splits = S.split('@')
            return splits[0][0].lower() + "*****" + splits[0][-1].lower() + '@' + splits[1].lower()
        else:
            replaced = S.replace('(', '').replace(')', '').replace('+', '').replace('-', '').replace(' ', '')
            if len(replaced) == 10:
                return "***-***-" + replaced[-4:]
            elif len(replaced) == 11:
                return "+*-***-***-" + replaced[-4:]
            elif len(replaced) == 12:
                return "+**-***-***-" + replaced[-4:]
            else:
                return "+***-***-***-" + replaced[-4:]
