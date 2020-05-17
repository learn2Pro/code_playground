# 468. Validate IP Address
'''
"172.16.254.1"
"256.256.256.256"
"172.16.254.01"
"1"
"1.2"
"127.0.0.1"
"127.0.1"
"1.2.3.4"
"0.0.0.-0"
"0.0.0.0"
'''


class _468_Solution:
    def validIPAddress(self, IP: str) -> str:
        if not IP: return "Neither"
        if "." in IP:
            parts = IP.split(".")
            if len(parts) != 4: return "Neither"
            for part in parts:
                try:
                    if len(part) == 0 or len(part) > 3: return "Neither"
                    if part[0] == '-': return "Neither"
                    if part.startswith("0") and len(part) > 1: return "Neither"
                    if int(part) >= 256 or int(part) < 0: return "Neither"
                except:
                    return "Neither"
            return "IPv4"
        if ":" in IP:
            parts = IP.split(":")
            if len(parts) != 8: return "Neither"
            for part in parts:
                try:
                    if len(part) == 0 or len(part) > 4: return "Neither"
                    if part[0] == '-': return "Neither"
                    if int(part, 16) > 0xffff or int(part, 16) < 0: return "Neither"
                except:
                    return "Neither"
            return "IPv6"
        return "Neither"


if __name__ == '__main__':
    obj = _468_Solution()
    assert obj.validIPAddress("20EE:Fb8:85a3:0:0:8A2E:0370:7334") == "IPv6"
    assert obj.validIPAddress("2001:0db8:85g3:0:0:8A2E:0370:7334") == "Neither"
    assert obj.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334") == "IPv6"
