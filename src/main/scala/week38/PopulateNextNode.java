/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package week38;

/**
 * @author derong.tdr
 * @version PopulateNextNode.java, v 0.1 2019年09月21日 15:39 tang Exp $
 */
public class PopulateNextNode {

    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        return traversal(root).getLeft()[0];
    }

    private NodePair traversal(Node node) {
        if (node.left == null && node.right == null) {
            Node[] nodes = new Node[1];
            nodes[0] = node;
            return new NodePair(nodes, nodes);
        }
        NodePair pair0 = traversal(node.left);
        NodePair pair1 = traversal(node.right);
        for (int i = 0; i < pair0.getLeft().length; i++) {
            pair0.getRight()[i].next = pair1.getLeft()[i];
        }
        Node[] updated0 = new Node[pair0.getLeft().length + 1];
        System.arraycopy(pair0.getLeft(), 0, updated0, 1, pair0.getLeft().length);
        updated0[0] = node;
        Node[] updated1 = new Node[pair1.getRight().length + 1];
        System.arraycopy(pair1.getRight(), 0, updated1, 1, pair1.getRight().length);
        updated1[0] = node;
        return new NodePair(updated0, updated1);
    }
}