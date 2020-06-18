# 526. Beautiful Arrangement
class _526_Solution:
    def countArrangement(self, N: int) -> int:
        arranges, used = 0, set()

        def backtrack(i: int) -> None:
            nonlocal arranges
            if i == 1:
                arranges += 1
                return
            for num in range(1, N + 1):
                if num in used: continue
                if num % i != 0 and i % num != 0: continue
                used.add(num)
                backtrack(i - 1)
                used.remove(num)

        backtrack(N)
        return arranges


'''
0
1
2
3
4
5
6
7
8
9
10
11
12
13
14
15
'''
if __name__ == '__main__':
    obj = _526_Solution()
    assert obj.countArrangement(2) == 2
    assert obj.countArrangement(3) == 3
