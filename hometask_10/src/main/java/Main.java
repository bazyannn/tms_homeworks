
/*Задача:
        1.1 Создать класс Person с 3-мя полями (имя, возраст, зарплата).
        1.2 Переопределить для этого класса hashCode(придумать свою формулу), toString(чтобы
выдавал всю информацию по человеку).
        1.3 Создать класс Cat и добавить в Person поле этого типа (Cat). Соответственно
изменить toString().
        1.4 В main создать объект Person, клонировать его, и поменять для копии имя. Проверить
в консоли с помощью toString что имена оригинала и копии действительно разные.
Сравнить объекты между собой используя equals

 */

public class Main {

    public static void main(String[] args) throws CloneNotSupportedException {

        Cat cat1 = new Cat("Tom");

        Person person1 = new Person("Ivan",33,1000, cat1 );

        Object person2 = (Person)person1.clone();

        System.out.println(person1);
        System.out.println(person2);
        System.out.println(person1.equals(person2));

        person1.setName("Dima");

        System.out.println(person1);
        System.out.println(person2);

        System.out.println(person1.equals(person2));

    }
}
