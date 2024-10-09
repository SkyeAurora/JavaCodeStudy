package src.com.huahua.DesignPattern.Structural;

/**
 * @description:
 * @author：张佳伟
 * @date: 2024/8/15
 */
// 音响
class StereoSystem {
    public void turnOn() {
        System.out.println("Stereo System is turned on");
    }

    public void turnOff() {
        System.out.println("Stereo System is turned off");
    }
}

// 子系统：投影仪
class Projector {
    public void turnOn() {
        System.out.println("Projector is turned on");
    }

    public void turnOff() {
        System.out.println("Projector is turned off");
    }
}

// 子系统：灯光控制
class LightsControl {
    public void turnOn() {
        System.out.println("Lights are turned on");
    }

    public void turnOff() {
        System.out.println("Lights are turned off");
    }
}

// 外观类：家庭影院外观
class HomeTheaterFacade {
    private final StereoSystem stereo;
    private final Projector projector;
    private final LightsControl lights;

    public HomeTheaterFacade() {
        stereo = new StereoSystem();
        projector = new Projector();
        lights = new LightsControl();
    }

    public void watchMovie() {
        System.out.println("Getting ready to watch a movie...");
        lights.turnOff();
        projector.turnOn();
        stereo.turnOn();
    }

    public void endMovie() {
        System.out.println("Ending the movie...");
        stereo.turnOff();
        projector.turnOff();
        lights.turnOn();
    }
}

public class Facade {
    public static void main(String[] args) {
        HomeTheaterFacade homeTheaterFacade = new HomeTheaterFacade();
        homeTheaterFacade.watchMovie();

        homeTheaterFacade.endMovie();
    }
}
