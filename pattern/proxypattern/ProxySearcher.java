package proxypattern;

/**
 * Created by zfz on 2017/12/11.
 */
public class ProxySearcher implements Searcher {

    private RealSearcher realSearcher;
    private AccessValidator validator;
    private Logger logger;

    public ProxySearcher() {
        realSearcher = new RealSearcher();
        validator = new AccessValidator();
        logger = new Logger();
    }

    @Override
    public String doSearch(String userId, String keyWords) {
        String searchResult = "";
        if (validator.validate(userId)) {
            searchResult = realSearcher.doSearch(userId, keyWords);
            logger.log(userId);
        }
        return searchResult;
    }
}
