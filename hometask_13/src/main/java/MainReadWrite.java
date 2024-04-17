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

