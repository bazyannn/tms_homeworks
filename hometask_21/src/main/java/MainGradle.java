/*Создать Gradle модуль и подключить любую зависимость
        (Как вариант commons-io, commons-lang, commons-collection4)
Создать java класс и попробовать вызвать метод сторонней библиотеки
Написать свою задачу в Gradle (см пример ниже)
Запустить ее командой gradle <<имя задачи>>
task("имя").doLast{
    println "hello"
}
Подключить плагин war
Проверить что появилась соответсвующая задача*/

import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MainGradle {

    public static void main(String[] args) {

        List<Integer> integerList = new ArrayList<>(List.of(1,2,3,4,5,6,7,8,9));

        Collection<Integer> removeCount = CollectionUtils.removeCount(integerList, 3, 3);

        boolean equalCollection = CollectionUtils.isEqualCollection(integerList, removeCount);

        System.out.println(removeCount);

        System.out.println(equalCollection);



    }
}
