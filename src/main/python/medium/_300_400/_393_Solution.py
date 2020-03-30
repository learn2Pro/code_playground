# 393. UTF-8 Validation
from typing import List


class _393_Solution:
    def validUtf8(self, data: List[int]) -> bool:
        if not data: return False
        count = 0
        for num in data:
            if count == 0:
                if num & 0xE0 == 0xC0:
                    count = 1
                elif num & 0xF0 == 0xE0:
                    count = 2
                elif num & 0xF8 == 0xF0:
                    count = 3
                elif num & 0x80 != 0:
                    return False
            else:
                if num & 0xC0 == 0x80:
                    count -= 1
                else:
                    return False
        return count == 0


if __name__ == '__main__':
    obj = _393_Solution()
    assert obj.validUtf8([197, 130, 1]) == True
