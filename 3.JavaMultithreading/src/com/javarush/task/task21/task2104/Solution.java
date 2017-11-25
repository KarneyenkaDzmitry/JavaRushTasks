package com.javarush.task.task21.task2104;

import java.util.HashSet;
import java.util.Set;

/* 
Equals and HashCode
*/
public class Solution {
    private final String first, last;

    @Override
    public boolean equals(Object obj) {
        if (this==obj)return true;
        if (obj==null||getClass()!=obj.getClass())return false;
        if (!(obj instanceof Solution))return false;
        Solution s = (Solution)obj;
        if (first!=null ? !first.equals(s.first) : s.first!=null )return false;
        return last!=null ? last.equals(s.last) : s.last==null;
    }

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }


    public int hashCode() {
        int result = first!=null ? first.hashCode() : 0;
        return result = 17 *result + (last!=null ? last.hashCode() : 0);
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Donald", "Duck"));
        System.out.println(s.contains(new Solution("Donald", "Duck")));
    }
}
