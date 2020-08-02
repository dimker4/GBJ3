package L4_multithread;

public class HumanPrint extends Thread{
    MFU mfu;
    String name;

    public HumanPrint(MFU m, String name) {
        mfu = m;
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name + " пробует печатать документ");
        mfu.print(name);
    }
}
