package proxypattern;

/**
 * Created by zfz on 2017/12/11.
 */
public class RealSearcher implements Searcher {

    @Override
    public String doSearch(String userId, String keyWords) {
        System.out.println("用户"+userId+" 使用关键词 "+keyWords+" 进行商务信息查询");
        return "返回具体内容";
    }
}
