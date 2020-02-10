# 50. Pow(x, n)
''''''
'''
2.00000
10
0
0
1000
0
2.0
-2
2.1
3
1
2147483647
1
-2147483648
2
2147483647
'''
class _50_Solution:
    def myPow(self, x: float, n: int) -> float:
        sig = n > 0
        history = [[1, x]]
        accumulate = 1.0
        power, remain = 0, abs(n)
        while remain > 0:
            for j in range(len(history) - 1, -1, -1):
                if history[j][0] > remain: continue
                remain -= history[j][0]
                power += history[j][0]
                accumulate *= history[j][1]
                history.append([power, accumulate])
                break
        return accumulate if sig else 1.0 / accumulate


if __name__ == '__main__':
    instance = _50_Solution
    assert instance.myPow(instance, 2.00000, -2) == 0.25
    assert instance.myPow(instance, 2.1, 3) == 9.261000000000001
    assert instance.myPow(instance, 2.0, 10) == 1024.00000
    assert instance.myPow(instance, 1024.0, 0) == 1.0
    assert instance.myPow(instance, 0.0, 0) == 1.0
    assert instance.myPow(instance, -2.00000, -1) == -0.5
