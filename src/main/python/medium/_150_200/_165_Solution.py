# 165. Compare Version Numbers


class _165_Solution:
    def compareVersion(self, version1: str, version2: str) -> int:
        split0 = list(map(int, version1.split('.')))
        split1 = list(map(int, version2.split('.')))
        size = max(len(split0), len(split1))
        while len(split0) < size: split0.append(0)
        while len(split1) < size: split1.append(0)
        if split0 > split1:
            return 1
        elif split0 < split1:
            return -1
        else:
            return 0

    # def compareVersion(self, version1: str, version2: str) -> int:
    #     split0 = version1.split('.')
    #     split1 = version2.split('.')
    #     size = max(len(split0), len(split1))
    #
    #     def get(i: int, arr: List[str]) -> int:
    #         if i >= len(arr):
    #             return 0
    #         else:
    #             return int(arr[i])
    #
    #     for i in range(size):
    #         if get(i, split0) == get(i, split1): continue
    #         if get(i, split0) < get(i, split1):
    #             return -1
    #         else:
    #             return 1
    #     return 0
