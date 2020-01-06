/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package category.tree._500_600;

import category.tree.Node;

/**
 * 559. Maximum Depth of N-ary Tree
 */
public class _559_MaximumDepthOfNaryTree {
    public int maxDepth(Node root) {
        if (root == null) { return 0; }
        int depth = 1;
        for (Node child : root.children) {
            depth = Math.max(depth, maxDepth(child) + 1);
        }
        return depth;
    }
}