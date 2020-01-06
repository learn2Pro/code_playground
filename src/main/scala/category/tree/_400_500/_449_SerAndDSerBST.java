/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package category.tree._400_500;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import category.tree.TreeNode;

/**
 * 449. Serialize and Deserialize BST
 */
public class _449_SerAndDSerBST {
    private static final String NULL_NODE = "N";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) { return NULL_NODE + ","; }
        return root.val + "," + serialize(root.left) + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> nodes = new LinkedList<>(Arrays.asList(data.split(",")));
        return build(nodes);
    }

    private TreeNode build(Queue<String> queue) {
        String head = queue.remove();
        if (NULL_NODE.equals(head)) { return null; }
        TreeNode current = new TreeNode(Integer.parseInt(head));
        current.left = build(queue);
        current.right = build(queue);
        return current;
    }
}