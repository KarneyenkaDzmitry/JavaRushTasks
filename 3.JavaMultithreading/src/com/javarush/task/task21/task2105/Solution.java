package com.javarush.task.task21.task2105;

import java.util.HashSet;
import java.util.Set;

/* 
Исправить ошибку. Сравнение объектов
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }
/*      @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!(o instanceof OurClass)) return false;
            OurClass our = (OurClass) o;
            if (first != null ? !first.equals(our.first) : our.first != null) return false;
            Repeat last if(){} as many times as we will have parametries - 1 (second, third, and so on)
            And the last line must be
            return last != null ? last.equals(our.last) : our.last == null;
        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            repeat last line as many times as we will have parametries(second, third and so on );
            return result;
        }*/
@Override
public int hashCode() {
    int result = first != null ? first.hashCode() : 0;
    result = 17 * result + (last != null ? last.hashCode() : 0);
    return result;
}

    public boolean equals(Object o) {
        if (this==o)return true;
        if (o==null) return false;
        if (getClass()!=o.getClass()) return false;
        if (!(o instanceof Solution))return false;
        Solution n = (Solution) o;
        if (first!=null?!first.equals(n.first): n.first!=null)return false;
        return last!=null?(last.equals(n.last)) : n.last==null;

    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Mickey", "Mouse"));
        Solution solution = new Solution("Mickey", "Mouse");
        System.out.println(s.contains(solution));
        Solution solution1 = new Solution(null, null);
        Solution solution2 = solution1;
        Object o = new Object();
        System.out.println(solution.hashCode());
        System.out.println(solution1.hashCode());
        System.out.println(solution1.equals(o));
    }
}
