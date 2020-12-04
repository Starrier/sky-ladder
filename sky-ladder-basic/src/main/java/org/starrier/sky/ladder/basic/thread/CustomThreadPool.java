package org.starrier.sky.ladder.basic.thread;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author starrier
 * @date 2020/12/1
 */
public final class CustomThreadPool {

    /**
     * 线程池中默认 工作线程数
     */
    private static int workerNum = 5;
    /**
     * 未处理的任务
     */
    private static volatile int finishedTasks = 0;
    private static CustomThreadPool customThreadPool;
    /**
     * 工作线程
     */
    private WorkThread[] workThreads;
    /**
     * 任务阻塞队列
     */
    private List<Runnable> taskWaitQueue = new ArrayList<>();

    /**
     * 创建一个默认的
     */
    private CustomThreadPool() {
        this(5);
    }

    private CustomThreadPool(int workerNum) {
        CustomThreadPool.workerNum = workerNum;
        workThreads = new WorkThread[workerNum];
        for (int i = 0; i < workerNum; i++) {
            workThreads[i] = new WorkThread();
            workThreads[i].start();
        }
    }

    /**
     * 单态模式，获得一个默认线程个数的线程池
     */
    public static CustomThreadPool getThreadPool() {
        return getThreadPool(CustomThreadPool.workerNum);
    }

    /**
     * 单例模式，获取一个指定线程数的线程池
     *
     * @param workerNum 指定线程数
     * @return 线程池
     */
    public static CustomThreadPool getThreadPool(int workerNum) {
        if (workerNum <= 0) {
            workerNum = CustomThreadPool.workerNum;
        }

        if (customThreadPool == null) {
            customThreadPool = new CustomThreadPool(workerNum);
        }

        return customThreadPool;
    }

    public void execute(Runnable task) {
        synchronized (taskWaitQueue) {
            taskWaitQueue.add(task);
            taskWaitQueue.notify();
        }
    }

    // 批量执行任务,其实只是把任务加入任务队列，什么时候执行有线程池管理器觉定
    public void execute(Runnable[] task) {
        synchronized (taskWaitQueue) {
            taskWaitQueue.addAll(Arrays.asList(task));
            taskWaitQueue.notify();
        }
    }

    public void execute(List<Runnable> task) {
        synchronized (taskWaitQueue) {
            taskWaitQueue.addAll(task);
            taskWaitQueue.notify();
        }
    }

    /**
     * 销毁线程池,该方法保证在所有任务都完成的情况下才销毁所有线程，否则等待任务完成才销毁
     */
    public void destroy() {
        // 如果还有任务没执行完成，就先睡会吧
        while (!taskWaitQueue.isEmpty()) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // 工作线程停止工作，且置为null
        for (int i = 0; i < workerNum; i++) {
            workThreads[i].stopWorker();
            workThreads[i] = null;
        }
        customThreadPool = null;
        // 清空任务队列
        taskWaitQueue.clear();
    }

    // 返回工作线程的个数
    public int getWorkThreadNumber() {
        return workerNum;
    }

    // 返回已完成任务的个数,这里的已完成是只出了任务队列的任务个数，可能该任务并没有实际执行完成
    public int getFinishedTasknumber() {
        return finishedTasks;
    }

    // 返回任务队列的长度，即还没处理的任务个数
    public int getWaitTasknumber() {
        return taskWaitQueue.size();
    }

    // 覆盖toString方法，返回线程池信息：工作线程个数和已完成任务个数
    @Override
    public String toString() {
        return "WorkThread number:" + workerNum + "  finished task number:"
                + finishedTasks + "  wait task number:" + getWaitTasknumber();
    }


    private class WorkThread extends Thread {
        // 该工作线程是否有效，用于结束该工作线程
        private boolean isRunning = true;

        /*
         * 关键所在啊，如果任务队列不空，则取出任务执行，若任务队列空，则等待
         */
        @Override
        public void run() {
            Runnable r = null;
            while (isRunning) {// 注意，若线程无效则自然结束run方法，该线程就没用了
                synchronized (taskWaitQueue) {
                    while (isRunning && taskWaitQueue.isEmpty()) {// 队列为空
                        try {
                            taskWaitQueue.wait(20);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    if (!taskWaitQueue.isEmpty())
                        r = taskWaitQueue.remove(0);// 取出任务
                }
                if (r != null) {
                    r.run();// 执行任务
                }
                finishedTasks++;
                r = null;
            }
        }

        // 停止工作，让该线程自然执行完run方法，自然结束
        public void stopWorker() {
            isRunning = false;
        }
    }

}
