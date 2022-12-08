package org.learn2pro.test;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

class LRUCache extends LinkedHashMap<Integer, Integer> {

  private int capacity;

  public LRUCache(int capacity) {
    super(capacity, 0.75f, true);
    this.capacity = capacity;
  }

  public int get(int key) {
    return super.get(key) == null ? -1 : super.get(key);
  }

  public void put(int key, int value) {
    super.put(key, value);
  }

  @Override
  protected boolean removeEldestEntry(Entry<Integer, Integer> eldest) {
    return size() > this.capacity;
  }
}
