# 388. Longest Absolute File Path

'''
"dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"
"dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"
"dir\n\ta\n\t\taa\n\t\t\taaa\n\t\t\t\tfile1.txt\n\taaaaaaaaaaaaaaaaaaaaa\n\t\tsth.png"
"dir\n\ta\n\t\taa\n\t\t\taaa\n\t\t\t\tfile1.txt\n\taaaaaaaaaaaaaaaaaaaaa\n\tsth.png"
""
"dir"
"dir\n\t1.txt"
"a.txt"
"dir\n    file.txt"
"  dir\n\t file.xx "
"  dir\n\t file.xx \n\t\t 21 \n\t       123.x      "
"  dir\n  file.xx \n\t\t 21 \n\t       123.x      "
"  dir\n\t file.xx \n\t\t 21 \n\t\t\t\t 98 \n\t       123.x      "
'''


class _388_Solution:
    def lengthLongestPath(self, input: str) -> int:
        ret, tmp = 0, {-1: 0}
        for line in input.split('\n'):
            depth = line.count('\t')
            # print(depth)
            len(line) - 1

            tmp[depth] = tmp[depth - 1] + len(line) - depth
            if line.count('.'):
                ret = max(ret, tmp[depth] + depth)
        return ret

    # def lengthLongestPath(self, input: str) -> int:
    #     n, dir, maximal = len(input), {}, 0
    #     stack = []
    #
    #     def dfs(i: int, previous: int, level: int) -> None:
    #         nonlocal maximal
    #         if i >= n: return
    #         l = 0
    #         while i < n and (input[i] == "\n" or input[i] == "\t"):
    #             if input[i] == "\t": l += 1
    #             i += 1
    #         while len(stack) > 0 and l < level:
    #             curr = stack.pop()
    #             previous -= 0 if len(curr) == 0 else len(curr) + 1
    #             level -= 1
    #         partial = ""
    #         while i < n and input[i] != "\n":
    #             partial += input[i]
    #             i += 1
    #         if "." in partial:
    #             maximal = max(maximal, previous + len(partial) + 1)
    #         else:
    #             while level < l: stack.append('');level += 1
    #             level += 1
    #             previous += len(partial) + 1
    #             stack.append(partial)
    #         dfs(i, previous, level)
    #
    #     if not input: return 0
    #     root, index = "", 0
    #     while index < n and input[index] != "\n":
    #         root += input[index]
    #         index += 1
    #     if "." in root:
    #         maximal = max(maximal, len(root))
    #     stack.append(root)
    #     dfs(index, len(root), 1)
    #     return maximal


if __name__ == '__main__':
    obj = _388_Solution()
    # assert obj.lengthLongestPath("  dir\n\t file.xx \n\t\t 21 \n\t\t\t\t 98 \n\t       123.x      ") == 18
    # assert obj.lengthLongestPath("  dir\n\t file.xx \n\t\t 21 \n\t       123.x      ") == 24
    assert obj.lengthLongestPath(
        "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext") == 32
    # assert obj.lengthLongestPath("  dir\n  file.xx \n\t\t 21 \n\t       123.x      ") == 18
    # assert obj.lengthLongestPath("dir\n    file.txt") == 12
    assert obj.lengthLongestPath(
        "dir\n\ta\n\t\taa\n\t\t\taaa\n\t\t\t\tfile1.txt\n\taaaaaaaaaaaaaaaaaaaaa\n\tsth.png") == 22
