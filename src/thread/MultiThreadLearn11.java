package thread;

/**
 * 死锁问题
 * 线程： 小张 小红
 * 小张说: 你把画给我 我就把书给你
 * 小红说：你把书给我 我就把画给你
 * 小张说: 你把画给我 我就把书给你
 * 小红说：你把书给我 我就把画给你
 * ...
 * 两人都不肯给对方东西，所以就僵持不下 所以形成死锁
 *
 * 抽象的来看
 * 小张 小红都可以看做一个线程 在运行的过程中 都拥有对方所有想要的东西(锁)
 * 但是都释东西(释放锁) 最后结果是两个线程都不能获取后续程序继续执行所需要的锁
 * 最后都卡住了
 * Created by zfz on 2017/10/15.
 */
public class MultiThreadLearn11 {

    private static final Object book = new Object();
    private static final Object painting = new Object();

    public static void main(String[] args) {
        XiaoZhang xiaoZhang = new XiaoZhang("小张");
        XiaoHong xiaoHong = new XiaoHong("小红");
        xiaoHong.start();
        xiaoZhang.start();
    }

    private static class XiaoZhang extends Thread {

        public XiaoZhang(String name) {
            super(name);
        }

        @Override
        public void run() {
            super.run();
            try {
                synchronized (book) {
                    System.out.println("小张：你把画给我，我就给你书 ");
                    Thread.sleep(1000);
                    synchronized (painting) {
                        System.out.println("小张得到了画");
                    }
                }
            } catch (Exception e) {
                e.getMessage();
            }

        }
    }

    private static class XiaoHong extends Thread {

        public XiaoHong(String name) {
            super(name);
        }

        @Override
        public void run() {
            super.run();
            try{
                synchronized (painting){
                    System.out.println("小红：你把书给我， 我就给你画");
                    Thread.sleep(1000);
                    synchronized (book){
                        System.out.println("小红得到了书");
                    }
                }
            }catch (Exception e){
                e.getMessage();
            }
        }
    }
}
