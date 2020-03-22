# 372. Super Pow
from functools import reduce


class _372_Solution:
    # (a^q) % 1337
    def superPow(self, a, b):
        if a==0 or a==1:return a
        if not b:return 1
        return 0 if a % 1337 == 0 else pow(a, reduce(lambda x, y: (x * 10 + y) % 1140, b) + 1140, 1337)
    # a^1234567 % 1337 == ((a^123456 % 1337) ^ 10) % 1337 * (a^7)%1337
    # def superPow(self, a: int, b: List[int]) -> int:
    #     def powermode(a: int, p: int) -> int:
    #         a %= 1337
    #         multi = 1
    #         for i in range(p):
    #             multi = (multi * a) % 1337
    #         return multi
    #
    #     if a == 0 or a == 1: return a
    #     if not b: return 1
    #     return powermode(self.superPow(a, b[:-1]), 10) * powermode(a, b[-1]) % 1337


# use built-in
# def superPow(self, a: int, b: List[int]) -> int:
#     if a == 0 or a == 1: return a
#     if not b: return 1
#     return pow(a, int(''.join(list(map(str, b)))), 1337)
# def superPow(self, a: int, b: List[int]) -> int:
#     def modArray(input: int) -> (int, int):
#         multi, times = a, 1
#         while multi < 0x7ffffff: multi *= a;times += 1
#         mods = multi % 1337
#         return mods, times
#
#     def divSuper(arr: List[int], divisor: int) -> (List[int], int):
#         remain, ans = 0, []
#         for i, num in enumerate(arr):
#             if remain * 10 + num < divisor:
#                 if i != 0: ans.append(0)
#                 remain = remain * 10 + num
#             else:
#                 ans.append((remain * 10 + num) // divisor)
#                 remain = (remain * 10 + num) % divisor
#         return ans, remain
#
#     if a == 0 or a == 1: return a
#     remain = 1
#     while len(b) > 1:
#         next, divisor = modArray(a)
#         b, tmp = divSuper(b, divisor)
#         remain = (remain * (a ** tmp)) % 1337
#         a = next
#     return remain % 1337 if len(b) == 0 else (a ** b[0] * remain) % 1337


