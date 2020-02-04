package com.codecool.harmadikhet.tests;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Grid {

    private String nodeURL;
    private String browser;
    private String platform;
    DesiredCapabilities capabilities;

    public Grid(String browser, String platform) {
        this.browser = browser;
        this.platform = platform;
        this.setBrowser(this.browser);
        this.setPlatform(this.platform);
        this.setTestName();
        this.nodeURL = System.getenv("NODE_URL");
    }

    void setBrowser(String browser) {
        switch (browser) {
            case "firefox":
                this.capabilities = DesiredCapabilities.firefox();
                break;
            case "chrome":
                this.capabilities = DesiredCapabilities.chrome();
                break;
        }
    }

    public String getNodeURL() {
        return nodeURL;
    }

    public DesiredCapabilities getCapabilities() {
        return capabilities;
    }

    void setPlatform(String platform) {
        switch (platform) {
            case "linux":
                capabilities.setPlatform(Platform.LINUX);
                break;
            case "xp":
                capabilities.setPlatform(Platform.XP);
                break;
        }
    }

    private void setTestName() {
        capabilities.setCapability("name", getClass().getSimpleName());
    }
    
}
