public class FirstApp {
    // Задание 1
    public int year;

    public FirstApp(int year) {
        this.year = year;
    }

    public void checkLeapYear() {
        boolean result = false;
        if (year % 400 == 0) result = true;
        else if (year % 4 == 0)
        {
            if (year % 100 == 0) result = false;
            else result = true;
        }

        if (result) System.out.println(year + " is leap year");
        else System.out.println(year + " is not leap year");
    }
}