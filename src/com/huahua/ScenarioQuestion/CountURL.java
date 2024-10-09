package src.com.huahua.ScenarioQuestion;

import java.io.*;
import java.net.URL;
import java.util.*;

/**
 * @description: 读取URL并统计域名出现次数，输出出现最多的前10个域名
 * @author：张佳伟
 * @date: 2024/9/19
 */
public class CountURL {
    private static final String SOURCE_FILE_PATH = "src/com/huahua/ScenarioQuestion/data/millionsUrls.txt";
    private static final int OUTPUT_FILE_NUM = 64;
    private static final Map<Integer, BufferedWriter> writeFile = new HashMap<>();

    static {
        try {
            for (int i = 0; i < OUTPUT_FILE_NUM; i++) {
                String fileName = "src/com/huahua/ScenarioQuestion/data/" + i + ".txt";
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName));
                writeFile.put(i, bufferedWriter);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void closeAll() {
        for (int i = 0; i < OUTPUT_FILE_NUM; i++) {
            try {
                if (writeFile.get(i) != null) {
                    writeFile.get(i).close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 程序的主入口点
     * 本函数旨在处理源文件中的URL，提取域名，并根据哈希函数结果将域名写入不同的文件
     * 进而统计每个域名出现的次数，并找出出现次数最多的前10个域名
     *
     * @param args 命令行参数，未使用
     */
    public static void main(String[] args) {
        // 存储全局域名计数
        Map<String, Integer> globalCntMap = new HashMap<>();
        // 优先队列，用于存储出现次数最多的前10个域名
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));

        // 读取源文件
        try (BufferedReader br = new BufferedReader(new FileReader(SOURCE_FILE_PATH))) {
            String line;

            // 遍历源文件中的每一行
            while ((line = br.readLine()) != null) {
                try {
                    // 解析URL以获取域名
                    URL url = new URL(line);
                    String domain = url.getHost();
                    // 根据域名的哈希值选择对应的文件进行写入
                    BufferedWriter bufferedWriter = writeFile.get(getHashFileIndex(domain));
                    bufferedWriter.write(domain);
                    bufferedWriter.newLine();
                } catch (Exception e) {
                    // 处理无效URL
                    System.out.println("Invalid URL: " + line);
                }
            }
            // 关闭所有打开的资源
            closeAll();

            // 从各个输出文件中读取并统计域名出现次数
            for (int i = 0; i < OUTPUT_FILE_NUM; i++) {
                String fileName = "src/com/huahua/ScenarioQuestion/data/" + i + ".txt";
                try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
                    while ((line = bufferedReader.readLine()) != null && line.length() > 0) {
                        globalCntMap.put(line, globalCntMap.getOrDefault(line, 0) + 1);
                    }
                }
            }

            // 构建出现次数最多的前10个域名的优先队列
            for (Map.Entry<String, Integer> entry : globalCntMap.entrySet()) {
                pq.offer(entry);
                if (pq.size() > 10) {
                    pq.poll();  // 维持队列中只保存前10个出现次数最多的域名
                }
            }

            // 输出出现次数最多的前10个域名
            System.out.println("出现次数最多的前10个域名：");
            List<Map.Entry<String, Integer>> topDomains = new ArrayList<>(pq);
            topDomains.sort((a, b) -> b.getValue() - a.getValue());  // 按出现次数降序排序
            for (Map.Entry<String, Integer> entry : topDomains) {
                System.out.println(entry.getKey() + " 出现了 " + entry.getValue() + " 次");
            }

        } catch (IOException e) {
            // 处理可能的IO异常
            e.printStackTrace();
        }
    }


    /**
     * 根据输入字符串获取哈希文件索引
     * 该方法用于通过字符串生成一个哈希值，然后通过位运算确保该哈希值落在输出文件数量的范围内
     * 这对于分布式存储或哈希表场景特别有用，它可以决定数据项存储在哪个文件或桶中
     *
     * @param s 输入字符串，用于生成哈希值
     * @return 返回计算得到的哈希文件索引，该索引不会超过OUTPUT_FILE_NUM
     */
    private static int getHashFileIndex(String s) {
        // 使用Math.abs确保s的哈希值为非负数，避免在与OUTPUT_FILE_NUM减1进行位运算时出现负数
        // 这样可以保证返回值总是在有效的文件索引范围内
        return Math.abs(s.hashCode()) & (OUTPUT_FILE_NUM - 1);
    }
}
