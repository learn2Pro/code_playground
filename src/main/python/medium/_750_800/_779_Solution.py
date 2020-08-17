# 779. K-th Symbol in Grammar
from math import ceil


class _779_Solution:
    def kthGrammar(self, N: int, K: int) -> int:
        if K <= 2: return K - 1
        if K <= 4: return 4 - K
        pattern0 = ["0110", "1001"]
        index, remain = divmod(K, 4)
        if remain > 0: index += 1
        index -= 1
        # true=1,false=2
        start, current = 0, True
        while index > 0:
            if index % 2 == 1:
                current = not current
            index //= 2
        if not current: start += 1
        return int(pattern0[start][remain - 1])

    def kthGrammar(self, N: int, K: int) -> int:
        if N == 1: return 0
        return self.kthGrammar(N - 1, ceil(K / 2)) if K % 2 else self.kthGrammar(N - 1, ceil(K / 2)) ^ 1


'''
10
301
10
302
10
303
10
304
10
305
10
306
10
407
10
408
10
409
10
410
10
411
'''
if __name__ == '__main__':
    tar = _779_Solution()
    assert tar.kthGrammar(10, 478) == 1
    assert tar.kthGrammar(4, 5) == 1
    assert tar.kthGrammar(4, 8) == 1
    assert tar.kthGrammar(5, 13) == 1
