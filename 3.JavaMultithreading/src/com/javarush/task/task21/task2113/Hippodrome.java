package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Дмитрий on 24.09.2017.
 */
public class Hippodrome implements Runnable{
    private List<Horse> horses;
    static Hippodrome game;
    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public void move(){
        for (int i = 0; i<horses.size();i++) {
            horses.get(i).move();
        }
    }

    public void run(){
        for (int i = 0; i <100 ; i++) {
            move();
            print();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void print(){
        for (int i = 0; i <horses.size() ; i++) {
            horses.get(i).print();
        }
        for (int i = 0; i <10 ; i++) {
            System.out.println("");
        }
    }
    public Horse getWinner(){
        double winDistance=0.0;
        int n=0;
        for (int i = 0; i <getHorses().size() ; i++) {
            if (getHorses().get(i).getDistance()>winDistance){winDistance = getHorses().get(i).getDistance(); n=i;}
        }
        return getHorses().get(n);
    }

    public void printWinner(){
        System.out.println("Winner is "+getWinner().getName()+"!");
    }

    public static void main(String[] args)  {
        Horse horse1 = new Horse("Horse1",3.0,0.0);
        Horse horse2 = new Horse("Horse2",3.0,0.0);
        Horse horse3 = new Horse("Horse3",3.0,0.0);
        game = new Hippodrome(new ArrayList<Horse>());
        game.getHorses().add(horse1);
        game.getHorses().add(horse2);
        game.getHorses().add(horse3);
        game.run();
        game.printWinner();
    }
}
