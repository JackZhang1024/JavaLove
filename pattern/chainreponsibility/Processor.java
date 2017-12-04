package chainreponsibility;

/**
 * Created by zfz on 2017/12/16.
 */
public abstract class Processor {

    protected Processor successor;
    protected String name;

    public void setName(String name) {
        this.name = name;
    }

    public void setSuccessor(Processor successor) {
        this.successor = successor;
    }

    abstract void handleRequest(ProjectRequest request);
}
