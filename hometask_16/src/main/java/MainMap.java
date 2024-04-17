/*Задача 1:
На вход поступает массив строк, верните Map<String, Boolean>, где каждая отдельная
строка является ключом, и ее значение равно true, если эта строка встречается в массиве
2 или более раз. Пример:
wordMultiple(["a", "b", "a", "c", "b"]) → {"a": true, "b": true, "c": false}
wordMultiple(["c", "b", "a"]) → {"a": false, "b": false, "c": false}
wordMultiple(["c", "c", "c", "c"]) → {"c": true}

Задача 2:
На вход поступает массив непустых строк, создайте и верните Map<String,
String> следующим образом: для каждой строки добавьте ее первый символ в
качестве ключа с последним символом в качестве значения. Пример:
pairs(["code", "bug"]) → {"b": "g", "c": "e"}
pairs(["man", "moon", "main"]) → {"m": "n"}
pairs(["man", "moon", "good", "night"]) → {"g": "d", "m": "n", "n": "t"}*/

import java.util.*;

public class MainMap {

    public static void main(String[] args) {

        // -------------------task1-----------------
        List<String> stringList = new ArrayList<>(List.of("a", "b", "c", "a", "d", "b", "e", "a", "f", "k"));

        Map<String, Boolean> wordMultiple = new HashMap<>();

        for (int i = 0; i < stringList.size(); i++) {

            if (wordMultiple.containsKey(stringList.get(i))) {
                wordMultiple.put(stringList.get(i), true);
            } else {
                wordMultiple.put(stringList.get(i), false);
            }
        }

        System.out.println(wordMultiple);

        // -------------------task2-----------------

        List<String> strings = new ArrayList<>();
        strings.add("man");
        strings.add("moon");
        strings.add("good");
        strings.add("night");

        Map<String, String> stringMap = new HashMap<>();

        for (String string : strings) {
            char[] charArray = string.toCharArray();
            String key = String.valueOf(charArray[0]);
            String value = String.valueOf(charArray[charArray.length - 1]);
            stringMap.put(key, value);
        }

        System.out.println(stringMap);

    }
}









