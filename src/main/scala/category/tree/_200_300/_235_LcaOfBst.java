/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package category.tree._200_300;

import category.timeline.week29.TreeNode;

/**
 * 235. Lowest Common Ancestor of a Binary Search Tree
 *
 * @author tang
 * @version : _235_LcaOfBst.java, v 0.1 2020年01月04日 18:31 tang Exp $
 */
public class _235_LcaOfBst {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode lo, hi;
        if (p.value() > q.value()) {
            lo = q;
            hi = p;
        } else {
            lo = p;
            hi = q;
        }
        if (root.value() >= lo.value() && root.value() <= hi.value()) {
            return root;
        } else if (root.value() < lo.value()) {
            return lowestCommonAncestor(root.right(), p, q);
        } else {
            return lowestCommonAncestor(root.left(), p, q);
        }
    }
}