# 71. Simplify Path
class _71_Solution:
    def simplifyPath(self, path: str) -> str:
        if len(path) == 0: return path
        ans = []
        for c in path.split('/'):
            if c == '..':
                if len(ans) > 0: ans.pop()
            elif c != '.' and len(c) != 0:
                ans.append(c)
        path = "".join(["/" + s for s in ans])
        return "/" if len(path) == 0 else path


if __name__ == '__main__':
    instance = _71_Solution
    assert instance.simplifyPath(instance, "home/") == "/home"
    assert instance.simplifyPath(instance, "/home/") == "/home"
    assert instance.simplifyPath(instance, "/../") == "/"
    assert instance.simplifyPath(instance, "/home//foo/") == "/home/foo"
    assert instance.simplifyPath(instance, "/a/./b/../../c/") == "/c"
    assert instance.simplifyPath(instance, "/a/../../b/../c//.//") == "/c"
    assert instance.simplifyPath(instance, "/a//b////c/d//././/..") == "/a/b/c"
