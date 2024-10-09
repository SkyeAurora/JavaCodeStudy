package src.com.huahua.JavaFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * @description:
 * @author：张佳伟
 * @date: 2024/9/4
 */
public class FileReader {
    static final String DIR_PATH = "src/com/huahua/JavaFile/TestFile";
    static final String SUB_STRING = "llo";

    public static void main(String[] args) {
        Path path = Paths.get(DIR_PATH + "/test.txt");

        try {
            List<String> lines = Files.readAllLines(path);

            for (int i = 0; i < lines.size(); i++) {
                if (lines.get(i).contains(SUB_STRING)) {
                    System.out.println("第" + i + "行" + ":" + lines.get(i));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
