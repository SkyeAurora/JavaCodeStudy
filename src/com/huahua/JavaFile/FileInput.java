package src.com.huahua.JavaFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @description:
 * @author：张佳伟
 * @date: 2024/9/4
 */
public class FileInput {
    static final String DIR_PATH = "src/com/huahua/JavaFile/TestFile";

    public static void main(String[] args) {
        Path path = Paths.get(DIR_PATH + "/test.txt");
        List<String> list = List.of("Hello", "World", "Hello World", "Huaperion");
        try {
            Files.write(path, list);
            System.out.println("内容写入成功");
        } catch (IOException e) {
            System.out.println("内容写入失败");
            e.printStackTrace();
        }
    }
}
