package proxypattern;

/**
 * 抽象主题接口
 * Created by zfz on 2017/12/11.
 */
public interface Searcher {
    public String doSearch(String userId, String keyWords);
}
