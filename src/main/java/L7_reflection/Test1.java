package L7_reflection;


public class Test1 {
    @BeforeSuite
    public void test1() {
        System.out.println("Test1.test1 - Before");
    }

    @AfterSuite
    public void test2() {
        System.out.println("Test1.test2 - After");
    }

    @Test
    public void test3() {
        System.out.println("Test1.test3");
    }

    @Test
    public void test4() {
        System.out.println("Test1.test4");
    }

    @Test
    public void test5() {
        System.out.println("Test1.test5");
    }
}
