/*Подключить hibernate к проекту.
Создать конфигурацию для фреймворка.
Настроить отображения sql запросов и автоматического создания таблиц.
Описать Entity объект для хранения сведений о персоне.
Необходимо создать следующие поля
UUID id (сделать автогенерацию)
String name
Integer salary
Type role (enum USER or ADMIN)
Для enum использовать хранения в виде строк
        Создать одного Person и сохранить в бд, используя hibernate
        Имя таблицы должно быть - persons*/

package org.hibernate;

import org.hibernate.domain.PersonEntity;
import org.hibernate.domain.Type;
import org.hibernate.config.AppConfig;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello Hibernate");

        PersonEntity personEntity = new PersonEntity();
        personEntity.setName("Vano");
        personEntity.setSalary(2000);
        personEntity.setRole(Type.ADMIN);

        AppConfig appConfig = new AppConfig();
        Session session = appConfig.sessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(personEntity);
        transaction.commit();
        session.close();
    }
}