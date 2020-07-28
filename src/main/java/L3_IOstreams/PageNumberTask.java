package L3_IOstreams;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class PageNumberTask {
    private int pageNum = 0;

    public PageNumberTask(int pageNum) {
        this.pageNum = pageNum;
    }

    public void getPageText() {
        long t = System.currentTimeMillis();
        try (FileInputStream in = new FileInputStream("test4.txt")){
            int x;
            int i = 0;
            byte[] arr = new byte[1800];
            while ((x = in.read(arr)) != -1) { // Читем в массив размером 1800
                if (i == pageNum) {
                    System.out.print(new String(arr, 0, x));
                }
                i ++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println();
        System.out.println(System.currentTimeMillis() - t);
    }
}
