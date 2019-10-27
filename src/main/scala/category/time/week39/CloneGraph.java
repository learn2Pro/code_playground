/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package category.time.week39;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * 133. Clone Graph
 *
 * @author derong.tdr
 * @version CloneGraph.java, v 0.1 2019年09月28日 12:35 tang Exp $
 */
public class CloneGraph {

    //public Node cloneGraph(Node node) {
    //    Map<Integer, Node> alreadyCloned = new HashMap<>(16);
    //    return clone(null, node, node.val, alreadyCloned);
    //}
    //
    //private Node clone(Node parent, Node curr, Integer startVal, Map<Integer, Node> alreadyCloned) {
    //    if (curr.neighbors.size() == 1 || (parent != null && curr.val == startVal)) {
    //        return clonedOnce(curr.val, null, alreadyCloned);
    //    }
    //    List<Node> children = new ArrayList<>();
    //    for (int i = curr.neighbors.size() - 1; i >= 0; --i) {
    //        Node inner = curr.neighbors.get(i);
    //        if (parent == null || inner.val != parent.val) {
    //            children.add(clone(curr, inner, startVal, alreadyCloned));
    //        }
    //    }
    //    Node cloned = clonedOnce(curr.val, children, alreadyCloned);
    //    children.forEach(r -> {
    //        if (!r.neighbors.contains(cloned)) {
    //            r.neighbors.add(cloned);
    //        }
    //    });
    //    return cloned;
    //}
    //
    //private Node clonedOnce(Integer data, List<Node> added, Map<Integer, Node> alreadyCloned) {
    //    if (alreadyCloned.containsKey(data)) {
    //        return alreadyCloned.get(data);
    //    }
    //    List<Node> children = new ArrayList<>();
    //    if (added != null) {children.addAll(added); }
    //    Node newly = new Node(data, children);
    //    alreadyCloned.put(newly.val, newly);
    //    return newly;
    //}

    public Node cloneGraph(Node root) {
        if (root == null) { return null; }

        // use a queue to help BFS
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        // use a map to save cloned nodes
        Map<Node, Node> map = new HashMap<>();

        // clone the root
        map.put(root, new Node(root.val, new ArrayList<>()));

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            // handle the neighbors
            for (Node neighbor : node.neighbors) {
                if (!map.containsKey(neighbor)) {
                    // clone the neighbor
                    map.put(neighbor, new Node(neighbor.val, new ArrayList<>()));
                    // add it to the next level
                    queue.add(neighbor);
                }

                // copy the neighbor
                map.get(node).neighbors.add(map.get(neighbor));
            }
        }

        return map.get(root);
    }
}