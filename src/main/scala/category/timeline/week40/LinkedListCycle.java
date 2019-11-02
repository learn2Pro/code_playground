/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package category.timeline.week40;

import category.timeline.week22.ListNode;

/**
 * @author derong.tdr
 * @version LinkedListCycle.java, v 0.1 2019年10月03日 11:17 tang Exp $
 */
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null) { return false; }
        /* move two step */
        ListNode fast = head.next();
        /* move one step */
        ListNode slow = head;
        while (fast != null && slow != null && fast != slow) {
            fast = nextNode(nextNode(fast));
            slow = nextNode(slow);
        }
        if (fast == slow && fast != null) {
            return true;
        } else {
            return false;
        }
    }

    private ListNode nextNode(ListNode node) {
        if (node == null) {
            return null;
        } else {
            return node.next();
        }
    }
}