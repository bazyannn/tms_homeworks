/*
При решении задач можно использовать как существующие функциональные интерфейсы, так и создать свои
Задача 1:
используя Function реализовать лямбду, которая будет принимать в себя строку в
формате “*сумма* BYN”(через пробел, вместо *сумма* вставить любое значение), а
        возвращать сумму, переведенную сразу в доллары.
        Задача 2:
используя Consumer реализовать лямбду, которая будет принимать в себя строку в
формате “*сумма* BYN”(через пробел, вместо *сумма* вставить любое значение), а
        выводить сумму, переведенную сразу в доллары.
        Задача 3:
спользуя Supplier написать метод, который будет возвращать введенную с консоли
строку задом наперед.
*/

import java.util.Arrays;
import java.util.Scanner;

public class MainLambda {

    public static void main(String[] args) {

        //-------------------task1-----------------------

        ConvertService service = new ConvertService();
        service.setCourse(2.35);        // это будет нарушать принцип чистой функции???
        System.out.println(service.convertToUsd(String.format("%d BYN", 2000)));

        //-------------------task2-----------------------

        ConvertConsumer consumer = (value) ->
                System.out.println(value.replace(value, String.format("%d USD", (int) (Integer.parseInt(value.split(" ")[0]) / 3.2614))));

/*
            String[] s = value.split(" ");
            int byn = Integer.parseInt(s[0]);
            int convert = (int) (byn / 3.2614);
            System.out.println(value.replace(value,String.format("%d USD", convert)));
*/

        consumer.convert(String.format("%d BYN", 2000));

        // ---------------task3------------------
        ReversSupplier revers = () -> new StringBuilder(new Scanner(System.in).next()).reverse().toString();
/*
          Scanner scanner = new Scanner(System.in);
          String next = scanner.next();
          String result = "";                               // с помощью for
          for (int i = next.length()-1; i >= 0 ; i--)
            result += next.charAt(i);
            return result;
          StringBuilder result = new StringBuilder(next);   // с помощью StringBuilder
          return result.reverse().toString();
        };
*/

        System.out.println(revers.reversString());

    }
}
