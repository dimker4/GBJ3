package L4_multithread;

public class HumanScan extends Thread{
    MFU mfu;
    String name;

    public HumanScan(MFU m, String name) {
        mfu = m;
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name + " пробует сканировать документ");
        mfu.scan(name);
    }
}
