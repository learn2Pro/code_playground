# 394. Decode String
class _394_Solution:
    def decodeString(self, s: str) -> str:
        if not s: return ""
        stack, reverse = [], ""
        i = 0
        for c in reversed(s):
            if c == '[':
                reverse += ']'
            elif c == ']':
                reverse += '['
            else:
                reverse += c

        while i < len(s):
            c = reverse[i]
            if c == ']':
                num, partial, i = "", "", i + 1
                while i < len(s) and reverse[i].isdigit(): num = reverse[i] + num;i += 1
                while len(stack) > 0 and stack[-1] != '[': partial += stack.pop()
                stack.pop()
                stack.append(partial * int(num))
            else:
                stack.append(c)
                i += 1
        return ''.join(reversed(stack))


if __name__ == '__main__':
    obj = _394_Solution()
    assert obj.decodeString("100[leetcode]") == "leetcodeleetcodeleetcode"
    assert obj.decodeString("3[a2[c]]") == "accaccacc"
