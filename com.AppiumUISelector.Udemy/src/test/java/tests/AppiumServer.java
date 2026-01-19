import java.io.IOException;

public class AppiumServer {

    private static Process appiumProcess;

    public static void startServer() throws IOException {

        ProcessBuilder builder = new ProcessBuilder(
                "appium",
                "--address", "127.0.0.1",
                "--port", "4723",
                "--base-path", "/wd/hub",
                "--log-level", "info"
        );

        builder.redirectErrorStream(true);
        builder.inheritIO();   // prints logs to console

        appiumProcess = builder.start();

        System.out.println("Appium Server started...");
    }

    public static void stopServer() {
        if (appiumProcess != null) {
            appiumProcess.destroy();
            System.out.println("Appium Server stopped...");
        }
    }
}
