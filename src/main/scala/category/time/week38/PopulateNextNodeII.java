/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package category.time.week38;

/**
 * @author derong.tdr
 * @version PopulateNextNode.java, v 0.1 2019年09月21日 15:39 tang Exp $
 */
public class PopulateNextNodeII {

    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        return traversal(root).getLeft()[0];
    }

    private NodePair traversal(Node node) {
        if (node == null) {
            return new NodePair(null, null);
        }
        if (node.left == null && node.right == null) {
            Node[] nodes = new Node[1];
            nodes[0] = node;
            return new NodePair(nodes, nodes);
        }
        NodePair pair0 = traversal(node.left);
        NodePair pair1 = traversal(node.right);
        mapping(pair0, pair1);
        NodePair updated = assemble(pair0, pair1);
        Node[] updated0 = new Node[updated.left.length + 1];
        arraycopy(updated.left, 0, updated0, 1, updated.left.length);
        updated0[0] = node;
        Node[] updated1 = new Node[updated.right.length + 1];
        arraycopy(updated.right, 0, updated1, 1, updated.right.length);
        updated1[0] = node;
        return new NodePair(updated0, updated1);
    }

    private void mapping(NodePair pair0, NodePair pair1) {
        Node[] mappingLeft = assembleRight(pair0);
        Node[] mappingRight = assembleLeft(pair1);
        int midLen = Math.min(len(mappingLeft), len(mappingRight));
        for (int i = 0; i < midLen; i++) {
            mappingLeft[i].next = mappingRight[i];
        }
    }

    private NodePair assemble(NodePair pair0, NodePair pair1) {
        Node[] left0 = assembleLeft(pair0);
        Node[] left1 = assembleLeft(pair1);
        Node[] right0 = assembleRight(pair0);
        Node[] right1 = assembleRight(pair1);
        return new NodePair(assembleLeft(new NodePair(left0, left1)), assembleRight(new NodePair(right0, right1)));
    }

    private Node[] assembleLeft(NodePair pair) {
        if (len(pair.right) > len(pair.left)) {
            Node[] newly = new Node[Math.max(len(pair.left), len(pair.right))];
            if (pair.left != null) {
                arraycopy(pair.left, 0, newly, 0, len(pair.left));
            }
            arraycopy(pair.right, len(pair.left), newly, len(pair.left), len(pair.right) - len(pair.left));
            return newly;
        } else {
            return pair.left;
        }
    }

    private Node[] assembleRight(NodePair pair) {
        if (len(pair.left) > len(pair.right)) {
            Node[] newly = new Node[Math.max(len(pair.left), len(pair.right))];
            if (pair.right != null) {
                arraycopy(pair.right, 0, newly, 0, len(pair.right));
            }
            arraycopy(pair.left, len(pair.right), newly, len(pair.right), len(pair.left) - len(pair.right));
            return newly;
        } else {
            return pair.right;
        }
    }

    private void arraycopy(Node[] src, int srcStart, Node[] dst, int dstStart, int length) {
        for (int i = 0; i < length; i++) {
            dst[i + dstStart] = src[i + srcStart];
        }
    }

    private int len(Node[] nodes) {
        if (nodes == null) {
            return 0;
        } else {
            return nodes.length;
        }
    }
}