# 670. Maximum Swap
class _670_Solution:
    def maximumSwap(self, num: int) -> int:
        stack, s = [], [c for c in str(num)]
        minimal = len(s) - 1
        for i, c in enumerate(s):
            while stack and c > stack[-1][0]:
                minimal = min(minimal, stack.pop()[1])
            stack.append((c, i))
        stack.sort(reverse=True)
        for num, i in stack:
            if i > minimal:
                s[i], s[minimal] = s[minimal], s[i]
                break
        return int(''.join(s))

    # swap the greateast in the follow,if same choose the larger index
    def maximumSwap(self, num: int) -> int:
        num_str = [int(c) for c in str(num)]
        mapping = {x: i for i, x in enumerate(num_str)}
        for i, x in enumerate(num_str):
            for larger in reversed(range(x + 1, 10)):
                if larger in mapping and mapping[larger] > i:
                    num_str[i], num_str[mapping[larger]] = num_str[mapping[larger]], num_str[i]
                    return int(''.join(map(str, num_str)))
        return num


'''
2736
1
2
3
9
9973
87623491
1234321
12343216
1993
'''
if __name__ == '__main__':
    obj = _670_Solution()
    assert obj.maximumSwap(98368) == 98863
    assert obj.maximumSwap(1993) == 9913
    assert obj.maximumSwap(2736) == 7236
    assert obj.maximumSwap(7236) == 7632
    assert obj.maximumSwap(9973) == 9973
