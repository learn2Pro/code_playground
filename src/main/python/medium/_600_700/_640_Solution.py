# 640. Solve the Equation
import re

'''
"x+5-3+x=6+x-2"
"x=x"
"2x=x"
"2x+3x-6x=x+2"
"x=x+2"
"-x=1"
"-x+x=1"
"-x+x+1=1"
"-x+3x+1=x+3"
"x=1"
"-x=1"
"3=2"
'''
class _640_Solution:
    def solveEquation(self, equation: str) -> str:
        parts = equation.split("=")
        left, right = parts[0], parts[1]

        def regSolve(input):
            if input[0] != "-": input = "+" + input
            splits, index = re.split(r'[\+|\-]', input), 0
            x_size = num = 0
            for split in splits:
                if not split: continue
                flag = 1 if input[index] == "+" else -1
                if "x" in split:
                    multi = int(split[:-1]) if split[:-1] else 1
                    x_size += (flag * multi)
                else:
                    num += (flag * int(split))
                index += len(split) + 1
            return x_size, num

        l_x, l_num = regSolve(left)
        r_x, r_num = regSolve(right)
        if l_x == r_x and l_num == r_num:
            return "Infinite solutions"
        elif l_x == r_x and l_num != r_num:
            return "No solution"
        else:
            multi, constant = l_x - r_x, r_num - l_num
            ans = constant // multi
            return "x=" + str(ans)

    def solveEquation(self, equation):
        z = eval(equation.replace('x', 'j').replace('=', '-(') + ')', {'j': 1j})
        a, x = z.real, -z.imag
        return 'x=%d' % (a / x) if x else 'No solution' if a else 'Infinite solutions'

if __name__ == '__main__':
    obj = _640_Solution()
    assert obj.solveEquation("x+5-3+x=6+x-2") == "x=2"
