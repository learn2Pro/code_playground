# 201. Bitwise AND of Numbers Range
'''
5
7
0
2147483647
1
2147483647
47
1147483647
1147483647
2147483647
1147300125
1147400000
1147400000
1147483647
'''
class _201_Solution:
    def rangeBitwiseAnd(self, m: int, n: int) -> int:
        gap, iter, bit = n - m + 1, 1, 0x7fffffff
        while iter < gap:
            iter <<= 1
            bit <<= 1
        return m & n & bit


if __name__ == '__main__':
    instance = _201_Solution
    assert instance.rangeBitwiseAnd(instance, 1, 1) == 1
    assert instance.rangeBitwiseAnd(instance, 1147400000, 1147483647) == 1147142144
    assert instance.rangeBitwiseAnd(instance, 5, 7) == 4
    assert instance.rangeBitwiseAnd(instance, 0, 1) == 0
