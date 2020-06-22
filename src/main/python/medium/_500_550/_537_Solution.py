import re


class _537_Solution:
    def complexNumberMultiply(self, a: str, b: str) -> str:
        m0, m1 = re.search('(-?\w+)\\+(-?\w+)i', a), re.search('(-?\w+)\\+(-?\w+)i', b)
        a0, b0 = int(m0.group(1)), int(m0.group(2))
        a1, b1 = int(m1.group(1)), int(m1.group(2))
        return f"{a0*a1-b0*b1}+{a1*b0+a0*b1}i"


if __name__ == '__main__':
    obj = _537_Solution()
    assert obj.complexNumberMultiply("1+1i", "1+1i") == "0+2i"
    assert obj.complexNumberMultiply("1+-1i", "1+-1i") == "0+-2i"
