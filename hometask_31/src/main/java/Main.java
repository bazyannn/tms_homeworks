/*Пишем проект - ипподром

        Проект представляет собой игру, где пользователь делает ставки на выйгрыш определенной лошади.
        Требования - пользователю предоставляется определенная сумма на депозите. Он может делать ставки на выигрыш
        определенной лошади. Количество лошадей выводится перед началом гонки. Пользователь выбирает номер лошади и указывает свою ставку.
        Далее программа эмалирует скачки, где по итогу побеждает одна из предложенных лошадей.
        Если пользователь верно указал номер - ему возвращается удвоенная сумма ставки, если не верно - то он теряет ставку.
        Так происходит до тех пор пока на его депозите есть положительный баланс.

        Доп задание - сделать красивый вывод эмуляции гонки и рандомные выигрыши среди лошадей.

        Все классы по возможности описать через любые конфигурации spring*/

import org.example.spring.HippodromeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext("org.example.config");
        HippodromeService hippodrome = context.getBean(HippodromeService.class);
        hippodrome.run();
    }
}
