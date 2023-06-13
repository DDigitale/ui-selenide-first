package config;

import com.codeborne.selenide.Configuration;

public class Config {
    private static Config instance;

    static {
        Configuration.browser = "chrome";
        Configuration.driverManagerEnabled = true;
        Configuration.headless = false;
        Configuration.startMaximized = true;
        Configuration.timeout = 3000;
    }

    private Config() {
    }

    public static Config getInstance() {
        if (instance == null) {
            instance = new Config();
        }
        return instance;
    }
}
