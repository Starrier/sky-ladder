package org.starrier.sky.ladder.basic.thread;

/**
 * @author starrier
 * @date 2020/12/1
 */
public class CustomThreadPoolTest {

    public static void main(String[] args) {
        // 创建3个线程的线程池
        CustomThreadPool t = CustomThreadPool.getThreadPool(3);
        t.execute(new Runnable[]{new Task(), new Task(), new Task()});
        t.execute(new Runnable[]{new Task(), new Task(), new Task()});
        System.out.println(t);
        // 所有线程都执行完成才destory
        t.destroy();
        System.out.println(t);
    }

    /**
     * 任务类
     */
    static class Task implements Runnable {
        private static volatile int i = 1;

        @Override
        public void run() {// 执行任务
            System.out.println("任务 " + (i++) + " 完成");
        }
    }
}
