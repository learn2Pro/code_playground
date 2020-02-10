# 60. Permutation Sequence
class _60_Solution:
    def getPermutation(self, n: int, k: int) -> str:
        ans = ""
        remain = [i for i in range(1, n + 1)]
        factorial = [1] * (n + 1)
        for j in range(1, n + 1): factorial[j] = factorial[j - 1] * j
        k -= 1
        for i in range(1, n + 1):
            index, k = divmod(k, factorial[n - i])
            ans += str(remain[index])
            remain.remove(remain[index])
        return ans


    # def getPermutation(self, n: int, k: int) -> str:
    #     visited = set()
    #
    #     def build(size: int) -> str:
    #         suffix = ""
    #         if size < 0: return suffix
    #         for i in range(1, n + 1):
    #             if len(suffix) == size: break
    #             if i in visited: continue
    #             suffix += str(i)
    #             visited.add(i)
    #         return suffix
    #
    #     def skip(gap: int) -> str:
    #         suffix = ""
    #         for i in range(1, n + 1):
    #             if i not in visited:
    #                 if gap == 0:
    #                     suffix += str(i)
    #                     visited.add(i)
    #                     break
    #                 else:
    #                     gap -= 1
    #         return str(n) if len(suffix) == 0 and gap == 0 else suffix
    #
    #     def track(previous: str, remain: int) -> str:
    #         if remain <= 1:
    #             return previous + build(n - len(previous))
    #         tmp, i = 1, 1
    #         while remain > tmp: i += 1;tmp *= i
    #         newAdd = build(n - len(previous) - i)
    #         newAdd += skip(remain // (tmp // i))
    #         return track(previous + newAdd, remain - tmp // i)
    #
    #     return track("", k)


if __name__ == '__main__':
    instance = _60_Solution
    assert instance.getPermutation(instance, 3, 1) == "123"
    assert instance.getPermutation(instance, 3, 2) == "132"
    assert instance.getPermutation(instance, 3, 3) == "213"
    assert instance.getPermutation(instance, 3, 4) == "231"
    assert instance.getPermutation(instance, 3, 5) == "312"
    assert instance.getPermutation(instance, 3, 6) == "321"
    assert instance.getPermutation(instance, 1, 0) == "1"
    assert instance.getPermutation(instance, 1, 1) == "1"
    assert instance.getPermutation(instance, 4, 9) == "2314"
