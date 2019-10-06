package week39;

import java.util.List;

/**
 * 133. Clone Graph Node entity
 */
public class Node {
    public int        val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int val) {
        this.val = val;
    }

    public Node(int _val, List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }

}