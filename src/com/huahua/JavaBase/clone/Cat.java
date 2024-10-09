package src.com.huahua.JavaBase.clone;

import java.io.Serializable;

/**
 * @description:
 * @author：张佳伟
 * @date: 2024/8/11
 */
public class Cat implements Serializable {
    String catName;

    Cat(String catName) {
        this.catName = catName;
    }
}
