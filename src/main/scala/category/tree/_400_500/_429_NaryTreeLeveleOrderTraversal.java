/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package category.tree._400_500;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import category.tree.Node;

/**
 * 429. N-ary Tree Level Order Traversal
 */
public class _429_NaryTreeLeveleOrderTraversal {
    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) { return new ArrayList<>(); }
        Queue<Node> queue = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int currentLevelSize = queue.size();

            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < currentLevelSize; i++) {
                Node current = queue.remove();
                level.add(current.val);
                for (Node child : current.children) {
                    if (child != null) { queue.add(child); }
                }
            }
            ans.add(level);
        }
        return ans;
    }

    static class Pair<A, B> {
        A fst;
        B snd;

        public Pair(A fst, B snd) {
            this.fst = fst;
            this.snd = snd;
        }

        public static <A, B> Pair<A, B> of(A a, B b) {
            return new Pair<>(a, b);
        }
    }
}