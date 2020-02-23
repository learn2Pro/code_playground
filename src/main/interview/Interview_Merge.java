/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author tang
 * @version : Interview_Merge.java, v 0.1 2020年02月21日 13:24 tang Exp $
 */
public class Interview_Merge {

    public List<Integer> merge(List<List<Integer>> mergeList) {
        List<Integer> ans = new ArrayList<>();
        /*entity,which list,which index*/
        PriorityQueue<Tuple<Integer, Integer, Integer>> queue = new java.util.PriorityQueue<>(Comparator.comparingInt(Tuple::getEntity));
        for (int i = 0; i < mergeList.size(); i++) {
            List<Integer> which = mergeList.get(i);
            if (which.size() > 0) {
                queue.add(new Tuple<>(mergeList.get(0).get(0), i, 0));
            }
        }
        while (!queue.isEmpty()) {
            Tuple<Integer, Integer, Integer> partial = queue.poll();
            ans.add(partial.getEntity());
            if (mergeList.get(partial.getListIndex()).size() > partial.getIndex() + 1) {
                queue.add(new Tuple<>(mergeList.get(partial.getListIndex()).get(partial.getIndex() + 1), partial.getListIndex(),
                        partial.getIndex() + 1));
            }
        }
        return ans;
    }

    static class Tuple<L, M, R> {
        private L entity;
        private M listIndex;
        private R index;

        public Tuple(L entity, M listIndex, R index) {
            this.entity = entity;
            this.listIndex = listIndex;
            this.index = index;
        }

        public L getEntity() {
            return entity;
        }

        public M getListIndex() {
            return listIndex;
        }

        public R getIndex() {
            return index;
        }
    }

}