package src.com.huahua.JavaCollection;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

/**
 * @description:
 * @author：张佳伟
 * @date: 2024/7/28
 */
public class SortTest {
    public static void main(String[] args) {
        TreeMap<Person, String> treeMap = new TreeMap<>();
        treeMap.put(new Person("张三", 20), "Zhangsan");
        treeMap.put(new Person("李四", 10), "Lisi");
        treeMap.put(new Person("王五", 15), "Wangwu");
        treeMap.put(new Person("黄六", 21), "Huangliu");
        treeMap.put(new Person("胡七", 30), "Huqi");

        Set<Person> people = treeMap.keySet();
        for (Person p : people) {
            System.out.println(p);
        }
    }
}

class Person implements Comparable<Person> {

    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Person o) {
        return this.age - o.age;
    }

    @Override
    public String toString() {
        return name + "==>" + age;
    }
}
