package com.javarush.task.task25.task2506;

/**
 * Created by Дмитрий on 28.10.2017.
 */
class LoggingStateThread extends Thread {
    private Thread thread ;

    public LoggingStateThread(Thread thread) {
        this.thread = thread;
        this.setDaemon(true);
    }
    public void run(){
        State state=thread.getState();
        System.out.println(state);
        while(state!=State.TERMINATED) {
            if (thread.getState()!=state) {

                switch (thread.getState()) {
                    case NEW:
                        state = thread.getState();
                        System.out.println(State.NEW);
                        //System.out.println("New");
                        break;
                    case RUNNABLE: state = thread.getState();
                        System.out.println(State.RUNNABLE);
                        //System.out.println("Runnable");
                        break;
                    case WAITING: state = thread.getState();
                        System.out.println(State.WAITING);
                        //System.out.println("Wait");
                        break;
                    case TIMED_WAITING:
                        state = thread.getState();
                        System.out.println(State.TIMED_WAITING);
                        //System.out.println("Time_Wait");
                        break;
                    case BLOCKED:state = thread.getState();
                        System.out.println(State.BLOCKED);
                        //System.out.println("Blocked");
                        break;
                    case TERMINATED: state = thread.getState();
                        System.out.println(State.TERMINATED);
                        //System.out.println("Tetminate");
                        /*this.interrupt();
                                try {
                                    this.sleep(50);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }*/
                        break;
                }
            }
        }
    }
}
