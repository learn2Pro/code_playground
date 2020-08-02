import re
from typing import List


# 722. Remove Comments
class _722_Solution:
    def removeComments(self, source: List[str]) -> List[str]:
        if not source: return source
        in_comment, previous_comment, ans, start_line = False, '', [], -1

        def handle(row, lineNum):
            nonlocal in_comment, previous_comment, start_line
            c0, c1 = row.find('/*'), row.find('//')
            c2 = row.find('*/', 0 if c0 == -1 or start_line != lineNum else c0 + 2)
            if in_comment:
                if c2 != -1:
                    partial = previous_comment + row[c2 + 2:]
                    in_comment, previous_comment = False, ''
                    handle(partial, lineNum)
            elif c0 < 0 and c1 < 0 and c2 < 0 or not row:
                if len(row) > 0: ans.append(row)
            elif c0 >= 0 and (c1 < 0 or c0 < c1):
                in_comment, previous_comment, start_line = True, row[:c0], lineNum
                handle(row, lineNum)
            elif c1 >= 0 and (c0 < 0 or c1 < c0):
                sub = row[:c1]
                if len(sub) > 0: ans.append(sub)
            else:
                ans.append(row)

        for i, line in enumerate(source):
            handle(line, i)

        return ans

    # use regex
    def removeComments(self, source):
        return filter(None, re.sub('//.*|/\*(.|\n)*?\*/', '', '\n'.join(source)).split('\n'))


'''
["/*Test program */", "int main()", "{ ", "  // variable declaration ", "int a, b, c;", "/* This is a test", "   multiline  ", "   comment for ", "   testing */", "a = b + c;", "}"]
["a/*comment", "line", "more_comment*/b"]
["a/*comment*/b/*asas*/c//sdada/*sad*/c"]
["a//sdadsa*//*121*/","/*sasa*/c//sada"]
["dada/*acac","int main()","sdada*/sc"," //sda","return a;"]
["struct Node{", "    /*/ declare members;/**/", "    int size;", "    /**/int val;", "};"]
["dada//*acac*/","int main()","sdada//sc"," //sda","return a;"]
["void func(int k) {", "// this function does nothing /*", "   k = k*2/4;", "   k = k/2;*/", "}"]
["a/*/b//*c","blank","d/*/e*//f"]
'''
if __name__ == '__main__':
    obj = _722_Solution()
    assert obj.removeComments(["a/*/b//*c", "blank", "d/*/e*//f"]) == ["ae*"]
    assert obj.removeComments(
        ["void func(int k) {", "// this function does nothing /*", "   k = k*2/4;", "   k = k/2;*/", "}"]) == [
               "void func(int k) {", "   k = k*2/4;", "   k = k/2;*/", "}"]
    assert obj.removeComments(["dada//*acac", "int main()", "sdada//sc", " //sda", "return a;"]) == ["dada",
                                                                                                     "int main()",
                                                                                                     "sdada", " ",
                                                                                                     "return a;"]
    assert obj.removeComments(
        ["struct Node{", "    /*/ declare members;/**/", "    int size;", "    /**/int val;", "};"]) == ["struct Node{",
                                                                                                         "    ",
                                                                                                         "    int size;",
                                                                                                         "    int val;",
                                                                                                         "};"]
    assert obj.removeComments(["a/*comment", "line", "more_comment*/b"]) == ["ab"]
    assert obj.removeComments(
        ["/*Test program */", "int main()", "{ ", "  // variable declaration ", "int a, b, c;", "/* This is a test",
         "   multiline  ", "   comment for ", "   testing */", "a = b + c;", "}"]) == ["int main()", "{ ", "  ",
                                                                                       "int a, b, c;", "a = b + c;",
                                                                                       "}"]
