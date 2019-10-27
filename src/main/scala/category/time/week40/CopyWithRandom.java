/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package category.time.week40;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @author derong.tdr
 * @version CopyWithRandom.java, v 0.1 2019年10月02日 10:04 tang Exp $
 */
public class CopyWithRandom {

    public Node copyRandomList(Node head) {
        if (head == null) { return null; }
        Queue<Node> queue = new LinkedList<>();
        Map<Node, Node> copied = new HashMap<>(16);
        queue.offer(head);
        copied.put(head, new Node(head.val, null, null));
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            if (poll.next != null) {
                queue.offer(poll.next);
                copied.get(poll).next = copy(poll.next, copied);
            }
            if (poll.random != null) {
                if (poll.random != poll && !copied.containsKey(poll.random)) {
                    queue.offer(poll.random);
                }
                copied.get(poll).random = copy(poll.random, copied);
            }
        }
        return copied.get(head);
    }

    private Node copy(Node input, Map<Node, Node> copied) {
        if (copied.containsKey(input)) {
            return copied.get(input);
        } else {
            Node udpated = new Node(input.val, null, null);
            copied.put(input, udpated);
            return udpated;
        }
    }
}