package L7_reflection;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class Main {
    public static void main(String[] args) throws Exception {
        //Task 1
        Class c = Test1.class;
        TestLauncher.start(c);
        //Task 2

        Class ch = URLClassLoader.newInstance(new URL[]{new File("C:/09082020").toURL()}).loadClass("FirstApp");
        Constructor constructor = ch.getConstructor(Integer.class);
        Method m = ch.getDeclaredMethod("checkLeapYear");
        System.out.println("Test1 - " + test1(constructor, m));
        System.out.println("Test2 - " + test2(constructor, m));
        System.out.println("Test3 - " + test3(constructor, m));
        System.out.println("Test4 - " + test4(constructor, m));
    }

    public static String test1(Constructor constructor, Method m) throws Exception {
        int checkValue = 4;
        Object obj = constructor.newInstance(checkValue);
        Object result = m.invoke(obj);

        if ((boolean) result) return "OK";
        else return "Failed";
    }

    public static String test2(Constructor constructor, Method m) throws Exception {
        int checkValue = 1;
        Object obj = constructor.newInstance(checkValue);
        Object result = m.invoke(obj);

        if (!(boolean) result) return "OK";
        else return "Failed";
    }

    public static String test3(Constructor constructor, Method m) throws Exception {
        int checkValue = 100;
        Object obj = constructor.newInstance(checkValue);
        Object result = m.invoke(obj);

        if (!(boolean) result) return "OK";
        else return "Failed";
    }

    public static String test4(Constructor constructor, Method m) throws Exception {
        int checkValue = 400;
        Object obj = constructor.newInstance(checkValue);
        Object result = m.invoke(obj);

        if ((boolean) result) return "OK";
        else return "Failed";
    }
}
