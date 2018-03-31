package jvm;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author zfz
 *         Created by zfz on 2018/3/6.
 */
public class ClassLoaderTest {

    public static void main(String[] args) {
        ClassLoader myLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                    InputStream is = getClass().getResourceAsStream(fileName);
                    if (is == null) {
                        return super.loadClass(name);
                    }
                    byte[] b = new byte[is.available()];
                    is.read(b);
                    return defineClass(name, b, 0, b.length);
                } catch (IOException e) {
                    throw new ClassNotFoundException(name);
                }
            }
        };
        try {
            Object object = myLoader.loadClass("jvm.ClassLoaderTest").newInstance();
            System.out.println(" " + object.getClass());
            System.out.println(object instanceof jvm.ClassLoaderTest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

