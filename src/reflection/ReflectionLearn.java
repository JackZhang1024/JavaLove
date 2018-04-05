package reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.List;

/**
 * http://www.cnblogs.com/qifengshi/p/6267511.html
 * Created by zfz on 2018/4/3.
 */
public class ReflectionLearn {


    public static void main(String[] args) {
        //lesson01();
        //lesson02();
        //lesson03();
        //lesson04();
        //lesson05();
        //lesson06();
        lesson07();
    }


    // 获取类的类类型对象
    private static void lesson01() {
        try {
            FatherObject children = new ChildrenObject();
            Class childrenClass0 = children.getClass();

            Class childrenClass1 = ChildrenObject.class;

            Class childrenClass2 = Class.forName("reflection.ChildrenObject");

            System.out.println("childrenClass0 == childrenClass1 " + (childrenClass0 == childrenClass1));
            System.out.println("childrenClass0 == childrenClass2 " + (childrenClass0 == childrenClass2));
            System.out.println("childrenClass1 == childrenClass2 " + (childrenClass1 == childrenClass2));

            String className0 = childrenClass0.getName();
            String className1 = childrenClass1.getName();
            String className2 = childrenClass2.getName();

            // FullName
            System.out.println("className0 " + className0);
            System.out.println("className1 " + className1);
            System.out.println("className2 " + className2);

            // SimpleName
            System.out.println("Simple className0 " + childrenClass0.getSimpleName());
            System.out.println("Simple className1 " + childrenClass1.getSimpleName());
            System.out.println("Simple className2 " + childrenClass2.getSimpleName());

            // 获取包名称
            String packageName = childrenClass0.getPackage().getName();
            System.out.println("packageName " + packageName);

            // 获取父类名称
            Class superClass = childrenClass0.getSuperclass();
            System.out.println("superClass Name " + superClass.getName());

            // 判断父类是否是抽象类
            boolean isAbstract = Modifier.isAbstract(superClass.getModifiers());
            System.out.println("superClass is Abstract " + isAbstract);

            // 获取父类接口
            Class[] interfaces = superClass.getInterfaces();
            for (Class clz : interfaces) {
                System.out.println("InterfaceName " + clz.getName());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 获取构造方法
    private static void lesson02() {
        ChildrenObject childrenObject = new ChildrenObject();
        Class childrenClass = childrenObject.getClass();

        // 获取Children所有公开的构造方法
        Constructor[] constructors = childrenClass.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println("所有公开构造方法 constructor " + constructor.toString());
        }

        // 获取Children的指定构造方法
        try {
            Constructor constructor = childrenClass.getConstructor(int.class, java.lang.String.class, int.class);
            ChildrenObject children = (ChildrenObject) constructor.newInstance(12, "Jack", 99);
            System.out.println("Age " + children.getAge());
            System.out.println("Name " + children.getName());
            System.out.println("Score " + children.getScore());

            Constructor constructor1 = childrenClass.getConstructor();
            ChildrenObject children1 = (ChildrenObject) constructor1.newInstance();
            System.out.println("Age  1 " + children1.getAge());
            System.out.println("Name 1 " + children1.getName());
            System.out.println("Score1 " + children1.getScore());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 获取所有私有的构造方法
        Constructor[] constructors1 = childrenClass.getDeclaredConstructors();
        for (Constructor constructor : constructors1) {
            System.out.println("所有构造方法 constructor " + constructor.toString());
        }
        try {
            Constructor constructor2 = childrenClass.getDeclaredConstructor(int.class, int.class);
            // 如果构造方法是私有的，则必须设置可以访问私有构造方法
            constructor2.setAccessible(true);
            ChildrenObject childrenObject2 = (ChildrenObject) constructor2.newInstance(10, 89);
            System.out.println("Age " + childrenObject2.getAge());
            System.out.println("Score " + childrenObject2.getScore());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 变量
    private static void lesson03() {
        ChildrenObject childrenObject = new ChildrenObject();
        Class childrenClass = childrenObject.getClass();

        // 获取ChildrenObject 的所有公开属性
        Field[] fields = childrenClass.getFields();
        for (Field field : fields) {
            System.out.println("Field " + field.toString());
        }

        // 获取ChildrenObject 的所有属性
        Field[] fields1 = childrenClass.getDeclaredFields();
        for (Field field : fields1) {
            System.out.println("所有属性 Field " + field.toString());
        }
        try {
            Constructor constructor = childrenClass.getConstructor();
            ChildrenObject childrenObject1 = (ChildrenObject) constructor.newInstance();
            //Field field = childrenClass.getField("age");
            Field field = childrenClass.getDeclaredField("age");
            field.setAccessible(true);
            field.set(childrenObject1, 10);
            System.out.println("ChildrenObject age " + childrenObject1.getAge());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // 获取公有方法
    private static void lesson04() {
        ChildrenObject childrenObject = new ChildrenObject();
        Class childrenClass = childrenObject.getClass();
        try {
            // 获取所有的公开的方法
            Method[] methods = childrenClass.getMethods();
            for (Method method : methods) {
                System.out.println("Methods " + method.toString());
                // 获取方法的参数
                for (Class parameter : method.getParameterTypes()) {
                    System.out.println("ParameterType " + parameter.getName());
                }
                System.out.println("-----------------------\n");
            }

            // 获取所有的方法
            Method[] methods1 = childrenClass.getDeclaredMethods();
            for (Method method : methods1) {
                System.out.println("Methods 2 " + method.toString());
            }


            Constructor constructor = childrenClass.getConstructor();
            ChildrenObject childrenObject1 = (ChildrenObject) constructor.newInstance();

            // 获取方法 并进行调用
            Method ageMethod = childrenClass.getMethod("setAge", int.class);
            ageMethod.invoke(childrenObject1, 34);
            System.out.println("Age is  " + childrenObject1.getAge());

            // 获取私有方法 并进行调用
            Method method2 = childrenClass.getDeclaredMethod("setGender", String.class);
            method2.setAccessible(true);
            method2.invoke(childrenObject1, "Female");
            System.out.println("Gender is  " + childrenObject1.getGender());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // 注解
    // Java给我们提供了在运行时获取类的注解信息，可以得到类注解，方法注解，参数注解，变量注解。
    private static void lesson05() {
        Class annotationObjectClass = AnnotationObjcet.class;
        // 获取类注解1
        Annotation[] annotations = annotationObjectClass.getAnnotations();
        for (Annotation annotation : annotations) {
            if (annotation instanceof MyAnnotation) {
                String name = ((MyAnnotation) annotation).name();
                String value = ((MyAnnotation) annotation).value();
                System.out.println("name " + name + " value " + value);
            }
        }

        // 获取类注解2
        MyAnnotation myAnnotation = (MyAnnotation) annotationObjectClass.getAnnotation(MyAnnotation.class);
        System.out.println("name " + myAnnotation.name() + " value " + myAnnotation.value());

        // 获取方法注解
        try {
            Method method = annotationObjectClass.getMethod("doOtherThings");
            MyAnnotation methodAnnotation = method.getAnnotation(MyAnnotation.class);
            System.out.println("method annotation name" + methodAnnotation.name() + " value " + methodAnnotation.value());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 获取方法参数注解
        try {
            Method method1 = annotationObjectClass.getMethod("doSomethings", String.class);
            Annotation[][] annotationInParam = method1.getParameterAnnotations();
            Class[] params = method1.getParameterTypes();
            int i = 0;
            for (Annotation[] annotions : annotationInParam) {
                Class para = params[i++];
                for (Annotation notion : annotions) {
                    if (notion instanceof MyAnnotation) {
                        MyAnnotation notionValue = (MyAnnotation) notion;
                        System.out.println("param: " + para.getName());
                        System.out.println("name : " + notionValue.name());
                        System.out.println("value :" + notionValue.value());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 泛型
    //1. 反射得到返回类型为泛型类的方法
    //2. 调用getGenericReturnType得到方法返回类型中的参数化类型
    //3. 判断该type对象能不能向下转型为ParameterizedType
    //4. 转型成功，调用getActualTypeArguments得到参数化类型的数组，因为有的泛型类，不只只有一个参数化类型如Map
    //5. 取出数组中的每一个的值，转型为Class对象输出。

    private static void lesson06(){
        Class genericClass = GenericObject.class;
        try {
            Method method = genericClass.getMethod("getLists");
            Type genericReturnType = method.getGenericReturnType();
            if (genericReturnType instanceof ParameterizedType){
                ParameterizedType parameterizedType = (ParameterizedType) genericReturnType;
                Type[] types = parameterizedType.getActualTypeArguments();
                for (Type type: types){
                    Class clz = (Class) type;
                    System.out.println(" GenericType "+clz.getName());
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        try {
            Method setMethod = genericClass.getMethod("setLists", List.class);
            Type[] genericParameterTypes = setMethod.getGenericParameterTypes();
            for (Type genericParameterType: genericParameterTypes){
                System.out.println("GenericParameterTypes为 ： " + genericParameterType.getTypeName());
                if(genericParameterType instanceof ParameterizedType){
                    ParameterizedType parameterizedType = ((ParameterizedType) genericParameterType);
                    System.out.println("ParameterizedType为 :" + parameterizedType.getTypeName());
                    Type types[] = parameterizedType.getActualTypeArguments();
                    for (Type type : types){
                        System.out.println("参数化类型为 ： " + ((Class) type).getName());
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }


        // 获取成员变量的泛型类型
        try {
            Field field = genericClass.getField("lists");
            Type type = field.getGenericType();
            if (type instanceof ParameterizedType){
                ParameterizedType parameterizedType = ((ParameterizedType) type);
                Type [] types = parameterizedType.getActualTypeArguments();
                for (Type type1 : types) {
                    System.out.println("参数化类型 ： " + ((Class) type1).getTypeName());
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    // 数组
    // Java反射可以对数组进行操作，包括创建一个数组，访问数组中的值，
    // 以及得到一个数组的Class对象
    // 这个forName中的字符串，[表示是数组，I表示是int，float就是F，double就是D等等，如果要得到一个普通对象的数组，则用下面的形式：
    // Class stringClz = Class.forName("[Ljava.lang.String;");
    // [表示是数组,L的右边是类名，类型的右边是一个；；
    private static void lesson07(){
        // 创建一个int类型的数组， 长度为3
        int[] intArray = (int[])Array.newInstance(int.class, 3);

        // 通过反射的形式，给数组赋值
        for (int i =0; i< intArray.length; i++){
             Array.set(intArray, i, i+2);
        }
        // 通过反射的方式，得到数组中的值
        for (int i =0; i< intArray.length; i++){
            System.out.println(" "+ Array.get(intArray, i));
        }
        // 获取数组Class对象
        try {
            // [表示是数组,L的右边是类名，类型的右边是一个;
            Class clz = int[].class;
            Class clz1 = Class.forName("[I");
            Class clz2 = Class.forName("[Ljava.lang.String;");
            // 下面注释的clz3使用方式是错误的
            //Class clz3 = Class.forName("[Lreflection.ChildrenObject");
            System.out.println("class "+clz.getTypeName());
            System.out.println("class1 "+clz1.getTypeName());
            System.out.println("class2 "+clz2.getTypeName());
            //System.out.println("class3 "+clz3.getName());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
