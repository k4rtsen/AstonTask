package utilities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtilities {

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

}
