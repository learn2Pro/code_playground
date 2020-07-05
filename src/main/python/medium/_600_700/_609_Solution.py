# 609. Find Duplicate File in System
from typing import List
import regex
import re


class _609_Solution:
    def findDuplicate(self, paths: List[str]) -> List[List[str]]:
        dict = {}
        pattern = regex.compile("root(/\w+)*\s(\s?(\w+\\.txt)\\((\w+)\\))+")
        for s in paths:
            m = pattern.search(s)
            dir = ''.join(m.captures(1))
            for name, content in zip(m.captures(3), m.captures(4)):
                lst = dict.get(content, [])
                lst.append("root" + dir + "/" + name)
                dict[content] = lst
        ans = []
        for k, v in dict.items():
            if len(v) < 2: continue
            ans.append(v)
        return ans

    def findDuplicate(self, paths: List[str]) -> List[List[str]]:
        dict = {}
        pattern = re.compile("(\w+\\.txt)\\((\w+)\\)")
        for s in paths:
            splits = s.split(' ')
            dir = splits[0]
            for i in range(1, len(splits)):
                m = pattern.match(splits[i])
                name, content = m.group(1), m.group(2)
                lst = dict.get(content, [])
                lst.append(dir + "/" + name)
                dict[content] = lst
        ans = []
        for k, v in dict.items():
            if len(v) < 2: continue
            ans.append(v)
        return ans


'''
["root/a 1.txt(abcd) 2.txt(efgh)","root/c 3.txt(abcd)","root/c/d 4.txt(efgh)","root 4.txt(efgh)"]
[]
["root 1.txt(a)"]
["root 2.txt(a)","root 1.txt(a)"]
'''
if __name__ == "__main__":
    obj = _609_Solution()
    assert obj.findDuplicate(["root 1.txt(a)"]) == [["root/1.txt"]]
    assert obj.findDuplicate(
        ["root/a 1.txt(abcd) 2.txt(efgh) 3.txt(efgh)", "root 4.txt(efgh)", "root/c 3.txt(abcd)",
         "root/c/d 4.txt(efgh)"]) == [
               ["root/a/2.txt", "root/c/d/4.txt", "root/4.txt"], ["root/a/1.txt", "root/c/3.txt"]]
