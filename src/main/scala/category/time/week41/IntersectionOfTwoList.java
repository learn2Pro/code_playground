/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package category.time.week41;

/**
 * @author derong.tdr
 * @version IntersectionOfTwoList.java, v 0.1 2019年10月13日 18:16 tang Exp $
 */
public class IntersectionOfTwoList {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int firstSize = 0, secondSize = 0;
        ListNode first = headA, second = headB;
        if (first == null || second == null) { return null; }
        /* iterate list */
        while (first.next != null || second.next != null) {
            if (first.next != null) {
                first = first.next;
                firstSize += 1;
            }
            if (second.next != null) {
                second = second.next;
                secondSize += 1;
            }
        }
        if (first != second) { return null; }
        first = headA;
        second = headB;
        if (firstSize > secondSize) {
            first = iterateDiff(firstSize - secondSize, first);
        } else {
            second = iterateDiff(secondSize - firstSize, second);
        }
        while (first != second) {
            first = first.next;
            second = second.next;
        }
        return first;
    }

    private ListNode iterateDiff(int diff, ListNode node) {
        int idx = 0;
        while (idx < diff) {
            node = node.next;
            idx += 1;
        }
        return node;
    }
}