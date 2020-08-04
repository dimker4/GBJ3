package L4_multithread;

public class HumanCopy extends Thread{
    MFU mfu;
    String name;

    public HumanCopy(MFU m, String name) {
        mfu = m;
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name + " пробует копировать документ");
        mfu.copy(name);
    }
}
