package org.model;

public class Main {

    public static void main(String[] args) {

        User user1 = new User("Petya", TypeProfession.DIRECTOR, 10);
        User user2 = new User("Vanya", TypeProfession.WORKER, 20);
        User user3 = new User("Sasha", TypeProfession.HR, 15);

        System.out.println("Salary for workers: ");

        System.out.println(user1.getName() + " " + user1.rateSalary() + "$");
        System.out.println(user2.getName() + " " + user2.rateSalary() + "$");
        System.out.println(user3.getName() + " " + user3.rateSalary() + "$");

        System.out.println("Additional payment for workers: ");

        System.out.println(user1.getName() + " " + user1.addPayment() + "$");
        System.out.println(user2.getName() + " " + user2.addPayment() + "$");
        System.out.println(user3.getName() + " " + user3.addPayment() + "$");

    }
}
