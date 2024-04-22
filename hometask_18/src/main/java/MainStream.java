/*Задача 1
Необходимо создать следующие объекты:
    1) Товар (поля - название, стоимость, категория (enum), возможность доставки (boolean), список магазинов
        где он есть в наличии, производитель)
    2) Производитель (название, страна)
	3) Магазин (номер, город, адрес, номер телефона)

На вход мы получаем коллекцию всех товаров, у каждого из который указан производитель и список магазинов, где данный
товар можно купить. Должны быть некоторые товары, относящиеся к одному производителю. Некоторые товары должны относится
к одному магазину.

Необходимо выполнить:
1) определить самый дорогой и дешевый товар
2) найти все товары которые возможно доставить до покупателя
3) посчитать среднюю стоимость товара указанной категории
4) найти все товары определенного производителя
5) найти всех названия производителей указанной страны
6) найти все магазины конкретного города
7) найти адрес магазина по указанному номеру телефона
8) все товары указанного номера магазина
9) составить map где ключ это номер магазина, а значение - это номер телефона данного магазина
10) узнать все ли товары указанной категории можно доставить до покупателя
11) посчитать количество магазинов
12) вывести товары отсортированные по стоимости (от большего к меньшему)

Задача 2
Создать стрим из чисел (бесконечно увеличивающихся на 1)

1) Найти среднее значение первых 10 чисел.
2) Пропустить 5 чисел и вывести следующие 10 чисел, которые делятся на 3 без остатка
3) Посчитать сумму 20 подряд идущих чисел*/

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class MainStream {

    public static void main(String[] args) {

        // ------------------ task 1 --------------------

        Shop shopE1 = new Shop(1, "Grodno", "pr.Pobedy 10", "+375291234567");
        Shop shopE2 = new Shop(2, "Grodno", "pr.Svobody 10", "+375291234568");
        Shop shopV1 = new Shop(3, "Vitebsk", "pr.Stroiteley 8", "+375291234522");
        Shop shopV2 = new Shop(4, "Vitebsk", "pr.Frunze 35", "+375291234521");
        Shop shopK1 = new Shop(5, "Minsk", "pr.Nezavisimosti 5", "+375291234571");
        Shop shopK2 = new Shop(6, "Minsk", "pr.Pobediteley 15", "+375291234572");
        Shop shopG1 = new Shop(7, "Brest", "ul. Sovetskaya 22", "+375291234555");
        Shop shopG2 = new Shop(8, "Brest", "pr. Moskovskiy 110", "+375291234556");

        Producer producer1 = new Producer("Prod1", "Belarus");
        Producer producer2 = new Producer("Prod2", "Belarus");
        Producer producer3 = new Producer("Prod3", "Russia");
        Producer producer4 = new Producer("Prod4", "Russia");
        Producer producer5 = new Producer("Prod5", "Germany");
        Producer producer6 = new Producer("Prod6", "Ecuador");
        Producer producer7 = new Producer("Prod7", "Poland");

        Tool tool1 = new Tool("Moloko", 2, Category.MILK, true, List.of(shopE1, shopV1), producer1);
        Tool tool2 = new Tool("Cheese", 22, Category.MILK, false, List.of(shopE1, shopK1), producer2);
        Tool tool3 = new Tool("Tomat", 12, Category.VEGETABLE, false, List.of(shopK1), producer3);
        Tool tool4 = new Tool("Ogurec", 8, Category.VEGETABLE, true, List.of(shopG1), producer4);
        Tool tool5 = new Tool("Sosiski", 10, Category.MEAT, true, List.of(shopV1), producer5);
        Tool tool6 = new Tool("Kolbasa", 24, Category.MEAT, false, List.of(shopG1), producer5);
        Tool tool7 = new Tool("Banan", 5, Category.FRUIT, false, List.of(shopE2, shopV2, shopK2, shopG2), producer6);
        Tool tool8 = new Tool("Apple", 3, Category.FRUIT, true, List.of(shopE2, shopV2, shopK2, shopG2), producer7);

        List<Tool> toolList = new ArrayList<>();
        toolList.add(tool1);
        toolList.add(tool2);
        toolList.add(tool3);
        toolList.add(tool4);
        toolList.add(tool5);
        toolList.add(tool6);
        toolList.add(tool7);
        toolList.add(tool8);

        // ---1) определить самый дорогой и дешевый товар

        Tool toolMin = toolList.stream()
                .min((t, t1) -> t.getPrice() - t1.getPrice())
                .get();
        System.out.println("MIN priceTool: " + toolMin);

        Tool toolMax = toolList.stream()
                .max((t, t1) -> t.getPrice() - t1.getPrice())
                .get();
        System.out.println("MAX priceTool: " + toolMax);


//        List<Tool> toolsPrice = toolList.stream()
//                .sorted((t1,t2) -> t1.getPrice() - t2.getPrice()) //Comparator.comparingInt(Tool::getPrice)
//                .collect(Collectors.toList());                      // toList()
//
//        System.out.println("MIN priceTool: " + toolsPrice.get(0));
//        System.out.println("MAX priceTool: " + toolsPrice.get(toolsPrice.size() - 1));

        // ---2) найти все товары которые возможно доставить до покупателя

        List<Tool> toolsDelivery = toolList.stream()
                .filter(Tool::isDelivery)
                .toList();

        System.out.println(toolsDelivery);

        // ---3) посчитать среднюю стоимость товара указанной категории

        Double avgToolPrice = toolList.stream()
                .filter(tool -> tool.getCategory() == Category.MILK)
                .mapToInt(Tool::getPrice)
                .average()
                .getAsDouble();

        System.out.println(avgToolPrice);

        // ---4) найти все товары определенного производителя

        List<Tool> listToolOfProd = toolList.stream()
                .filter(tool -> tool.getProducer().equals(producer5))
                .toList();

        System.out.println(listToolOfProd);

        // ---5) найти всех названия производителей указанной страны

        List<String> belarus = toolList.stream()
                .filter(tool -> tool.getProducer().getCountry().equals("Belarus"))
                .map(tool -> tool.getProducer().getName())
                .collect(Collectors.toList());

        System.out.println(belarus);

        // ---6) найти все магазины конкретного города

        Set<Shop> townShop = toolList.stream()
                .flatMap(tool -> tool.getShopList().stream())
                .filter(shop -> shop.getTown().equals("Vitebsk"))
                .collect(Collectors.toSet());

        System.out.println(townShop);

        // ---7) найти адрес магазина по указанному номеру телефона

        List<String> listAdressShop = toolList.stream()
                .flatMap(tool -> tool.getShopList().stream())
                .filter(shop -> shop.getPhone().equals("+375291234556"))
                .map(Shop::getAdress)
                .distinct()
                .toList();

        System.out.println(listAdressShop);

        // ---8) все товары указанного номера магазина

        List<Tool> listNumberShop = toolList.stream()
                .filter(shop -> isNumber(shop.getShopList()))
                .toList();

        System.out.println(listNumberShop);

        // ---9) составить map где ключ это номер магазина, а значение - это номер телефона данного магазина

        Map<Integer, String> collectMap = toolList.stream()
                .flatMap(tool -> tool.getShopList().stream())
                .distinct()
                .collect(Collectors.toMap(Shop::getNumber, Shop::getPhone));

        System.out.println(collectMap);

        // ---10) узнать все ли товары указанной категории можно доставить до покупателя

        boolean allMatch = toolList.stream()
                .filter(tool -> tool.getCategory() == Category.MILK)
                .allMatch(tool -> tool.isDelivery());
        System.out.println(allMatch);

        // ---11) посчитать количество магазинов

        long count = toolList.stream()
                .flatMap(tool -> tool.getShopList().stream())
                .distinct()
                .count();

        System.out.println(count);

        // ---12) вывести товары отсортированные по стоимости (от большего к меньшему)

        List<Tool> maxPrice = toolList.stream()
                .sorted((t1, t2) -> t2.getPrice() - t1.getPrice())
                .toList();

        System.out.println(maxPrice);

        // ------------------ task 2 --------------------

        // ---1) Найти среднее значение первых 10 чисел.

        double average = IntStream.iterate(1, value -> value + 1)
                .limit(10)
                .average()
                .getAsDouble();

        System.out.println(average);

        // ---2) Пропустить 5 чисел и вывести следующие 10 чисел, которые делятся на 3 без остатка

        List<Integer> integerList = Stream.iterate(1, val -> val + 1)
                .skip(5)
                .filter(v -> v % 3 == 0)
                .limit(10)
                .toList();
        System.out.println(integerList);

        // ---3) Посчитать сумму 20 подряд идущих чисел

        Integer sum = IntStream.iterate(1, n -> n + 1)
                .limit(20)
                .sum();

        System.out.println(sum);


    }

    public static boolean isNumber(List<Shop> shopList) {
        return shopList.stream()
                .anyMatch(shop -> shop.getNumber() == 4);
    }

}
