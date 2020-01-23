/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package category.dfs._400_500;

import java.util.Stack;

/**
 * 430. Flatten a Multilevel Doubly Linked List
 */
public class _430_Solution {
    public Node flatten(Node head) {
        Node pointer = head;
        Stack<Node> stack = new Stack<>();
        while (pointer != null) {
            if (pointer.child != null) {
                if (pointer.next != null) { stack.push(pointer.next); }
                pointer.next = pointer.child;
                pointer.next.prev = pointer;
                pointer.child = null;
            } else if (pointer.next == null && !stack.isEmpty()) {
                pointer.next = stack.pop();
                pointer.next.prev = pointer;
            }
            pointer = pointer.next;
        }
        return head;
    }

    //public Node flatten(Node head) {
    //    Node pointer = head;
    //    while (pointer != null) {
    //        if (pointer.child != null) {
    //            pointer = dfs(pointer, pointer.child);
    //        } else {
    //            pointer = pointer.next;
    //        }
    //    }
    //    return head;
    //}
    //
    //private Node dfs(Node start, Node child) {
    //    if (child == null) { return start; }
    //    if (child.child == null && child.next == null) {
    //        Node tmp = start.next;
    //        start.next = start.child;
    //        start.next.prev = start;
    //        start.child = null;
    //        child.next = tmp;
    //        if (tmp != null) { tmp.prev = child; }
    //        return tmp;
    //    }
    //    Node next = child.next;
    //    if (child.child != null) { next = dfs(child, child.child); }
    //    return dfs(start, next);
    //}
}