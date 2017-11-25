package com.javarush.task.task25.task2509;

import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;

public abstract class SocketTask<T> implements CancellableTask<T> {
    private Socket socket;

    protected synchronized void setSocket(Socket socket) {
        this.socket = socket;
    }

    public synchronized void cancel() {
        Thread.currentThread().interrupt();
        try {
            socket.close();//close all resources here
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public RunnableFuture<T> newTask() {
        return new FutureTask<T>(this) {
            public boolean cancel(boolean mayInterruptIfRunning) {
                if (mayInterruptIfRunning){
                    Thread thread = Thread.currentThread();
                    thread.interrupt();
                    SocketTask.this.cancel();
                    try {
                        thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        super.cancel(mayInterruptIfRunning);
                    }

                }
                //close all resources here by using proper SocketTask method
                //call super-class method in finally block
                return false;
            }
        };
    }
}