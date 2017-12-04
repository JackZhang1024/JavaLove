package chainreponsibility;

/**
 * Created by zfz on 2017/12/16.
 */
public class President extends Processor{

    public President(String name) {
        setName(name);
    }

    @Override
    void handleRequest(ProjectRequest request) {
        if(request.getMoney()<500000){
            System.out.println("董事长 " + name + " 批准了项目 " + request.getName());
        } else {
            successor.handleRequest(request);
        }
    }
}
