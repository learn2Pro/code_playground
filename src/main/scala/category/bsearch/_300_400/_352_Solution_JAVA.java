/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package category.bsearch._300_400;

import java.util.Collection;
import java.util.TreeMap;

/**
 * @author tang
 * @version : _352_Solution_JAVA.java, v 0.1 2020年01月25日 15:16 tang Exp $
 */
public class _352_Solution_JAVA {

    /**
     * Initialize your data structure here.
     */
    TreeMap<Integer, int[]> tree = new TreeMap<>();

    public _352_Solution_JAVA() {
    }

    public void addNum(int val) {
        if (tree.containsKey(val)) { return; }
        Integer lo = tree.lowerKey(val);
        Integer hi = tree.higherKey(val);
        if (lo != null && hi != null && last(tree.get(lo)) + 1 == val && head(tree.get(hi)) == val + 1) {
            tree.put(lo, new int[] {head(tree.get(lo)), last(tree.get(hi))});
            tree.remove(hi);
        } else if (lo != null && last(tree.get(lo)) + 1 >= val) {
            tree.put(lo, new int[] {head(tree.get(lo)), Math.max(val, last(tree.get(lo)))});
        } else if (hi != null && hi == val + 1) {
            tree.put(val, new int[] {val, last(tree.get(hi))});
            tree.remove(hi);
        } else {
            tree.put(val, new int[] {val, val});
        }
    }

    private int head(int[] ints) {
        return ints[0];
    }

    private int last(int[] ints) {
        int len = ints.length;
        return ints[len - 1];
    }

    public int[][] getIntervals() {
        Collection<int[]> values = tree.values();
        int[][] ans = new int[values.size()][2];
        values.toArray(ans);
        return ans;
    }
}