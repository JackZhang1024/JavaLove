package downupload;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * Created by zfz on 2017/12/9.
 */
public class DownLoadLargeFile {
    //http://otmelvjq5.bkt.clouddn.com/8-1.mp4
    //http://download.skycn.com/hao123-soft-online-bcs/soft/2017_02_22_BaiduPlayer5Setup_5.exe
    private static final String FILE_URL = "http://otmelvjq5.bkt.clouddn.com/8-1.mp4";

    // 通过测试表明不一定启用的线程数够多 就下载的速度快
    public static void main(String[] args) {
        getDownloadInfo(FILE_URL, 10);
    }

    public static void getDownloadInfo(String urlPath, int threadSize) {
        try {
            String fileName = getFileName(urlPath);
            System.out.println("FileName "+fileName);
            URL url = new URL(urlPath);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(5000);
            if (conn.getResponseCode() == 200) {
                long length = conn.getContentLength();
                // 计算出每个线程所要下载的字节数
                long size = length % threadSize == 0 ? length / threadSize : length / threadSize + 1;
                System.out.println("各个线程所需下载的文件大小  "+(size/(1024*1024))+" M");
                // 设置下载的临时文件
                File file = new File(fileName);
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rwd");
                randomAccessFile.setLength(length);
                randomAccessFile.close();
                // 设置每个线程下载文件的开始和结束位置
                ArrayList<String> threadNames = new ArrayList<>();
                CountDownLatch countDownLatch = new CountDownLatch(threadSize);
                for (int index = 0; index < threadSize; index++) {
                    long start = index * size;
                    long end = (index + 1) * size - 1;
                    // 开启下载
                    String threadName = String.format("Thread%s ", index);
                    new DownLoadThread(start, end, threadName, countDownLatch, fileName);
                    threadNames.add(threadName);
                }
                new DaemonThread(countDownLatch, threadNames);
                conn.disconnect();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // 负责扫尾工作的线程
    public static class DaemonThread implements Runnable {
        private CountDownLatch countDownLatch;
        private List<String> downloadThreadNameList;

        public DaemonThread(CountDownLatch countDownLatch, List<String> downloadThreadNameList) {
            this.countDownLatch = countDownLatch;
            this.downloadThreadNameList = downloadThreadNameList;
            new Thread(this).start();
        }

        @Override
        public void run() {
            try {
                System.out.println("Daemon Thread start ...");
                long startTime = System.currentTimeMillis();
                countDownLatch.await();
                for (int index = 0; index < downloadThreadNameList.size(); index++) {
                    File file = new File(String.format("%s.txt", downloadThreadNameList.get(index)));
                    file.delete();
                }
                long totalTime = (System.currentTimeMillis()-startTime)/(1000);
                System.out.println("File DownLoad over.....用时 "+totalTime+" 秒");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static class DownLoadThread implements Runnable {
        private long start, end;
        private String threadID;
        private CountDownLatch countDownLatch;
        private String fileName;

        public DownLoadThread(long start, long end, String threadID, CountDownLatch latch, String fileName) {
            this.start = start;
            this.end = end;
            this.threadID = threadID;
            this.countDownLatch = latch;
            this.fileName = fileName;
            new Thread(this).start();
        }

        @Override
        public void run() {
            HttpURLConnection connection = null;
            try {
                File fileProgress = new File(String.format("%s.txt", threadID));
                if (fileProgress.exists()) {
                    FileInputStream fileInputStream = new FileInputStream(fileProgress);
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
                    start += Integer.parseInt(bufferedReader.readLine());
                }
                System.out.println("线程" + threadID + "下载区间是" + start + "---------" + end);
                URL url = new URL(FILE_URL);
                connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
                connection.setRequestProperty("Connection", "keep-alive");
                connection.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.8");
                connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36");
                connection.setRequestProperty("Referer", FILE_URL);
                connection.setConnectTimeout(5000);
                connection.setReadTimeout(5000);
                connection.setRequestProperty("Range", "bytes=" + start + "-" + end);
                if (connection.getResponseCode() == 206) {
                    InputStream is = connection.getInputStream();
                    int len = 0;
                    int total = 0;
                    byte[] b = new byte[1024 * 1024];
                    File file = new File(fileName);
                    RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rwd");
                    randomAccessFile.seek(start);
                    while ((len = is.read(b)) != -1) {
                        randomAccessFile.write(b, 0, len);
                        total += len;
                        int amount = (total / (1024*1024));
                        System.out.println("线程 " + threadID + " 已下载 " + amount + " M");
                        RandomAccessFile fileProgressaf = new RandomAccessFile(fileProgress, "rwd");
                        fileProgressaf.write(String.valueOf(total).getBytes());
                        fileProgressaf.close();
                    }
                    System.out.println("线程 " + threadID + "---下载结束---");
                    randomAccessFile.close();
                    countDownLatch.countDown();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (connection!=null){
                    connection.disconnect();
                }
            }
        }
    }

    private static String getFileName(String path){
        String fileName = path.substring(path.lastIndexOf("/")+1);
        return fileName;
    }


}
