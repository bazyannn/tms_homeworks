/*
Создать коллекцию пользователей
        У каждого пользователя есть следующие поля:
        имя (не уникальное)
        стаж работы (пусть будет уникальное для всех)
        список задач (любое представление - можно строками, можно обьектами)
        Найти всех пользователей, у который количество задач больше 2
        Вывести всех пользователей по стажу работы (от большего к меньшему)
        Вывести только уникальные имена пользователей

        используйте для этого наиболее подходящие коллекции
*/

import java.util.*;

public class MainTypeCollection {

    public static void main(String[] args) {

        List<User> userList = new ArrayList<>();
        userList.add(new User("Ivan", 10, null));
        userList.add(new User("Olya", 15, List.of("Write", "Read")));
        userList.add(new User("Petya", 20, List.of("Read", "Learn", "Write")));
        userList.add(new User("Ivan", 25, List.of("Read", "Write", "Teach")));

        //        -----------------task1-------------------

        List<User> usersTask = new ArrayList<>();

        for (User user : userList){
            List<String> taskList = user.getTaskList();

            if (isEmpty(user.getTaskList())){
                continue;
            }

            if (taskList.size() > 2){
                usersTask.add(user);
            }
        }

        System.out.println(usersTask);

        //        -----------------task2-------------------

        Set<User> userExp = new TreeSet<>(); //  Set<User> userExp = new TreeSet<>(userList);

        userExp.addAll(userList);

        System.out.println(userExp);

        //        -----------------task3-------------------

        Set<User> userUnic = new HashSet<>(userList);

        System.out.println(userUnic);

    }
    public static boolean isEmpty(List<?> objects){
        return objects == null || objects.isEmpty();
    }
}
