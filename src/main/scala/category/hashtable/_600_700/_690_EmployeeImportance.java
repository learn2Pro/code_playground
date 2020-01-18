/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package category.hashtable._600_700;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 690. Employee Importance
 */
class _690_EmployeeImportance {

    private Map<Integer, Pair<Integer, Set<Integer>>> build(List<Employee> employees) {
        Map<Integer, Pair<Integer, Set<Integer>>> holder = new HashMap<>();
        for (Employee employee : employees) {
            holder.put(employee.id, new Pair<>(employee.importance, new HashSet<>(employee.subordinates)));
        }
        return holder;
    }

    private int dfs(Map<Integer, Pair<Integer, Set<Integer>>> holder, int id) {
        if (holder.get(id).snd.isEmpty()) { return holder.get(id).fst; }
        int importance = holder.get(id).fst;
        for (Integer subordinate : holder.get(id).snd) {
            importance += dfs(holder, subordinate);
        }
        return importance;
    }

    public int getImportance(List<Employee> employees, int id) {
        return dfs(build(employees), id);
    }

    static class Pair<F, S> {
        private F fst;
        private S snd;

        public Pair(F fst, S snd) {
            this.fst = fst;
            this.snd = snd;
        }

        public F getFst() {
            return fst;
        }

        public S getSnd() {
            return snd;
        }
    }

    static class Employee {
        // It's the unique id of each node;
        // unique id of this employee
        public int           id;
        // the importance value of this employee
        public int           importance;
        // the id of direct subordinates
        public List<Integer> subordinates;
    }
}