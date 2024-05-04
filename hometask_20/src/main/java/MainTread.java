/*Задача 1)
Создать поток используя два способа - через наследованное и имплементируя интерфейс Runnable
Оба потока должны стартовать, после чего основной поток должен дождать ся их завершения и прекратить работу.
        Задача 2)
Есть массив целых чисел.
Необходимо создать два потока - один из которых будет считать максимальное значение,
 а второй - минимальное. Запустить оба потока и дождаться их окончания. Вывести на экран результат вычислений.
        Задача 3)
Создать поток демон и проверить его работу
Задача 4)
Есть два потока - один выводит в бесконечном цикле 3 раза цифру "1" (3 вызова System.out.println),
а второй аналогично - цифру "2". Предусмотреть небольшую задержку.
        Задача - сделать синхронизацию потоков (пока один не закончит вывод трех чисел, второй будет ждать -
        не будет перемешивания)
Проверить что в консоли вы получите поочередное выполнение потоков.*/

import java.util.ArrayList;
import java.util.List;

public class MainTread {

    public static void main(String[] args) throws InterruptedException {

        //-------------task1-----------------

        Thread thrCurrent = Thread.currentThread();

        MyTread myTread = new MyTread();

        myTread.start();

        Thread thread = new Thread(() -> System.out.println("Hello from implement thread"));

        thread.start();

        myTread.join();

        thread.join();

        System.out.println(thrCurrent.getName());

        //-------------task2-----------------

        List<Integer> integerList = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9));


        Thread threadMin = new Thread(() -> new ListUtil(integerList).countMin(integerList));

        Thread threadMax = new Thread(() -> new ListUtil(integerList).countMax(integerList));

//        threadMin.setDaemon(true);   // ---task3
//
//        threadMax.setDaemon(true);   // ---task3

        threadMin.start();

        threadMax.start();

        threadMin.join();

        threadMax.join();

        //-------------task4-----------------

        Marker marker = new Marker();

        Thread thread1 = new Thread(() -> {

            synchronized (marker) {

                while (true) {
                    System.out.println(1);
                    System.out.println(1);
                    System.out.println(1);

                    break;
                }
            }
        });

        Thread thread2 = new Thread(() -> {

            synchronized (marker) {

                while (true) {
                    System.out.println(2);
                    System.out.println(2);
                    System.out.println(2);

                    break;
                }
            }
        });

        thread1.start();

        thread2.start();

    }
}
