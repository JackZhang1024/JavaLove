package chainreponsibility;

/**
 * Created by zfz on 2017/12/16.
 */
public class Director extends Processor {

    public Director(String name) {
        setName(name);
    }

    @Override
    void handleRequest(ProjectRequest request) {
        if (request.getMoney() < 50000) {
            System.out.println("主任 " + name + " 批准了项目 " + request.getName());
        } else {
            successor.handleRequest(request);
        }
    }
}
