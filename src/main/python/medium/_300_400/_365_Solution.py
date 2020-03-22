# 365. Water and Jug Problem
class _365_Solution:
    # use gcd
    def canMeasureWater(self, x: int, y: int, z: int) -> bool:
        def gcd(a: int, b: int) -> int:
            while (b != 0):
                tmp = b
                b = a % b
                a = tmp
            return a

        if x + y < z: return False
        if x == z or y == z or x + y == z: return True
        return z % gcd(x, y) == 0

    # def canMeasureWater(self, x: int, y: int, z: int) -> bool:
    #     visited = set()
    #
    #     def measure(l0: int, l1: int) -> bool:
    #         if (l0, l1) in visited: return False
    #         if l0 == z or l1 == z or l0 + l1 == z: return True
    #         visited.add((l0, l1))
    #         return measure(0, l1) or measure(max(0, l0 + l1 - y), min(l0 + l1, y)) or measure(l0, 0) or measure(
    #             min(l0 + l1, x), max(0, l0 + l1 - x)) or measure(x, l1) or measure(l0, y)
    #
    #     return measure(0, 0)


'''
3
5
4
3
5
2
2
6
5
2
6
4
1
10
7
2
20
8
0
0
1
0
2
2
'''
if __name__ == '__main__':
    instance = _365_Solution()
    assert instance.canMeasureWater(3, 5, 4)
    assert not instance.canMeasureWater(3, 5, 10)
    assert not instance.canMeasureWater(2, 6, 5)
