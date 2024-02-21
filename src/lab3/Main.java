package lab3;

import java.io.*;
import java.util.Scanner;

//Преобразовать текст так, чтобы каждое слово, не содержащее неалфавитных символов, начиналось с заглавной буквы.
//При выполнении следующих заданий для вывода результатов создавать новую директорию и файл средствами класса File.
public class Main {
    public static void main(String[] args) {
        String directoryName = System.getProperty("user.dir");
        File directory = new File(directoryName + "/src/lab3/result");
        if (!directory.exists()) {
            directory.mkdir();
        }
        final File FILE = new File("src/lab3/text.txt");
        try (FileReader fileReader = new FileReader(FILE);
             FileWriter fileWriter = new FileWriter(directory + "/result.txt")) {
            StringBuilder stringBuilder = new StringBuilder();
            int k;
            while ((k = fileReader.read()) != -1) {
                stringBuilder.append((char) k);
            }

            String[] words = stringBuilder.toString().split(" ");
            for (int i = 0; i < words.length; i++) {
                if (words[i].matches("[А-я]{1}[а-я]+")) {
                    words[i] = words[i].substring(0, 1).toUpperCase() + words[i].substring(1);
                    fileWriter.write(words[i].hashCode() + " ");
                }
            }

        } catch (IOException e) {
            System.out.println(e);
        }
    }

}
