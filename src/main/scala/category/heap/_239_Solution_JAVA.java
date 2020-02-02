/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package category.heap;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 239. Sliding Window Maximum
 */
class _239_Solution_JAVA {
    public int[] maxSlidingWindow(int[] a, int k) {
        if (a == null || k <= 0) { return new int[0]; }
        int n = a.length;
        int[] r = new int[n - k + 1];
        int ri = 0;
        // store index
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < a.length; i++) {
            // remove numbers out of range k
            while (!q.isEmpty() && q.peek() < i - k + 1) { q.poll(); }
            // remove smaller numbers in k range as they are useless
            while (!q.isEmpty() && a[q.peekLast()] < a[i]) { q.pollLast(); }
            // q contains index... r contains content
            q.offer(i);
            if (i >= k - 1) { r[ri++] = a[q.peek()]; }
        }
        return r;
    }

    //public int[] maxSlidingWindow(int[] nums, int k) {
    //    PriorityQueue<Integer> heap = new java.util.PriorityQueue<>((o1, o2) -> o2 - o1);
    //    int j = 0, t = 0;
    //    int N = nums.length;
    //    if (N == 0) { return new int[] {}; }
    //    int[] ans = new int[N - k + 1];
    //    while (j < N) {
    //        heap.add(nums[j]);
    //        if (heap.size() > k) { heap.remove(nums[j - k]); }
    //        if (heap.size() == k) { ans[t++] = heap.peek(); }
    //        j++;
    //    }
    //    return ans;
    //}
}