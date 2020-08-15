package L7_reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

public class TestLauncher {
    public static void start(Class TestClass) {
        try {
            Method[] methodsArr;
            // Получаем класс из имени
            Class c = Class.forName(TestClass.getName());
            // Получаем инстанс
            Object o = c.newInstance();
            // Получаем список объектов
            methodsArr = c.getDeclaredMethods();
            TreeMap<Integer, ArrayList<Method>> hm = new TreeMap<>(Collections.reverseOrder());
            // Бежим по всем методам и стром хэш-мапу по приоритетам из аннтоаций
            for (Method m: methodsArr) {
                if(m.isAnnotationPresent(BeforeSuite.class)) {
                    BeforeSuite bs = m.getAnnotation(BeforeSuite.class);
                    ArrayList<Method> list = new ArrayList();
                    list.add(m);
                    hm.put(bs.priority(), list);
                }
                if(m.isAnnotationPresent(AfterSuite.class)) {
                    AfterSuite bs = m.getAnnotation(AfterSuite.class);
                    ArrayList<Method> list = new ArrayList();
                    list.add(m);
                    hm.put(bs.priority(), list);
                }
                if(m.isAnnotationPresent(Test.class)) {

                    Test bs = m.getAnnotation(Test.class);
                    ArrayList<Method> list = new ArrayList();
                    if (hm.containsKey(bs.priority())) {
                        list = hm.get(bs.priority());
                    }
                    list.add(m);
                    hm.put(bs.priority(), list);
                }
            }

            // Когда собрали все приоритеты, запускаем методы в соотвествии с приоритетами
            for (Integer key: hm.keySet()) {
                ArrayList<Method> list = hm.get(key);
                for (Method m: list) {
                    m.invoke(o);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}