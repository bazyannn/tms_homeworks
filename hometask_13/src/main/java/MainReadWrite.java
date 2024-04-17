/*
В файловой системе необходимо создать вручную файл содержащий пример спектакля Ромео и Джульета.
        При помощи потоков необходимо разбить данный файл на два, в каждом из которых будет находится роль одного из актеров.

        Пример исходного файла

        Romeo: text for Romeo
        Text for Romeo
        Text for Romeo
        Gulieta: text fo Gulieta
        text fo Gulieta
        text fo Gulieta
        text fo Gulieta
        Romeo: text for Romeo
        Text for Romeo
        Text for Romeo

        И тд
        Результат - 2 файла
        "Romeo.txt"
        Romeo: text for Romeo
        Text for Romeo
        Text for Romeo
        Romeo: text for Romeo
        Text for Romeo
        Text for Romeo

        "Gulieta.txt"
        Gulieta: text fo Gulieta
        text fo Gulieta
        text fo Gulieta
        text fo Gulieta
*/

import java.io.*;

public class MainReadWrite {
    public static void main(String[] args) {


        try (LineNumberReader reader = new LineNumberReader(new FileReader("E:\\Romeo & Gulieta.txt"));
             Writer writerRomeo = new FileWriter("E:\\Romeo.txt");
             Writer writerGulieta = new FileWriter("E:\\Gulieta.txt")) {

            Writer writer = null;

            String str = reader.readLine();

            while (str != null) {
                if (str.startsWith("Romeo:")) {
                    writer = writerRomeo;
                }
                if (str.startsWith("Gulieta:")) {
                    writer = writerGulieta;
                }
                writer.write(str + "\n");
                str = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException();
        }

    }
}

