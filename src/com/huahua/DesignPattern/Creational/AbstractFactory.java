package src.com.huahua.DesignPattern.Creational;

/**
 * @description:
 * @author：张佳伟
 * @date: 2024/8/12
 */
interface OperatingSystem {
    void run();
}

class WindowsOS implements OperatingSystem {
    @Override
    public void run() {
        System.out.println("Running Windows OS");
    }
}

class LinuxOS implements OperatingSystem {
    @Override
    public void run() {
        System.out.println("Running Linux OS");
    }
}

interface Application {
    void open();
}

class WordApplication implements Application {
    @Override
    public void open() {
        System.out.println("Opening Word Application");
    }
}

class ExcelApplication implements Application {
    @Override
    public void open() {
        System.out.println("Opening Excel Application");
    }
}

interface SoftwareFactory {
    OperatingSystem createOperatingSystem();

    Application createApplication();
}

class WindowsFactory implements SoftwareFactory {

    @Override
    public OperatingSystem createOperatingSystem() {
        return new WindowsOS();
    }

    @Override
    public Application createApplication() {
        return new WordApplication();
    }
}

class LinuxFactory implements SoftwareFactory {

    @Override
    public OperatingSystem createOperatingSystem() {
        return new LinuxOS();
    }

    @Override
    public Application createApplication() {
        return new ExcelApplication();
    }
}

public class AbstractFactory {
    public static void main(String[] args) {
        SoftwareFactory windowsFactory = new WindowsFactory();
        OperatingSystem windowsOS = windowsFactory.createOperatingSystem();
        Application wordApp = windowsFactory.createApplication();
        windowsOS.run();
        wordApp.open();

        SoftwareFactory linuxFactory = new LinuxFactory();
        OperatingSystem linuxOS = linuxFactory.createOperatingSystem();
        Application excelApp = linuxFactory.createApplication();
        linuxOS.run();
        excelApp.open();
    }
}
