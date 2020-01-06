/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package category.tree._500_600;

import java.util.ArrayList;
import java.util.List;

import category.tree.Node;

/**
 * 589. N-ary Tree Preorder Traversal
 */
public class _589_NaryTreePreOrderTraversal {
    List<Integer> ans = new ArrayList<>();

    public List<Integer> preorder(Node root) {
        traversal(root);
        return ans;
    }

    private void traversal(Node node) {
        if (node == null) { return; }
        ans.add(node.val);
        for (Node child : node.children) {
            traversal(child);
        }
    }
}