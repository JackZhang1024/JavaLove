package chainreponsibility;

/**
 * Created by zfz on 2017/12/16.
 */
public class Committee extends Processor{

    public Committee(String name) {
        setName(name);
    }

    @Override
    void handleRequest(ProjectRequest request) {
        System.out.println("董事会 " +name + " 批准了项目 " + request.getName());
    }
}
