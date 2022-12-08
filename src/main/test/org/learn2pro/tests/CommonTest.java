package org.learn2pro.tests;

import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import org.junit.Test;
import org.learn2pro.test.BlockingQueueSample;
import org.learn2pro.test.CLHLock;

public class CommonTest {

  @Test
  public void queueTest0() throws Exception {
    AtomicInteger counter = new AtomicInteger(0);
    int total = 20000;
    BlockingQueueSample queue = new BlockingQueueSample<Integer>(10);
//    ArrayBlockingQueue queue = new ArrayBlockingQueue<Integer>(10);
    ForkJoinPool.commonPool().submit(() -> {
      for (int i = 0; i < total / 2; i++) {
        try {
          queue.put(counter.incrementAndGet());
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    });
    ForkJoinPool.commonPool().submit(() -> {
      for (int i = 0; i < total / 2; i++) {
        try {
          queue.put(counter.incrementAndGet());
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    });
    Boolean[] arr = new Boolean[total];
    new Thread(new Runnable() {
      @Override
      public void run() {
        while (true) {
          try {
            Integer num = (Integer) queue.take();
            System.out.println(num);
            arr[num - 1] = true;
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }
    }).start();
    Thread.sleep(2_000);
    assert Arrays.stream(arr).allMatch(t -> t);
  }

  @Test
  public void testClh0() throws InterruptedException {
    int size = 100_000;
    int nThread = 8;
    long start = System.currentTimeMillis();
    CountDownLatch cdl = new CountDownLatch(nThread);
//    ReentrantLock lock = new ReentrantLock();
    CLHLock lock = new CLHLock();
    ExecutorService service = Executors.newFixedThreadPool(nThread);
    for (int i = 0; i < nThread; i++) {
      service.execute(() -> {
        for (int j = 0; j < size; j++) {
          lock.lock();
          try {
            Increment.incr();
          } finally {
            lock.unlock();
          }

        }
        cdl.countDown();
      });
    }
    cdl.await();
    System.out.println(
        "cost:" + (System.currentTimeMillis() - start) + "ms,value:" + Increment.get());
    assert Increment.get() == nThread * size;
  }

  static class Increment {

    private static int counter;

    public static void incr() {
      counter += 1;
    }

    public static int get() {
      return counter;
    }
  }

}