'''
2
[3]
2
[10]
2
[1,1,2,3,4,5,6,9,9,1,2,7]
3
[1,1,2,3,4,5,6,9,9,1,2,7,1,1,2,3,4,5,6,9,9,1,2,7]
4
[1,1,2,3,4,5,6,9,9,1,2,7,1,1,2,3,4,5,6,9,9,1,2,7]
5
[1,1,2,3,4,5,6,9,9,1,2,7,1,1,2,3,4,5,6,9,9,1,2,7]
11
[1,1,2,3,4,5,6,9,9,1,2,7,1,1,2,3,4,5,6,9,9,1,2,7]
721921
[1,1,2,3,4,5,6,9,9,1,2,7]
1
[1,1,1,1,1,2,2,3,4,9]
0
[1,1,1,1,1,2,2,3,4,9]
3
[]
3
[0]
3166358
[7,4,8,7,9,2,5,2,2,5,6,4,2,0,7,0,4,6,8,3,9,6,0,1,3,3,8,0,7,7,0,8,3,0,7,3,3,2,5,5,9,4,1,1,4,1,3,8,9,2,4,8,8,6,9,3,2,9,4,9,8,6,7,2,7,4,5,2,9,2,9,0,6,1,4,3,4,7,3,3,1,7,3,0,4,2,5,6,2,9,7,2,8,5,4,5,1,1,7,2,6,6,5,2,9,9,7,5,6,1,8,8,0,1,0,6,6,5,4,0,7,2,2,5,9,7,2,2,0,1,7,6,7,2,1,9,1,8,4,7,9,5,7,2,6,7,8,4,5,3,4,4,7,9,9,6,6,3,8,8,4,5,5,3,9,6,2,0,6,7,0,8,2,7,0,0,7,8,7,2,3,1,6,0,2,7,8,0,2,7,9,6,4,4,9,4,2,4,6,8,1,6,6,5,6,8,7,3,7,4,7,2,8,5,5,0,4,3,1,6,2,0,4,7,6,3,3,0,7,1,8,0,0,7,7,6,5,7,1,4,3,0,9,1,7,4,4,1,7,7,9,0,9,3,9,7,8,4,7,8,5,7,0,5,4,8,3,2,7,6,8,0,8,7,4,5,1,0,6,9,7,5,9,8,0,0,5,9,4,2,7,9,9,7,7,6,7,2,8,4,9,6,7,7,6,3,5,7,3,1,6,2,9,7,0,9,7,5,8,3,7,7,5,8,5,2,4,2,6,4,9,7,3,6,7,9,9,2,6,4,5,5,6,4,4,8,6,4,3,6,7,2,4,2,0,1,6,5,3,3,1,4,2,4,2,9,3,3,1,2,7,7,9,5,3,3,3,9,9,6,8,7,8,4,1,1,5,8,6,0,3,7,5,5,4,7,7,7,1,8,1,0,7,0,6,1,6,1,2,5,0,2,2,8,6,6,1,3,6,7,4,9,7,1,6,1,0,5,0,3,4,2,4,3,4,2,6,0,3,1,6,3,3,0,4,2,6,5,5,2,5,9,3,4,2,2,7,3,7,9,6,3,1,2,7,8,6,3,8,2,4,4,7,0,7,3,2,3,1,7,6,8,9,9,2,1,3,9,6,1,8,5,4,2,7,3,2,6,9,0,8,5,7,7,5,4,1,9,7,2,7,5,0,8,7,4,9,0,5,8,1,5,3,8,9,0,1,1,8,2,2,8,8,1,6,3,7,7,3,6,1,2,2,3,0,1,7,1,1,2,9,5,7,2,5,7,5,8,0,3,1,4,2,9,5,8,4,2,7,7,1,0,1,3,3,1,6,0,5,9,4,4,4,3,7,1,2,4,0,3,7,3,7,1,2,5,1,6,9,0,6,0,0,7,5,3,1,1,5,6,1,1,2,7,5,1,9,9,5,1,2,5,4,2,6,6,7,0,4,6,0,2,7,1,0,2,6,3,6,4,1,7,5,3,4,0,5,5,2,0,6,6,7,0,8,6,8,7,6,3,6,8,5,5,1,7,9,8,2,5,2,3,2,9,9,9,2,4,4,4,6,1,0,4,3,1,2,2,8,8,5,4,8,2,1,0,2,1,0,4,8,2,0,3,3,9,2,5,3,8,9,1,9,0,7,3,3,9,7,1,9,2,8,8,6,1,8,8,2,8,5,1,2,5,4,5,4,8,3,9,6,2,2,8,4,0,3,7,9,0,1,1,4,9,9,0,0,9,1,5,9,6,8,3,3,4,8,9,2,3,0,0,6,2,0,2,4,3,0,6,5,1,7,9,2,6,2,4,7,5,1,6,1,9,9,6,3,9,7,7,3,7,8,9,9,8,1,6,4,3,2,9,6,9,1,8,7,3,5,4,8,6,2,1,6,1,9,1,0,6,9,5,3,9,6,4,9,0,0,3,3,4,5,0,3,6,0,2,1,5,8,1,4,0,2,0,1,3,3,4,9,2,9,4,3,8,0,3,8,1,8,1,5,3,3,1,1,4,3,2,1,4,3,5,4,7,7,8,2,1,2,1,5,3,7,1,1,8,4,9,1,4,3,6,0,6,9,1,2,5,6,6,9,9,1,5,9,1,3,1,2,7,5,9,1,2,0,4,2,6,6,3,3,9,2,3,7,1,4,2,8,0,8,9,2,1,5,3,2,8,4,6,6,1,8,9,6,0,5,8,9,1,2,2,2,6,5,2,7,1,6,8,4,4,7,6,7,2,9,2,3,5,8,1,9,8,2,5,9,7,3,8,1,7,0,5,3,7,7,3,0] 
'''
if __name__ == '__main__':
    obj = _372_Solution()
    assert obj.superPow(2, [1, 1, 2, 3, 4, 5, 6, 9, 9, 1, 2, 7]) == 39
    assert obj.superPow(721921, [1, 1, 2, 3, 4, 5, 6, 9, 9, 1, 2, 7]) == 534
    assert obj.superPow(2, [3]) == 8
    assert obj.superPow(2, [1, 0]) == 1024
    assert obj.superPow(2, [1, 1]) == 711
