package proxypattern;

/**
 * Created by zfz on 2017/12/11.
 */
public class Client {

    public static void main(String[] args) {
        Searcher proxy = new ProxySearcher();
        String result  = proxy.doSearch("李四", "大好时光");
        System.out.println("搜索结果 "+result);
    }
}
