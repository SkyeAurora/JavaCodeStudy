package src.com.huahua.JavaFile;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * @description:
 * @author：张佳伟
 * @date: 2024/9/4
 */
public class FileCreate {
    // 文件存放地址
    static final String FILE_STORAGE_ADDRESS = "src/com/huahua/JavaFile/TestFile";

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("输入需要创建的文件名: ");
        String fileName = in.nextLine();

        File directory = new File(FILE_STORAGE_ADDRESS);

        if (!directory.exists()) {
            if (directory.mkdirs()) {
                System.out.println("文件夹创建成功：" + FILE_STORAGE_ADDRESS);
            } else {
                System.out.println("文件夹创建失败！");
            }
        }

        File file = new File(directory, fileName);
        try {
            if (file.createNewFile()) {
                System.out.println("文件创建成功: " + file.getAbsolutePath());
            } else {
                System.out.println("文件已存在："+ file.getAbsolutePath());
            }
        } catch (IOException e) {
            System.out.println("创建过程发生错误！");
            e.printStackTrace();
        }
    }
}
