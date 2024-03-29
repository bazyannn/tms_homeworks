package org.model;

public class User {

    private String name;
    private TypeProfession profession;
    private int workExperience;

    // конструктор класса
    public User(String name, TypeProfession profession, int workExperience) {
        this.name = name;
        this.profession = profession;
        this.workExperience = workExperience;
    }
    // метод подсчёта зарплаты
    public int rateSalary() {
        int rate = 0;
        switch (profession) {
            case DIRECTOR -> rate = 100;
            case WORKER -> rate = 10;
            case HR -> rate = 25;
        }
        int salary;
        salary = 1000 * getWorkExperience() * rate;
        return salary;
    }

    // метод подсчёта зарплаты + надбавки
    public int addPayment() {
        int salary1 = this.rateSalary();
        int adPay = 0;
        switch (profession) {
            case DIRECTOR -> adPay = 200000;
            case WORKER -> adPay = 50000;
            case HR -> adPay = 100000;
        }
        int adPayment;
        adPayment = salary1 + adPay;
        return adPayment;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TypeProfession getProfession() {
        return profession;
    }

    public void setProfession(TypeProfession profession) {
        this.profession = profession;
    }

    public int getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(int workExperience) {
        this.workExperience = workExperience;
    }
}

