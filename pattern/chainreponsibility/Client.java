package chainreponsibility;

/**
 * Created by zfz on 2017/12/16.
 */
public class Client {

    public static void main(String[] args) {
        ProjectRequest request = new ProjectRequest(30000, "万达商城");
        Processor director, vicePresident, president, committee;
        director = new Director("小李");
        vicePresident = new VicePresident("小张");
        president = new President("王思聪");
        committee = new Committee("王健林");

        director.setSuccessor(vicePresident);
        //vicePresident.setSuccessor(president);
        vicePresident.setSuccessor(committee);
        //president.setSuccessor(committee);
        // 处理请求
        director.handleRequest(request);
    }
}
