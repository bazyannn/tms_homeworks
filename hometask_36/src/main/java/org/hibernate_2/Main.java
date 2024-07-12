package org.hibernate_2;


import org.hibernate_2.config.AppConfig;
import org.hibernate_2.domain.OrderEntity;
import org.hibernate_2.domain.PersonEntity;
import org.hibernate_2.service.OrderDataBaseService;
import org.hibernate_2.service.PersonDataBaseService;

import java.util.UUID;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello hibernate part2!");

        PersonEntity personEntity1 = new PersonEntity("dima");  // так проще было отслеживать изменения в таблице
        PersonEntity personEntity2 = new PersonEntity("petya");
        PersonEntity personEntity3 = new PersonEntity("vano");

        OrderEntity order1 = new OrderEntity();
        OrderEntity order2 = new OrderEntity();
        OrderEntity order3 = new OrderEntity();

        personEntity1.addOrder(order1);
        personEntity2.addOrder(order2);
        personEntity2.addOrder(order3);

        AppConfig appConfig = new AppConfig();

        PersonDataBaseService personService = new PersonDataBaseService();
        personService.setAppConfig(appConfig);

        personService.savePerson(personEntity1);
        personService.savePerson(personEntity2);
        personService.savePerson(personEntity3);

        personService.findById(UUID.fromString("73493f60-fb0f-4538-82c8-b1662176e2e3"));

        OrderDataBaseService orderService = new OrderDataBaseService();
        orderService.setAppConfig(appConfig);
        orderService.saveOrder(order1);
        orderService.saveOrder(order2);
        orderService.saveOrder(order3);

        personService.deletePerson(personEntity2);

        orderService.findById(UUID.fromString("e71ba5c8-8daf-4f39-ab2d-43a007b2ad9d"));

        orderService.deleteOrder(order1);
    }
}