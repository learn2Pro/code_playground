package org.learn2pro.test;

import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueueSample<T> {

  /**
   * 容器，用于存放数据的队列
   */
  private List<T> container;
  /**
   * 写入&读取锁
   */
  private ReentrantLock lock;
  /**
   * 不为空，signal
   */
  private Condition notEmpty;
  /**
   * 未满，signal
   */
  private Condition notFull;
  /**
   * 最大容量
   */
  private int capacity;
  /**
   * 当前size
   */
  private int size;

  public BlockingQueueSample(int capacity) {
    Preconditions.checkArgument(capacity > 0, "the capacity of queue must be positive!");
    this.container = new ArrayList<>(capacity);
    this.lock = new ReentrantLock();
    this.notFull = this.lock.newCondition();
    this.notEmpty = this.lock.newCondition();
    this.capacity = capacity;
  }

  public T take() throws InterruptedException {
    this.lock.lockInterruptibly();
    try {
      while (size == 0) {
        notEmpty.await();
      }
      T item = container.remove(0);
      --size;
      if (size == capacity - 1) {
        notFull.signalAll();
      }
      return item;
    } finally {
      this.lock.unlock();
    }
  }

  public void put(T item) throws InterruptedException {
    this.lock.lockInterruptibly();
    try {
      while (size == capacity) {
        notFull.await();
      }
      container.add(item);
      ++size;
      if (size == 1) {
        notEmpty.signalAll();
      }
    } finally {
      this.lock.unlock();
    }
  }
}
