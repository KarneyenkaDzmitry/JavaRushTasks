package com.javarush.task.task26.task2612;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* 
Весь мир играет комедию
*/
public class Solution {
    private Lock lock = new ReentrantLock();

    public void someMethod() {
        try{
            boolean l = lock.tryLock();
            if (l){
                try {
                    ifLockIsFree();
                } catch (Exception e) {
                    e.printStackTrace();
                }finally{
                    lock.unlock();
                }

            }else{
                ifLockIsBusy();
            }
        }catch (Exception  e){

        }
        //implement logic here, use the lock field
    }

    public void ifLockIsFree() {
    }

    public void ifLockIsBusy() {
    }
}
