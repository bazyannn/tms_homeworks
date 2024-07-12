package org.hibernate_2.service;

import lombok.Data;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate_2.config.AppConfig;
import org.hibernate_2.domain.OrderEntity;

import java.util.List;
import java.util.UUID;

@Data

public class OrderDataBaseService {

    private AppConfig appConfig;

    public void saveOrder (OrderEntity order){
        Session session = appConfig.sessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.save(order);

        transaction.commit();
        session.close();
    }
    public void deleteOrder(OrderEntity order) {
        Session session = appConfig.sessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.remove(order);

        transaction.commit();
        session.close();
    }
    public void findById(UUID id) {
        Session session = appConfig.sessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        OrderEntity orderEntity = session.createQuery("FROM OrderEntity ", OrderEntity.class)
                .stream()
                .filter(order -> order.getId().equals(id))
                .findFirst()
                .get();

//        List<OrderEntity> fromOrderEntity = session.createQuery("FROM OrderEntity ", OrderEntity.class)
//                .stream()
//                .filter(order -> order.getId().equals(id))
//                .toList();
//        OrderEntity orderEntity = fromOrderEntity.get(0);

        System.out.println(orderEntity);

        transaction.commit();
        session.close();
    }
}
