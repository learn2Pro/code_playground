/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package category.list;

import category.timeline.week41.ListNode;

/**
 * 237. Delete Node in a Linked List
 */
public class _237_Solution {
    public void deleteNode(ListNode node) {
        ListNode last = node;
        while (node.next != null) {
            ListNode v = node.next;
            if (v != null) {node.val = v.val;}
            last = node;
            node = v;
        }
        last.next = null;
    }
}