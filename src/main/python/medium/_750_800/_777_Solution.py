# 777. Swap Adjacent in LR String
class _777_Solution:
    def canTransform(self, start: str, end: str) -> bool:
        if start == end: return True
        # counter for L or R size, if counter<0 its R size else L size
        l = r = 0
        for c0, c1 in zip(start, end):
            # add L size
            if c0 == 'L':
                if l >= 0:
                    l += 1
                else:
                    return False
            elif c0 == 'R':
                # add R size
                if l <= 0:
                    l -= 1
                else:
                    return False
            if c1 == 'L':
                # add L size
                if r >= 0:
                    r += 1
                else:
                    return False
            elif c1 == 'R':
                # add R size
                if r <= 0:
                    r -= 1
                else:
                    return False
            # too many left or too less right in the start, so can't moved to end
            if l > r: return False
            # cut current sequence, begin a new sequence
            if l == r: l = r = 0
        return l == r


'''
"X"
"L"
"LX"
"XL"
"XR"
"RX"
"RXXLRXRXL"
"XRLXXRRLX"
"XRLXXRRLXXRLXXRRLXXRLXXRRLXXRLXXRRLXXRLXXRRLXXRLXXRRLXXRLXXRRLXXRLXXRRLXXRLXXRRLXXRLXXRRLXXRLXXRRLXXRLXXRRLXXRLXXRRLXXRLXXRRLXXRLXXRRLXXRLXXRRLXXRLXXRRLXXRLXXRRLXXRLXXRRLX"
"XRLXXRRLXXRLXXRRLXXRLXXRRLXXRLXXRRLXXRLXXRRLXXRLXXRRLXXRLXXRRLXXRLXXRRLXXRLXXRRLXXRLXXRRLXXRLXXRRLXXRLXXRRLXXRLXXRRLXXRLXXRRLXXRLXXRRLXXRLXXRRLXXRLXXRRLXXRLXXRRLXXRLXXRRLR"
"XLR"
"LXR"
"RXL"
"RLX"
"RXL"
"XRL"
"XRXL"
"XRLX"
"XRXXXXL"
"XXRLXXX"
"XLXRRXXRXX"
"LXXXXXXRRR"
'''
if __name__ == '__main__':
    tar = _777_Solution()
    assert not tar.canTransform("XR", "RX")
    assert tar.canTransform("XLXRRXXRXX", "LXXXXXXRRR")
    assert not tar.canTransform("RXRXXR", "XRXRRR")
    assert not tar.canTransform("LX", "XL")
    assert tar.canTransform("RXRXX", "XRXRX")
    assert not tar.canTransform("RXRXRX", "XRXRXX")
    assert tar.canTransform("RXXLRXRXL", "XRLXXRRLX")
    assert tar.canTransform("RX", "XR")
    assert not tar.canTransform("XX", "XL")
