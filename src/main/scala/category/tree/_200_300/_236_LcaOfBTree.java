/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package category.tree._200_300;

import category.tree.TreeNode;

/**
 * 236. Lowest Common Ancestor of a Binary Tree
 *
 * @author tang
 * @version : _235_LcaOfBst.java, v 0.1 2020年01月04日 18:31 tang Exp $
 */
public class _236_LcaOfBTree {

    TreeNode ans;

    public boolean backTrack(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) { return false; }
        int left = backTrack(node.left, p, q) ? 1 : 0;
        int right = backTrack(node.right, p, q) ? 1 : 0;
        int mid = (node.val == p.val || node.val == q.val) ? 1 : 0;
        if (left + right + mid >= 2) { ans = node; }
        return left + right + mid >= 1;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        backTrack(root, p, q);
        return ans;
    }
}