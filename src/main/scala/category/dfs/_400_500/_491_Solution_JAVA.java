/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package category.dfs._400_500;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 491. Increasing Subsequences
 */
public class _491_Solution_JAVA {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        helper(new LinkedList<Integer>(), 0, nums, res);
        return res;
    }

    private void helper(LinkedList<Integer> list, int index, int[] nums, List<List<Integer>> res) {
        if (list.size() > 1) { res.add(new LinkedList<Integer>(list)); }
        Set<Integer> used = new HashSet<>();
        for (int i = index; i < nums.length; i++) {
            if (used.contains(nums[i])) { continue; }
            if (list.size() == 0 || nums[i] >= list.peekLast()) {
                used.add(nums[i]);
                list.add(nums[i]);
                helper(list, i + 1, nums, res);
                list.remove(list.size() - 1);
            }
        }
    }

    //public List<List<Integer>> findSubsequences(int[] nums) {
    //    if (nums == null || nums.length == 0) { return new ArrayList<>(); }
    //    List<List<Integer>> ans = new ArrayList<>();
    //    int N = nums.length;
    //    Map<Integer, Integer> used = new HashMap<>();
    //    List<List<Integer>>[] dp = new List[N];
    //    for (int i = 0; i < N; i++) {
    //        List<Integer> arr = new ArrayList<>();
    //        arr.add(nums[i]);
    //        List<List<Integer>> parent = new ArrayList<>();
    //        parent.add(arr);
    //        dp[i] = parent;
    //        for (int j = used.getOrDefault(nums[i], 0); j < i; j++) {
    //            if (nums[j] <= nums[i]) {
    //                for (List<Integer> integers : dp[j]) {
    //                    List<Integer> inner0 = new ArrayList<>();
    //                    inner0.addAll(integers);
    //                    inner0.add(nums[i]);
    //                    ans.add(inner0);
    //                    dp[i].add(inner0);
    //                }
    //            }
    //        }
    //        used.put(nums[i], i);
    //    }
    //    return ans;
    //}
}