
# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def fractionToDecimal(self, numerator: int, denominator: int) -> str:
        if numerator == 0: return '0'
        if denominator == 0: return ''
        res = []
        if (numerator < 0) ^ (denominator < 0):
            res.append('-')
        numerator, denominator = abs(numerator), abs(denominator)
        res.append(str(numerator // denominator))
        remainder = numerator % denominator
        if remainder == 0:
            return ''.join(res)
        res.append('.')
        dic = {}
        while remainder != 0:
            if remainder in dic:
                res.insert(dic[remainder], '(')
                res.append(')')
                break
            dic[remainder] = len(res)
            remainder *= 10
            res.append(str(remainder // denominator))
            remainder %= denominator
        return ''.join(res)
# leetcode submit region end(Prohibit modification and deletion)
