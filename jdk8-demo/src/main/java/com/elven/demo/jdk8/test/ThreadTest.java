package com.elven.demo.jdk8.test;

import java.io.*;

/**
 * Created by Administrator on 2016/10/14.
 */
public class ThreadTest {
    public static void main(String[] args) throws InterruptedException, IOException {
//        baseTest();
//        priorityTest();

//        daemonTest();

//        notifyTest();
//        notifyTest2();
//        notifyTest3();
//        sleepTest();
//        joinTest();
//        communicationTest2();

//        sharedVaribleTest();

//        syncTest();
        sharedVaribleTest4();
    }


    private static void sharedVaribleTest4() throws InterruptedException {
        MyRunner3 runner = new MyRunner3();
        Thread thread1 = new Thread(runner);
        Thread thread2 = new Thread(runner);
        thread1.setDaemon(true);
        thread2.setDaemon(true);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
    }

    private static void syncTest() throws InterruptedException {
        MyNonSyncRunner runner = new MyNonSyncRunner();
        Thread thread1 = new Thread(runner);
        Thread thread2 = new Thread(runner);
        thread1.setDaemon(true);
        thread2.setDaemon(true);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
    }

    private static void sharedVaribleTest() throws InterruptedException {
        MyRunner1 runner = new MyRunner1();
        Thread thread1 = new Thread(runner);
        Thread thread2 = new Thread(runner);
        thread1.setDaemon(true);
        thread2.setDaemon(true);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
    }

