package org.learn2pro.test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import org.jetbrains.annotations.NotNull;

public class CLHLock implements Lock {


  private static ThreadLocal<Node> currNode = new ThreadLocal<>();
  private AtomicReference<Node> tail = new AtomicReference<>(null);

  public CLHLock() {
    this.tail.getAndSet(Node.empty());
  }

  @Override
  public void lock() {
    Node curr = new Node(true, null);
    Node t = tail.get();
    while (!tail.compareAndSet(t, curr)) {
      t = tail.get();
    }
    curr.setPreNode(t);
    while (t.isLocked()){
      Thread.yield();
//      LockSupport.parkNanos(1_000);
    }
    currNode.set(curr);
  }

  @Override
  public void lockInterruptibly() throws InterruptedException {

  }

  @Override
  public boolean tryLock() {
    return false;
  }

  @Override
  public boolean tryLock(long time, @NotNull TimeUnit unit) throws InterruptedException {
    return false;
  }

  @Override
  public void unlock() {
    Node curr = currNode.get();
    curr.setLocked(false);
    curr.setPreNode(null);
    currNode.remove();
  }

  @NotNull
  @Override
  public Condition newCondition() {
    return null;
  }

  static class Node {

    /**
     * 是否抢锁中
     */
    private boolean locked;
    /**
     * 前向node
     */
    private Node preNode;

    public Node(boolean locked, Node preNode) {
      this.locked = locked;
      this.preNode = preNode;
    }

    public boolean isLocked() {
      return locked;
    }

    public void setLocked(boolean locked) {
      this.locked = locked;
    }

    public void setPreNode(Node preNode) {
      this.preNode = preNode;
    }

    public static Node empty() {
      return new Node(false, null);
    }
  }
}
