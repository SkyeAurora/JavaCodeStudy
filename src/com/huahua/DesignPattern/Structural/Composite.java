package src.com.huahua.DesignPattern.Structural;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 组合模式 对象之间有部分与整体的关系 通过继承同一个抽象类或实现抽象接口来实现对象组合形成树状结构
 * 组合模式适用于处理对象的整体-部分关系，并且能够提供一种统一、透明的方式来处理这些对象，从而提高代码的可维护性和扩展性。
 * @author：张佳伟
 * @date: 2024/8/13
 */
interface FileSystemComponent {
    void displayInfo();
}

class File implements FileSystemComponent {

    private String name;

    public File(String name) {
        this.name = name;
    }

    @Override
    public void displayInfo() {
        System.out.println("File:" + name);
    }
}

class Directory implements FileSystemComponent {

    private String name;
    private List<FileSystemComponent> components;

    public Directory(String name) {
        this.name = name;
        components = new ArrayList<>();
    }

    public void addComponent(FileSystemComponent component) {
        components.add(component);
    }

    @Override
    public void displayInfo() {
        System.out.println("Directory:" + name);
        for (FileSystemComponent component : components) {
            component.displayInfo();
        }
    }
}

public class Composite {
    public static void main(String[] args) {
        File file1 = new File("text1.txt");
        File file2 = new File("text2.txt");
        Directory directory = new Directory("SubDirectory");
        directory.addComponent(file1);
        directory.addComponent(file2);
        Directory root = new Directory("RootDirectory");
        root.addComponent(directory);

        root.displayInfo();
    }
}
