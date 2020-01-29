/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package category.bsearch._300_400;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 315. Count of Smaller Numbers After Self
 */
public class _315_Solution_JAVA {
    public List<Integer> countSmaller(int[] nums) {
        PriorityQueue<Integer> queue = new java.util.PriorityQueue<>();
        List<Integer> pop = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        int N = nums.length;
        for (int i = N - 1; i >= 0; --i) {
            while (!queue.isEmpty() && queue.peek() < nums[i]) { pop.add(queue.poll()); }
            while (!pop.isEmpty() && pop.get(pop.size() - 1) >= nums[i]) { queue.offer(pop.remove(pop.size() - 1)); }
            ans.add(0, pop.size());
            queue.offer(nums[i]);
        }
        return ans;
    }
}