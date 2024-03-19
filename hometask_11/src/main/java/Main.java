import java.util.Arrays;

/*
Дана произвольная строка. Необходимо:
1) Вывести длину строки
2) Разбить строку по любому разделителю и вывести количество элементов
3) получить подстроку с определенной позиции до конца
4) сделать строку которая будет зеркальна текущей

Создать произвольный шаблон
Сделать строку используя данный шаблон, вставим некоторые значения
*/
public class Main {
    public static void main(String[] args) {

        String text = "I want to learn java";

        // ---------task1----------

        System.out.println(text.length());

        // ---------task2----------

        String[] arr = text.split(" ");
        System.out.println(Arrays.toString(arr));
        System.out.println(arr.length);

        // ---------task3----------

        System.out.println(text.substring(7, 20));
        System.out.println(text.substring(7)); // вариант

        // ---------task4----------

        StringBuffer sBuff = new StringBuffer(text);  // многопоточка
        StringBuilder sb = new StringBuilder(text);

        System.out.println(sb.reverse());
        System.out.println(sBuff.reverse());

        // ---------task5----------
        String username = "Slava";
        int time = 1;

        String format = String.format("\"%s want to learn java for %s year\"", username, time);
        System.out.println(format);
    }

}

