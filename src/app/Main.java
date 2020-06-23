
package app;

public class Main {

    public static void main(String[] args) {
        String pathVariable = "\\";
        if (System.getProperty("os.name").contains("Linux"))
        {
            pathVariable = "/";
            System.load(System.getProperty("user.dir") + "/scripts/libfixXInitThreads.so");
        }
        App myApp = new App(pathVariable);
    }
}
