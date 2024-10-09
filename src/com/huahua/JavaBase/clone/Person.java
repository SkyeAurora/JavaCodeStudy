package src.com.huahua.JavaBase.clone;

import java.io.*;

/**
 * @description:
 * @author：张佳伟
 * @date: 2024/8/11
 */
public class Person implements Serializable {
    String name;
    Cat cat;

    Person(String name, Cat cat) {
        this.name = name;
        this.cat = cat;
    }

    public Person deepCopy() {
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(this);
            oos.flush();
            oos.close();

            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);

            return (Person) ois.readObject();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Person p1 = new Person("Hua", new Cat("ly"));
        Person p2 = p1.deepCopy();
        System.out.println(p1.cat);
        System.out.println(p2.cat);
    }
}
