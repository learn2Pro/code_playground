# 799. Champagne Tower
import math


class _799_Solution:
    def champagneTower(self, poured: int, query_row: int, query_glass: int) -> float:

        def binom_coef(n, k):
            result = 1
            for i in range(n - k + 1, n + 1):
                result *= i
            for i in range(1, k + 1):
                result /= i
            return result

        capacity = 1
        while poured >= capacity:
            poured -= capacity
            capacity += 1
        row = capacity - 1
        if row > query_row:
            return 1.0
        if row < query_row:
            return 0.0
        else:
            return (poured / 2 ** query_row) * binom_coef(query_row, query_glass)

    # use simulate
    def champagneTower(self, poured: int, query_row: int, query_glass: int) -> float:
        A = [[0] * k for k in range(1, 102)]
        A[0][0] = poured
        for row in range(query_row + 1):
            for col in range(row + 1):
                flowed = (A[row][col] - 1) / 2.0
                if flowed > 0:
                    A[row + 1][col] += flowed
                    A[row + 1][col + 1] += flowed
        return min(1, A[query_row][query_glass])


if __name__ == '__main__':
    tar = _799_Solution()
    assert tar.champagneTower(8, 3, 1) == 0.87500
    assert tar.champagneTower(7, 3, 1) == 0.0
    assert tar.champagneTower(1, 1, 1) == 0.0
    assert tar.champagneTower(2, 1, 1) == 0.5
