package com.javarush.task.task20.task2025;

import java.util.ArrayList;
import java.util.Arrays;

/*
import java.util.Arrays;

//Алгоритмы-числа


public class Solution {
    public static long[] ArmstrongNumbers = { 1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 153L, 370L, 371L, 407L, 1634L, 8208L, 9474L,
            54748L, 92727L, 93084L, 548834L, 1741725L, 4210818L, 9800817L, 9926315L, 24678050L, 24678051L, 88593477L,
            146511208L, 472335975L, 534494836L, 912985153L, 4679307774L, 32164049650L, 32164049651L, 40028394225L,
            42678290603L, 44708635679L, 49388550606L, 82693916578L, 94204591914L, 28116440335967L, 4338281769391370L,
            4338281769391371L, 21897142587612075L, 35641594208964132L, 35875699062250035L};
    public static long[] getNumbers(long N){
        int n=0;
        for (long l :ArmstrongNumbers) {
            if(NumberOf(l)<NumberOf(N)){
                n++;
            }else break;
        }
        return Arrays.copyOfRange(ArmstrongNumbers,0, n);
    }
    public static int NumberOf(long n){
        return (int)Math.log10(n)+1;
    }

    public static void main(String[] args) {
        long value = 6000;
        long[] list = getNumbers(value);
        for (long l :list) {
            System.out.println(l);
        }
    }
}
*/
/*
public class Solution {
    public static long[] getNumbers(long N) {
        List list = ArmstrongNumbersMultiSetLongOpt.generate((int) (Math.log10(N) + 1));
        long[] a = new long[list.size()];
        for (int i = 0; i < list.size(); i++) {
            a[i] = (long)list.get(i);
        }
        return a;
    }

    public static void main(String[] args) {

    }
}
*/
public class Solution {

    public static long[] getNumbers(long N) {
        long[] resultFull = null;
        ArrayList<Long> listResults  = new ArrayList<Long>();
        int degree = (int)Math.log10(N)+1;
        long maxNumber = pow(10, degree-1);
        for (long i = 1; i < maxNumber; i++) {
            if (i < 10) {
                listResults.add(i);
            } else {
                String line = "" + i;
                char[] array = line.toCharArray();
                int[] numbers = new int[array.length];

                for (int j = 0; j < array.length; j++) {
                    numbers[j] = Integer.parseInt(Character.toString(array[j]));
                }

                long summ = 0;
                for (int n :numbers) {
                    summ=summ + pow(n, numbers.length);
                    }
                if (summ==i){listResults.add(i);}
            }
        }
        resultFull = new long[listResults.size()];

        for (int x = 0; x <listResults.size() ; x++) {
            resultFull[x] = listResults.get(x);
        }
        return resultFull;
    }

    public static long pow(int number, int degree){
        long result = 1;
        for (int i=0;i<degree;i++){
            result*=number;
        }
        return result;
    }

    public static void main(String[] args) {
        Long t0 = System.currentTimeMillis();
        long memoryStart = Runtime.getRuntime().freeMemory();

        Long number = Long.MAX_VALUE;
        long list[] = Solution.getNumbers(number);
        for (long l:list) {
            System.out.println(l);
        }
        Long t1 = System.currentTimeMillis();
        System.out.println("");
        System.out.println("Time = " + (((double)t1-t0)/1000) + " sec.");
        long totalMem = Runtime.getRuntime().totalMemory();
        Runtime.getRuntime().freeMemory();
        System.out.println(String.format("Mem : %.2f Mb.", 1.0 * (totalMem - memoryStart )/ (1024 * 1024)));
    }
}
/*http://rextester.com/    - на этом ресурсе можно протестировать свою программу и узнать как долго она работает и сколко ресурса жрёт.

вот это все числа армстронга.
 Натуральное десятичное N - значное число называется числом Армстронга, если сумма его цифр, возведенных в степень N, равна самому числу.

Примеры: 153 = 1^3 + 5^3 + 3^3 ; 1634 = 1^4 + 6^4 + 3^4 + 4^4.

Найти все числа Армстронга для 1<=N<=9.

Решение

Конечно, данную задачу можно было решить "в лоб", т.е. сделать простой перебор всех 10в9 чисел и каждое число проверить.
 При этом на весьма солидной машине программа могла бы работать достаточно долго. Если бы цель задания заключалась
 только в нахождении чисел Армстронга, а не в составлении универсальной программы, разработка которой могла бы занимать
 большое время, то конечно, лучше было бы за 10 минут написать и 3 часа подождать.

Идея уменьшения класса исследуемых чисел заключается в следующем : можно делать перебор не самих чисел, а значений,
 которые могут получаться в результате степенной суммы ( т.е. суммы цифр числа, возведенных в степень числа цифр
 этого числа ). Здесь используется следующее свойство : от перемены цифр местами в числе степенная сумма не меняется.
 Т.е. например, незачем рассматривать все числа из класса : 135, 153, 315, 351, 531 и 513; достаточно рассмотреть одно
  из них, например, число 135; вычислить его степенную сумму : (135)ст = 153, а потом лишь убедиться в том что число
  153 - это число Армстронга. Этот метод снижает число перебираемых чисел почти в N! раз. Сам же перебор осуществляется
  довольно просто : рассматриваются все числа, у которых любая цифра не меньше предыдущей и не больше последующей.
  Например: 12, 1557, 333 и т.д.

Итак, вышеописанный метод снизил число перебираемых чисел с 109 до приблизительно 200000.
 Но это не все на чем стоит остановливаться. Можно применить еще одну хитрость, которая заключается в следующем :
  можно значительно ускорить вычисление степенной суммы. Можно заметить, что при вычислениях часто приходится
  многократно возводить некоторое число в некоторую степень. Чтобы это оптимизировать вводится двухмерный массив,
   в i-ой строке и j-ом столбце которого находится значение степенной суммы i с основанием j
   (например, Degree[123,j] = 1j + 2j + 3j ). Таким образом , используется значение массива Degree[i,j].
   Это существенно ускоряет процесс вычисления, если это сравнивать с некоторым процессом, в котором используется
    функция Degree(i,j), каждый раз вычисляющая значение ij. Для вычисления выражения 10j аналогичнo используется
    массив Degree10. Нужно заметить, что такая операция возведения в степень в программе вы полняется более 10000 раз;
     матрица Degree заполняется в начале программы, где операция возведения i в степень j выполняется около 8000 раз.

В промежутке 1<=N<=9 программа находит следующие 32 числа Армстронга:

0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 153, 370, 371, 407, 1634, 8208, 9474, 54748, 92727, 93084, 548834, 1741725, 4210818,
9800817, 9926315, 24678050, 24678051, 88593477, 146511208, 472335975, 534494836, 912985153.

вот это все числа армстронга.
1
2
3
4
5
6
7
8
9
153
370
371
407
1634
8208
9474
54748
92727
93084
548834
1741725
4210818
9800817
9926315
24678050
24678051
88593477
146511208
472335975
534494836
912985153
4679307774
32164049650
32164049651
40028394225
42678290603
44708635679
49388550606
82693916578
94204591914
28116440335967
4338281769391370
4338281769391371
21897142587612075
35641594208964132
35875699062250035*/