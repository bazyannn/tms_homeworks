/*Необходимо создать класс Student со следующими полями
        имя
        пол
        возраст
        список занятий, которые студент посещает (список строк)
Необходимо реализовать следующий функционал
вывести всех юношей
найти всех студентов старше 20 лет
найти всех студентов, которые посещают менее 2 занятий
найти всех студентов, которые посещают занятие - программирование*/

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MainCollection {

    public static void main(String[] args) {

        List<Student> studentList = new ArrayList<>();

        studentList.add(new Student("Ivan", true, 19, List.of("английский язык", "математика", "программирование")));
        studentList.add(new Student("Olya", false, 21, List.of("английский язык")));
        studentList.add(new Student("Petya", true, 22, List.of("английский язык", "математика")));

        // -------------------все юноши-------------

        List<Student> studentSex = new ArrayList<>();

        for (Student student : studentList) {
            if (student.isMan()) {
                studentSex.add(student);
            }
        }
        System.out.println("все юноши: " + studentSex);

        // -------------------старше 20 лет-------------

        List<Student> studentAge = new ArrayList<>();

        for (Student student : studentList) {
            if (student.getAge() > 20) {
                studentAge.add(student);
            }
        }

        System.out.println("старше 20 лет: " + studentAge);

        //  -------------------менее 2 занятий-------------

        List<Student> studentClass = new ArrayList<>();

        for (Student student : studentList) {
            List<String> classes = student.getClasses();
            if (classes.size() < 2) {
                studentClass.add(student);
            }
        }
        System.out.println("менее 2 занятий: " + studentClass);


        // -------------------занятие программированние-------------

        List<Student> studentPr = new ArrayList<>();

        Iterator<Student> iterator = studentList.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            List<String> classes = student.getClasses();
            if (classes.contains("программирование")) {
                studentPr.add(student);
            }
        }
        System.out.println("есть программированние: " + studentPr);

//        for (Student student : studentList) {
//            List<String> classes = student.getClasses();
//            if (classes.contains("программирование")) {
//                studentPr.add(student);
//            }
//        }
//
//        System.out.println("есть программированние: " + studentPr);
    }
}

