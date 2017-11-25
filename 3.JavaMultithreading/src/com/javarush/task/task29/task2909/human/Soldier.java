package com.javarush.task.task29.task2909.human;

/**
 * Created by Дмитрий on 31.10.2017.
 */
public class Soldier extends Human {
    public Soldier(String name, int age){
        super(name, age);
    }

    @Override
    public void live() {
        //super.live();
        fight();
    }

    public void fight() {
    }
}
