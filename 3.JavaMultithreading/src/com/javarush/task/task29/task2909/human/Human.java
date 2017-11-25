package com.javarush.task.task29.task2909.human;



import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Human implements Alive {
    private List<Human> children = new ArrayList<>();

    private static int nextId = 0;
    private int id;
    protected int age;
    protected String name;
    protected Size size;
    private BloodGroup bloodGroup;

    public void setBloodGroup(BloodGroup bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public BloodGroup getBloodGroup() {
        return bloodGroup;
    }

    public Human(String name,int age) {
        this.name=name;
        this.age=age;
        this.id = nextId;
        nextId++;
    }
    public class Size{
        public int weight,height;

        public Size(int weight, int height) {
            this.weight = weight;
            this.height = height;
        }
    }
    public String getPosition(){
        return "Человек";
    }

    public List<Human> getChildren() {
        return Collections.unmodifiableList(children);
    }

    public void addChild(Human human){
        children.add(human);
    }
    public void removeChild(Human human){
        for (Human h: children) {
            if (human.equals(h)){
                children.remove(h); break;
            }
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    @Override
    public void live() {

    }
    public void printData() {
        System.out.println(this.getPosition() +": "+ this.name);
    }

    public int getId() {
        return id;
    }

    public void printSize() {
        System.out.println("Рост: " + size.height + " Вес: " + size.weight);
    }
}