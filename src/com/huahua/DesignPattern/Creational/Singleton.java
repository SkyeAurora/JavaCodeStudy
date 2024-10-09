package src.com.huahua.DesignPattern.Creational;

/**
 * @description: 单例模式
 * 懒汉式: 双重校验锁实现
 * @author：张佳伟
 * @date: 2024/7/26
 */
public class Singleton {

    /**
     * 双重校验锁
     */
    private volatile static Singleton singleton;

    private Singleton() {
    }

    public static Singleton getSingletonInstance() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

    /**
     * 静态内部类
     */
    private static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getSingletonInstanceByStaticClass() {
        return SingletonHolder.INSTANCE;
    }

    /**
     * 枚举实现
     */
    public enum SingletonEnum {
        INSTANCE;

        public void doSomething() {
            System.out.println("Executing some Method");
        }
    }

    public static void main(String[] args) {
        SingletonEnum instance = SingletonEnum.INSTANCE;
        instance.doSomething();
    }
}
