package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.*;

/* 
Построй дерево(1)
*/
public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {
    Entry<String> root = new Entry<>("0");
    Queue<Entry<String>> queue = new LinkedList<Entry<String>>();
    {
        queue.add(root);
    }

    @Override
    public boolean add(String s) {
        Entry<String> nextEntry=null;
        for (Entry<String> entry:queue) {
            if(entry.isAvailableToAddChildren()) {
                if (entry.availableToAddLeftChildren) {
                    entry.availableToAddLeftChildren=false;
                    nextEntry = new Entry<>(s, entry);
                    queue.add(nextEntry);
                    entry.leftChild=nextEntry;
                    //System.out.println(s+" is added from left. His parent is "+entry.elementName+" in line "+entry.lineNumber);
                    break;
                }else{
                    entry.availableToAddRightChildren=false;
                    nextEntry = new Entry<>(s, entry);
                    queue.add(nextEntry);
                    entry.rightChild=nextEntry;
                    //System.out.println(s+" is added from right. His parent is "+entry.elementName+" in line "+entry.lineNumber);
                    break;
                }
            }
        }

        return nextEntry!=null;
    }

    @Override
    public String set(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean remove(Object o) {
        String name = null;
        if (o instanceof String) name = (String) o;
        else return false;
        for (Entry<String> entry : queue) {
            if (o.equals(entry.elementName)) {
                Entry<String> entryParent = entry.parent;
                if (entryParent.leftChild!=null){
                    if (entryParent.leftChild.elementName.equals(name))
                    {
                        entryParent.leftChild = null;
                    }
                }
                if (entryParent.rightChild!=null&&entryParent.rightChild.elementName.equals(name)) {
                    entryParent.rightChild = null;
                }
                entry.parent = null;
                if (entry.leftChild != null) {
                    remove((Object)entry.leftChild.elementName);
                }
                if (entry.rightChild != null) {
                    remove((Object)entry.rightChild.elementName);
                }
            }
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int size() {
        int size=0;
        for (Entry<String> entry:queue) {
            if (entry.parent!=null)size++;
        }
        return size;
    }

    public String getParent(String s){
        for (Entry<String> entry: queue) {
            if (entry.elementName!=null) {
                if (entry.elementName.equals(s)) {
                    if (entry.parent!=null)
                    return entry.parent.elementName;
                }
            }
        }
        return null;
    }

    static class Entry<T> implements Serializable {
        String elementName;
        int lineNumber;
        boolean availableToAddLeftChildren, availableToAddRightChildren;
        Entry<T> parent, leftChild, rightChild;

        public Entry(String elementName, Entry<T> parent){
            this(elementName);
            lineNumber=parent.lineNumber+1;
            this.parent=parent;
        }

        public Entry(String elementName) {
            this.elementName = elementName;
            availableToAddLeftChildren=true;
            availableToAddRightChildren=true;
        }
        public void checkChildren(){
            availableToAddLeftChildren=(leftChild==null?true:false);
            availableToAddRightChildren=(rightChild==null?true:false);
        }
        public boolean isAvailableToAddChildren(){

            return (availableToAddLeftChildren||availableToAddRightChildren);
        }
    }

    public static void main(String[] args) {
        List<String> list = new CustomTree();
        for (int i = 1; i < 16; i++) {
            list.add(String.valueOf(i));
        }

        System.out.println(list.size());

        System.out.println("Expected 3, actual is " + ((CustomTree) list).getParent("8"));
        list.remove("5");
        //System.out.println(list.size());

        System.out.println("Expected null, actual is " + ((CustomTree) list).getParent("11"));
        //System.out.println("Expected 3, actual is " + ((CustomTree) list).getParent("5"));

    }
}
