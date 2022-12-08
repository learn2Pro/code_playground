package org.learn2pro.test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class Solution {

  static class Prim {

    private boolean[] visited;
    private int weightSum;
    private List<int[]>[] graph;
    private PriorityQueue<int[]> pq;

    public Prim(List<int[]>[] graph) {
      this.graph = graph;
      this.pq = new PriorityQueue<int[]>(Comparator.comparingInt(o -> o[2]));
      int n = this.graph.length;
      this.visited = new boolean[n];
      compute();
    }

    private void compute() {
      cut(0);
      visited[0] = true;
      while (!pq.isEmpty()) {
        int[] current = pq.poll();
        if (visited[current[1]]) {
          continue;
        }
        weightSum += current[2];
        visited[current[1]] = true;
        cut(current[1]);
      }
    }

    private void cut(int start) {
      for (int[] edge : graph[start]) {
        int from = edge[0], to = edge[1];
        if (visited[to]) {
          continue;
        }
        pq.add(edge);
      }
    }

    public boolean isAllConnected() {
      for (boolean used : visited) {
        if (!used) {
          return false;
        }
      }
      return true;
    }

    public int weightSum() {
      return weightSum;
    }
  }

  public int minimumCost(int n, int[][] connections) {
    // 图中共有 n 个节点
    List<int[]>[] graph = new ArrayList[n];
    for (int i = 0; i < n; i++) {
      graph[i] = new ArrayList<>();
    }
    for (int[] conn : connections) {
      int u = conn[0] - 1;
      int v = conn[1] - 1;
      int weight = conn[2];
      graph[u].add(new int[]{u, v, weight});
      graph[v].add(new int[]{v, u, weight});
    }
    Prim sol = new Prim(graph);
    if (sol.isAllConnected()) {
      return sol.weightSum();
    }
    return -1;
  }
}
