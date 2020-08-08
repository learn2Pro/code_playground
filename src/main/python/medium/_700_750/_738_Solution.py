# 738. Monotone Increasing Digits
class _738_Solution:
    # o(D^2)
    def monotoneIncreasingDigits(self, N: int) -> int:
        digits = []
        A = list(str(N))
        for i in range(len(A)):
            for num in range(1, 10):
                if digits + [str(num)] * (len(A) - i) > A:
                    digits.append(str(num - 1))
                    break
            else:
                digits.append('9')
        return int(''.join(digits))

    # o(D)
    # def monotoneIncreasingDigits(self, N: int) -> int:
    #     digits, prev = list(str(N)), chr(ord('0') - 1)
    #     n = len(digits)
    #     marker = n
    #     for i in reversed(range(n - 1)):
    #         if digits[i] > digits[i + 1]:
    #             marker = i
    #             digits[i] = chr(ord(digits[i]) - 1)
    #     for j in range(marker + 1, len(digits)):
    #         digits[j] = '9'
    #     return int(''.join(digits))

'''
10
11111
21111
0
1
10
100
'''
if __name__ == '__main__':
    tar = _738_Solution()
    assert tar.monotoneIncreasingDigits(4321) == 3999
    assert tar.monotoneIncreasingDigits(11111) == 11111
    assert tar.monotoneIncreasingDigits(332) == 299
    assert tar.monotoneIncreasingDigits(10) == 9
    assert tar.monotoneIncreasingDigits(1234) == 1234
