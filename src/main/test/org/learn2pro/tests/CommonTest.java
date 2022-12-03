package org.learn2pro.tests;

import java.util.Arrays;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.Test;
import org.learn2pro.test.BlockingQueueSample;

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
            arr[num-1] = true;
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }
    }).start();
    Thread.sleep(2_000);
    assert Arrays.stream(arr).allMatch(t -> t);
  }

}
