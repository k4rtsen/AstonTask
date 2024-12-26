package utilities;

import actions.Actions;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileUtilities {
    /**
     * Запись в файл
     * @param info строка для записи
     * @throws IOException io exception
     */
    public static void fileWriting(String info) throws IOException {
        String filePath = ".\\MainTask\\output.txt";
        File file = new File(filePath);

        if (file.exists()) {
            System.out.printf("Файл %s найден.\n", file.getCanonicalFile());
        } else {
            System.out.printf("Файл %s НЕ найден, создан новый.\n", file.getCanonicalFile());
        }

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath, true))) {
            bufferedWriter.write(info + "\n");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static <T> List<T> readFile(String fileName, Actions.Builder<T> builder) {
        File file = new File(fileName);
        List<T> models = new ArrayList<>();

        if (!file.exists()) {
            System.err.printf("Файл %s не найден, проверьте правильность пути\n", fileName);
            return null;
        }

        System.out.printf("Файл %s найден.\n", fileName);
        try (BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(file.getPath()))) {
            int lineCount = 1;
            int count = 1;
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] tmpArr = line.split(";");
                lineCount++;
                if (tmpArr.length == 3) {
                    models.add(builder.callBuilder(tmpArr, count));
                    count++;
                } else {
                    System.out.printf("Строка %s (под номером %d в файле) некорректна, она будет пропущена.\n",
                            line, lineCount);
                }
            }
        } catch (IOException exception) {
            //TODO correct exception handling
            exception.printStackTrace();
        }

        if (models.isEmpty()) {
            System.err.println("\nФайл пустой или отсутствует, возврат в предыдущее меню.");
            return null;
        }

        return models;
    }
}
