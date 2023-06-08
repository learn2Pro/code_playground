# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def compareVersion(self, version1: str, version2: str) -> int:
        split1, split2 = version1.split('.'), version2.split('.')
        for l, r in zip(split1, split2):
            if int(l) > int(r):
                return 1
            elif int(l) < int(r):
                return -1
        if len(split1) > len(split2):
            for i in range(len(split2), len(split1)):
                if int(split1[i]) > 0:
                    return 1
        elif len(split1) < len(split2):
            for i in range(len(split1), len(split2)):
                if int(split2[i]) > 0:
                    return -1
        return 0
# leetcode submit region end(Prohibit modification and deletion)
