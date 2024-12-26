package utilities;

import actions.Actions;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtilities {

    private static String normalizePath(String fileName) {
        return fileName.replaceAll("/", FileSystems.getDefault().getSeparator());
    }

    /**
     * Запись в файл
     * @param info строка для записи
     * @throws IOException io exception
     */
    public static void fileWriting(String info) throws IOException {
        String filePath = normalizePath("/MainTask/output.txt");

        Path file = Paths.get(filePath);
        if (Files.exists(file)) {
            System.out.printf("Файл %s найден.\n", file.getFileName());
        } else {
            Files.createFile(file);
            System.out.printf("Файл %s НЕ найден, создан новый.\n", file.getFileName());
            return;
        }

        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(file)) {
            bufferedWriter.write(info + "\n");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static <T> List<T> readFile(String fileName, Actions.Builder<T> builder) {
        Path file = Paths.get(normalizePath(fileName));

        if (!Files.exists(file)) {
            System.err.printf("Файл %s не найден, проверьте правильность пути\n", fileName);
            return null;
        }
        List<T> models = new ArrayList<>();

        System.out.printf("Файл %s найден.\n", fileName);
        try (BufferedReader bufferedReader = Files.newBufferedReader(file)) {
            int lineCount = 1;
            int count = 1;
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] tmpArr = line.split(";");
                if (tmpArr.length == 3) {
                    models.add(builder.callBuilder(tmpArr, count));
                    count++;
                } else {
                    System.out.printf("Строка %s (под номером %d в файле) некорректна, она будет пропущена.\n",
                            line, lineCount);
                }
                lineCount++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (models.isEmpty()) {
            System.err.println("\nФайл пустой или отсутствует, возврат в предыдущее меню.");
            return null;
        }

        return models;
    }
}
