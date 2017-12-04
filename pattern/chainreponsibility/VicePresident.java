package chainreponsibility;

/**
 * Created by zfz on 2017/12/16.
 */
public class VicePresident extends Processor{

    public VicePresident(String name) {
        setName(name);
    }

    @Override
    void handleRequest(ProjectRequest request) {
        if(request.getMoney()<100000){
            System.out.println("副董事 " + name + " 批准了项目 " + request.getName());
        } else {
            successor.handleRequest(request);
        }
    }
}
