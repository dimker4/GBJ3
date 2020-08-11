package L7_reflection;

import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        Class c = Test1.class;

        TestLauncher.start(c);
    }
}