    public static void communicationTest() throws IOException, InterruptedException {
        final PipedOutputStream pos = new PipedOutputStream();
        final PipedInputStream pis = new PipedInputStream(pos);

        Thread thread1 = new Thread() {
            public void run() {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                try {
                    while (true) {
                        String message = br.readLine();
                        System.out.println("thread1 println:" + message);
                        pos.write(message.getBytes());
                        if (message.equals("end")) break;
                    }
                    br.close();
                    pos.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        };

        Thread thread2 = new Thread() {
            public void run() {
                byte[] buffer = new byte[1024];
                int bytesRead = 0;
                try {
                    while ((bytesRead = pis.read(buffer, 0, buffer.length)) != -1) {
                        System.out.println("thread2 println:" + new String(buffer));
                        if (new String(buffer).equals("end")) break;
                        buffer = null;
                        buffer = new byte[1024];
                    }
                    pis.close();
                    buffer = null;
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        };

        thread1.setDaemon(true);
        thread2.setDaemon(true);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
    }


    private static void communicationTest2() throws InterruptedException, IOException {
        final PipedWriter pw = new PipedWriter();
        final PipedReader pr = new PipedReader(pw);
        final BufferedWriter bw = new BufferedWriter(pw);
        final BufferedReader br = new BufferedReader(pr);

        Thread thread1 = new Thread() {
            public void run() {

                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                try {
                    while (true) {
                        String message = br.readLine();
                        System.out.println("thread1 println:" + message);
                        bw.write(message);
                        bw.newLine();
                        bw.flush();
                        if (message.equals("end")) break;
                    }
                    br.close();
                    pw.close();
                    bw.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        };

        Thread thread2 = new Thread() {
            public void run() {

                String line = null;
                try {
                    while ((line = br.readLine()) != null) {
                        System.out.println("thread2 println:" + line);
                        if (line.equals("end")) break;
                    }
                    br.close();
                    pr.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        };

        thread1.setDaemon(true);
        thread2.setDaemon(true);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
    }

    private static void joinTest() throws InterruptedException {
        Thread thread = new Thread() {
            public void run() {
                try {
                    for (int i = 0; i < 5; i++) {
                        System.out.println("线程在运行。");
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        };
        thread.setDaemon(false);
        thread.start();
        Thread.sleep(1000);
        thread.join();
        System.out.println("主线程正常结束。");
    }

    private static void sleepTest() throws InterruptedException {
        Thread thread = new Thread() {
            public void run() {
                System.out.println("线程 " + Thread.currentThread().getName() + "将要休眠5分钟。");
                try {
                    Thread.sleep(60 * 1000);
                } catch (InterruptedException ex) {
                    System.out.println("线程 " + Thread.currentThread().getName() + "休眠被中断。");
//                    return;
                }
                System.out.println("线程 " + Thread.currentThread().getName() + "休眠结束。");
            }
        };
        thread.setDaemon(true);
        thread.start();
        thread.sleep(1000);
        thread.interrupt();
    }

    public static void baseTest() {
        String name = Thread.currentThread().getName();
        int priority = Thread.currentThread().getPriority();
        String groupName = Thread.currentThread().getThreadGroup().getName();
        boolean isDaemon = Thread.currentThread().isDaemon();
        System.out.println("Thread Name:" + name);
        System.out.println("Priority:" + priority);
        System.out.println("Group Name:" + groupName);
        System.out.println("IsDaemon:" + isDaemon);

        Thread.currentThread().setName("Test");
        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
//        Thread.currentThread().setDaemon(true);
        name = Thread.currentThread().getName();
        priority = Thread.currentThread().getPriority();
        groupName = Thread.currentThread().getThreadGroup().getName();
        isDaemon = Thread.currentThread().isDaemon();
        System.out.println("Thread Name:" + name);
        System.out.println("Priority:" + priority);
        System.out.println("Group Name:" + groupName);
        System.out.println("IsDaemon:" + isDaemon);
    }

    public static void priorityTest() {
        Thread thread1 = new Thread("low") {
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println("Thread 1 is running.");
                }
            }
        };

        Thread thread2 = new Thread("high") {
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println("Thread 2 is running.");
                }
            }
        };

        thread1.setPriority(Thread.MIN_PRIORITY);
        thread2.setPriority(Thread.MAX_PRIORITY);
        thread1.start();
        thread2.start();
    }

    public static void daemonTest() {
        Thread thread1 = new Thread("daemon") {
            public void run() {
                Thread subThread = new Thread("sub") {
                    public void run() {
                        for (int i = 0; i < 100; i++) {
                            System.out.println("Sub Thread Running " + i);
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                };
                subThread.setDaemon(true);
                subThread.start();
                System.out.println("Main Thread end.");
            }
        };

        thread1.start();
    }

    private static void notifyTest() throws InterruptedException {
        MyThread[] arrThreads = new MyThread[3];
        for (int i = 0; i < arrThreads.length; i++) {
            arrThreads[i] = new MyThread();
            arrThreads[i].id = i;
            arrThreads[i].setDaemon(true);
            arrThreads[i].start();
        }
        Thread.sleep(500);
        for (int i = 0; i < arrThreads.length; i++) {
            synchronized (arrThreads[i]) {
                arrThreads[i].notify();
            }
        }
    }

    private static void notifyTest2() throws InterruptedException {
        MyRunner[] arrMyRunners = new MyRunner[3];
        Thread[] arrThreads = new Thread[3];
        for (int i = 0; i < arrThreads.length; i++) {
            arrMyRunners[i] = new MyRunner();
            arrMyRunners[i].id = i;
            arrThreads[i] = new Thread(arrMyRunners[i]);
            arrThreads[i].setDaemon(true);
            arrThreads[i].start();
        }
        Thread.sleep(500);
        for (int i = 0; i < arrMyRunners.length; i++) {
            synchronized (arrMyRunners[i]) {
                arrMyRunners[i].notify();
            }
        }
    }

    private static void notifyTest3() throws InterruptedException {
        MyRunner runner = new MyRunner();
        Thread[] arrThreads = new Thread[3];
        for (int i = 0; i < arrThreads.length; i++) {
            arrThreads[i] = new Thread(runner);
            arrThreads[i].setDaemon(true);
            arrThreads[i].start();
        }
        Thread.sleep(500);

        synchronized (runner) {
            runner.notifyAll();
        }
    }
}

class MyThread extends Thread {
    public int id = 0;

    public void run() {
        System.out.println("第" + id + "个线程准备休眠5分钟。");
        try {
            synchronized (this) {
                this.wait(5 * 60 * 1000);
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.out.println("第" + id + "个线程被唤醒。");
    }
}

class MyRunner implements Runnable {
    public int id = 0;

    public void run() {
        System.out.println("第" + id + "个线程准备休眠5分钟。");
        try {
            synchronized (this) {
                this.wait(5 * 60 * 1000);
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.out.println("第" + id + "个线程被唤醒。");
    }

}

class MyRunner1 implements Runnable {
    public int sum = 0;

    public void run() {
        System.out.println(Thread.currentThread().getName() + " Start.");
        for (int i = 1; i <= 100; i++) {
            sum += i;
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " --- The value of sum is " + sum);
        System.out.println(Thread.currentThread().getName() + " End.");
    }
}

class MyNonSyncRunner implements Runnable {
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Start.");
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + " Running step " + i);
            try {
                Thread.sleep(50);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " End.");
    }
}

class MyRunner3 implements Runnable {
    public ThreadLocal<Integer> tl = new ThreadLocal<Integer>();

    public void run() {
        System.out.println(Thread.currentThread().getName() + " Start.");
        for (int i = 0; i <= 100; i++) {
            if (tl.get() == null) {
                tl.set(new Integer(0));
            }
            int sum = ((Integer) tl.get()).intValue();
            sum += i;
            tl.set(new Integer(sum));
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(Thread.currentThread().getName() + " --- The value of sum is " + ((Integer) tl.get()).intValue());
        System.out.println(Thread.currentThread().getName() + " End.");
    }
}