# 385. Mini Parser
from src.main.python.NestedInteger import NestedInteger

'''
"324"
"[123,[456,[789]]]"
"[[1,[2,[3,4]]],5]"
"[[1,[-2,[3,-4]]],5]"
'''


class _385_Solution:
    def deserialize(self, s: str) -> NestedInteger:
        def nestedInteger(x):
            if isinstance(x, int):
                return NestedInteger(x)
            lst = NestedInteger()
            for y in x:
                lst.add(nestedInteger(y))
            return lst
        return nestedInteger(eval(s))

    # def deserialize(self, s: str) -> NestedInteger:
    #     stack, i, n = [], 0, len(s)
    #     while i < n:
    #         c = s[i]
    #         if c == ',':
    #             i += 1
    #             continue
    #         elif c == ']':
    #             lst, params = NestedInteger(), []
    #             while stack[-1] != '[':
    #                 params.append(stack.pop())
    #             for param in reversed(params):
    #                 lst.add(param)
    #             stack.pop()
    #             stack.append(lst)
    #             i += 1
    #         elif c == '[':
    #             stack.append(c)
    #             i += 1
    #         else:
    #             partial = ""
    #             while i < n and (s[i] == '-' or s[i].isdigit()):
    #                 partial += s[i]
    #                 i += 1
    #             stack.append(NestedInteger(int(partial)))
    #
    #     return stack[-1]


if __name__ == '__main__':
    obj = _385_Solution()
    assert obj.deserialize("[123,[456,[789]]]") == NestedInteger()
    assert obj.deserialize("[324]") == NestedInteger()
