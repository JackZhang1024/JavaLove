package proxylearn;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Calendar;

/**
 * 动态代理的学习
 * 利用代理可以在运行时创建一个实现了一组给定接口的新类，
 * 这种功能只有在编译时无法确定需要实现哪个接口时才有必要使用。
 * 我们需要提供一个实现InvocationHandler接口的类来处理调用过程。
 * <p>
 * Created by zfz on 2018/4/2.
 */
public class DynamicProxyLearn {

    static class DaoLogHandler implements InvocationHandler {

        private Object mObject;

        public DaoLogHandler(Object object) {
            this.mObject = object;
        }


        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("被代理对象 " + mObject);
            System.out.println("方法名称 " + method.getName());
            for (Object o : args) {
                System.out.println("方法参数 " + o);
            }
            preInvoke();
            Object result = method.invoke(mObject, args);
            afterInvoke();
            return result;
        }

        private void preInvoke() {
            Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int date = calendar.get(Calendar.DAY_OF_MONTH);
            int hour = calendar.get(Calendar.HOUR);
            int minute = calendar.get(Calendar.MINUTE);
            System.out.println("调用时间 " + String.format("%s-%s-%s %s:%s", year, month, date, hour, minute));
        }

        private void afterInvoke() {
            System.out.println("调用结束");
        }
    }

    interface AbstractUserDao {
        boolean findUserByID(String userID);
    }

    interface AbstractDocumentDao {
        boolean deleteDocumentByID(String documentID);
    }

    public static class UserDao implements AbstractUserDao {

        @Override
        public boolean findUserByID(String userID) {
            if ("xiaozhang".equalsIgnoreCase(userID)) {
                System.out.println("人找到了");
                return true;
            } else {
                System.out.println("人没有找到");
                return false;
            }
        }
    }

    public static class DocumentDao implements AbstractDocumentDao {

        @Override
        public boolean deleteDocumentByID(String documentID) {
            if ("ThinkingInJava".equalsIgnoreCase(documentID)) {
                System.out.println("文档找到了 ");
                return true;
            } else {
                System.out.println("文档没有找到");
                return false;
            }
        }
    }

    interface AbstractPDFDocument extends AbstractDocumentDao {
        void addComments(String comments);
    }


    public static class PDFDocument implements AbstractPDFDocument {

        @Override
        public boolean deleteDocumentByID(String documentID) {
            return false;
        }

        @Override
        public void addComments(String comments) {
            System.out.println("添加Comments " + comments);
        }
    }


    // 动态代理模式的出现
    public static void main(String[] args) {
        DaoLogHandler logHandler = null;
        AbstractUserDao userDao = new UserDao();
        logHandler = new DaoLogHandler(userDao);
        AbstractUserDao proxy = null;
        // 创建动态代理对象，用于代理一个AbstractUserDao的真实主题
        proxy = (AbstractUserDao) Proxy.newProxyInstance(AbstractUserDao.class.getClassLoader(), new Class[]{AbstractUserDao.class}, logHandler);
        // 调用代理对象的业务方法
        proxy.findUserByID("xiaozhang");
        System.out.println("-------------------------");

        AbstractDocumentDao documentDao = new DocumentDao();
        logHandler = new DaoLogHandler(documentDao);
        AbstractDocumentDao proxy_new = null;
        proxy_new = (AbstractDocumentDao) Proxy.newProxyInstance(AbstractDocumentDao.class.getClassLoader(), new Class[]{AbstractDocumentDao.class}, logHandler);
        proxy_new.deleteDocumentByID("Python");
        System.out.println("-------------------------");

        // 深入研究

        PDFDocument pdfDocument = new PDFDocument();
        logHandler = new DaoLogHandler(pdfDocument);
        // PDFDocument必须是接口
        AbstractPDFDocument pdfDocumentProxy = (AbstractPDFDocument) Proxy.newProxyInstance(AbstractPDFDocument.class.getClassLoader(),
                new Class[]{AbstractPDFDocument.class}, logHandler);
        pdfDocumentProxy.deleteDocumentByID("Python");
        pdfDocumentProxy.addComments("Python 值得学习");
        System.out.println("---------------------------");

    }

}
