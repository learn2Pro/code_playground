# 331. Verify Preorder Serialization of a Binary Tree
from src.main.python.TreeNode import TreeNode

'''
"9,3,4,#,#,1,#,#,2,#,6,#,#"
"#"
""
"1,#,#"
"1,#"
"9,3,4,#,#,1,#,#,2,#,6,#"
"9,3,4,#,#,1,#,#,2,#,6,#,#,#"
"9,#,#,1"
'''
class _331_Solution:
    # iterative
    def isValidSerialization(self, preorder: str) -> bool:
        node = preorder.split(',')
        slot = 1
        for i in node:
            if slot == 0:
                return False
            if i == '#':
                # 用#填坑，不会产生新的坑位（空节点没有子节点）
                slot -= 1
            else:
                # 填进去一个数字，往往会另外产生两个坑位
                slot += 1
        return slot == 0
    # backtrack
    # def isValidSerialization(self, preorder: str) -> bool:
    #     if not preorder: return False
    #     chars = preorder.split(",")
    #     n = len(chars)
    #
    #     index, passed = 0, True
    #
    #     def validate() -> TreeNode:
    #         nonlocal index, passed
    #         if index >= n:
    #             passed = False
    #             return None
    #         if chars[index] == '#':
    #             index += 1
    #             return None
    #         current = TreeNode(chars[index])
    #         index += 1
    #         next = validate()
    #         current.left = next
    #         current.right = validate()
    #         return current
    #
    #     node = validate()
    #     return index == n and passed


if __name__ == '__main__':
    instance = _331_Solution()
    assert not instance.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#")
    assert not instance.isValidSerialization("1,#")
    assert instance.isValidSerialization("#")
    assert instance.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#")
    assert not instance.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#,#")
