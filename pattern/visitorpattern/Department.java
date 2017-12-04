package visitorpattern;

/**
 * Created by zfz on 2017/12/16.
 */
public interface Department {

    void visit(FullTimeEmployee employee);

    void visit(PartTimeEmployee employee);
}
