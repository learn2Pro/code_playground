# 93. Restore IP Addresses
from typing import List

'''
"25525511135"
"12"
"1234"
""
"10001"
"1001"
"0000"
"00000"
"10000"
'''


class _93_Solution:
    def restoreIpAddresses(self, s: str) -> List[str]:
        ans = []
        n = len(s)

        def track(previous: str, part: int, index: int) -> None:
            if part >= 4 and index < n: return
            if index >= n:
                if part == 4: ans.append(previous[1:])
                return
            if '0' <= s[index] <= '9':
                track(previous + "." + s[index], part + 1, index + 1)
            if index + 2 <= n and '10' <= s[index:index + 2] <= '99':
                track(previous + "." + s[index:index + 2], part + 1, index + 2)
            if index + 3 <= n and '100' <= s[index:index + 3] <= '255':
                track(previous + "." + s[index:index + 3], part + 1, index + 3)

        track("", 0, 0)
        return ans


if __name__ == '__main__':
    instance = _93_Solution
    assert instance.restoreIpAddresses(instance, "1234") == ["1.2.3.4"]
    assert instance.restoreIpAddresses(instance, "25") == []
    assert instance.restoreIpAddresses(instance, "25525511135") == ["255.255.11.135", "255.255.111.35"]
    assert instance.restoreIpAddresses(instance, "025211135") == ['0.25.211.135', '0.252.11.135', '0.252.111.35']
