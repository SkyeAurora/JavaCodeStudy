package src.com.huahua.JavaBase;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @description:
 * @author：张佳伟
 * @date: 2024/7/27
 */
public class IteratorTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("Zhang");
        list.add("Wang");
        list.add("Li");

        Iterator<String> iterator = list.iterator();

        // iterator 遍历集合
        while (iterator.hasNext()) {
            String element = iterator.next();
            System.out.println(element);
        }

        // 删除元素
        // 重新获取迭代器 iterator
        iterator = list.iterator();
        while (iterator.hasNext()) {
            String element = iterator.next();
            if ("Zhang".equals(element)) {
                iterator.remove();
            }
        }

        System.out.println("After Remove \"Zhang\":");
        for (String element : list) {
            System.out.println(element);
        }
    }
}
