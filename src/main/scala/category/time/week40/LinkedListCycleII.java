/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package category.time.week40;

import category.time.week22.ListNode;

/**
 * @author derong.tdr
 * @version LinkedListCycle.java, v 0.1 2019年10月03日 11:17 tang Exp $
 */
public class LinkedListCycleII {

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next() != null) {
            slow = nextNode(slow);
            fast = nextNode(nextNode(fast));
            if (fast == slow) {
                break;
            }
        }
        if (fast == null || fast.next() == null) { return null; }
        slow = head;
        while (slow != fast) {
            slow = nextNode(slow);
            fast = nextNode(fast);
        }
        return fast;
    }

    //public ListNode detectCycle(ListNode head) {
    //    if (head == null) { return null; }
    //    Set<ListNode> passed = new java.util.HashSet<>();
    //    ListNode curr = head;
    //    while (!passed.contains(curr) && curr != null) {
    //        passed.add(curr);
    //        curr = nextNode(curr);
    //    }
    //    return curr;
    //}

    private ListNode nextNode(ListNode node) {
        if (node == null) {
            return null;
        } else {
            return node.next();
        }
    }
}