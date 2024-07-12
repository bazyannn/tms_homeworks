package org.hibernate_2.service;

import lombok.Data;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate_2.config.AppConfig;
import org.hibernate_2.domain.PersonEntity;

import java.util.List;
import java.util.UUID;


@Data
public class PersonDataBaseService {

    private AppConfig appConfig;

    public void savePerson(PersonEntity person) {
        Session session = appConfig.sessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.save(person);

        transaction.commit();
        session.close();
    }

    public void deletePerson(PersonEntity person) {
        Session session = appConfig.sessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.remove(person);

        transaction.commit();
        session.close();
    }

    public void findById(UUID id) {
        Session session = appConfig.sessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        // вариант 1
        PersonEntity personEntity = session.createQuery("FROM PersonEntity ", PersonEntity.class)
                .stream()
                .filter(person -> person.getId().equals(id))
                .findFirst()
                .get();

        // вариант 2
//        List<PersonEntity> fromPersonEntity = session.createQuery("FROM PersonEntity ", PersonEntity.class)
//                .stream()
//                .filter(person -> person.getId().equals(id))
//                .toList();
//        PersonEntity personEntity = fromPersonEntity.get(0);

        // какой вариант лучше(корректнее)?

        System.out.println(personEntity);

        transaction.commit();
        session.close();
    }

    public void findByName(String name) {
        Session session = appConfig.sessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<PersonEntity> resultList = session.createQuery("FROM PersonEntity where name= :name", PersonEntity.class)
                .setParameter("name", name)
                .getResultList();

        System.out.println(resultList);

        transaction.commit();
        session.close();
    }

    public void findByAge(Integer age){
        Session session = appConfig.sessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        List resultList = session.createQuery("FROM PersonEntity p where p.age < :age")
                .setParameter("age", age)
                .list();

        System.out.println(resultList);

        transaction.commit();
        session.close();
    }
}
