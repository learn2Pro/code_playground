# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def numberToWords(self, num: int) -> str:
        if num == 0:
            return 'Zero'
        digits = ['One', 'Two', 'Three', 'Four', 'Five', 'Six', 'Seven', 'Eight', 'Nine']
        tens = ['Ten', 'Twenty', 'Thirty', 'Forty', 'Fifty', 'Sixty', 'Seventy', 'Eighty',
                'Ninety']
        teens = ['Ten', 'Eleven', 'Twelve', 'Thirteen', 'Fourteen', 'Fifteen', 'Sixteen', 'Seventeen',
                 'Eighteen', 'Nineteen']
        units = ['Thousand', 'Million', 'Billion']

        def f(n):
            if n == 0:
                return ''
            if n < 10:
                return digits[n - 1]
            if n < 20:
                return teens[n - 10]
            if n < 100:
                return tens[n // 10 - 1] + ' ' + f(n % 10)
            if n < 1000:
                return digits[n // 100 - 1] + ' Hundred ' + f(n % 100)
            for i in range(3):
                if n < 1000 ** (i + 2):
                    return f(n // 1000 ** (i + 1)) + ' ' + units[i] + ' ' + f(n % 1000 ** (i + 1))

        return " ".join(part for part in f(num).split(" ") if part)
# leetcode submit region end(Prohibit modification and deletion)
