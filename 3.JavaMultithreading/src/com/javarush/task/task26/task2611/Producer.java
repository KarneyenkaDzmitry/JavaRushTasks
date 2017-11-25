package com.javarush.task.task26.task2611;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Дмитрий on 07.11.2017.
 */
public class Producer implements Runnable {
    private ConcurrentHashMap<String, String> map;

    public Producer(ConcurrentHashMap<String, String> map) {
        this.map = map;
    }

    @Override
    public void run() {
        int i=1;
        while(true){
            try {
                map.put(""+i,"Some text for "+i++);
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread thread = Thread.currentThread();
                System.out.println("["+thread.getName()+"]"+" thread was terminated");
                break;
            }
        }
    }
}
