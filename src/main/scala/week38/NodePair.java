/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package week38;

/**
 * @author derong.tdr
 * @version NodePair.java, v 0.1 2019年09月21日 16:29 tang Exp $
 */
public class NodePair {
    public Node[] left;
    public Node[] right;

    public NodePair(Node[] left, Node[] right) {
        this.left = left;
        this.right = right;
    }

    public Node[] getLeft() {
        return left;
    }

    public Node[] getRight() {
        return right;
    }
}