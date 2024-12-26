package utilities;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUtilities {
    /**
     * Запись в файл
     * @param info строка для записи
     * @throws IOException io exception
     */
    public static void fileWriting(String info) throws IOException {
        String filePath = ".\\MainTask\\output.txt";
        Path file = Paths.get(filePath);
//        File file = new File(filePath);

        if (Files.exists(file)) {
            System.out.printf("Файл %s\\%s найден.\n", file.getParent(), file.getFileName());
        } else {
            System.out.printf("Файл %s\\%s НЕ найден.\n", file.getParent(), file.getFileName());
        }

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath, true))) {
            bufferedWriter.write(info + "\n");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}
