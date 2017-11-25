package com.javarush.task.task25.task2504;

/* 
Switch для нитей
public enum State
{
 NEW,
 RUNNABLE,
 BLOCKED,
 WAITING,
 TIMED_WAITING,
 TERMINATED;
}
*/
public class Solution {
    public static void processThreads(Thread... threads) throws InterruptedException {

            for (int i = 0, n = threads.length; i < n; i++) {
                switch(threads[i].getState()){
                    case NEW: threads[i].start();break;
                    case WAITING: threads[i].interrupt();break;
                    case TIMED_WAITING:threads[i].interrupt();break;
                    case RUNNABLE: if (threads[i].isInterrupted()==true){
                        threads[i].sleep(100);
                    }
                    break;
                    case BLOCKED: threads[i].interrupt();break;
                    case TERMINATED:
                        System.out.println(threads[i].getPriority()); break;
                }

            //implement this method - реализуйте этот метод
        }
    }

    public static void main(String[] args) {
    }
}
