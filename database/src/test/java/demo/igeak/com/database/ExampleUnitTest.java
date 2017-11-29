package demo.igeak.com.database;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import demo.igeak.com.database.greendao.User;
import demo.igeak.com.database.greendao.UserAnnotation;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void test() {
        //User user = new User();
        System.out.println("startTest");
        Class<User> u = User.class;
        try {
            Method method = u.getMethod("getUserInfo", new Class[]{String.class, int.class});
            UserAnnotation userAnnotation = method.getAnnotation(UserAnnotation.class);
            System.out.println("the name is:" + userAnnotation.name() + "the age is:" + userAnnotation.age());
            if (method != null) {
                method.invoke(u.newInstance(), userAnnotation.name(), userAnnotation.age());
            }
            Field fields[] = u.getDeclaredFields();
            Field f = u.getDeclaredField("value");
            UserAnnotation userAnnotation1 = f.getAnnotation(UserAnnotation.class);
            System.out.println("the f name is:" + userAnnotation1.name() + "the f age is:" + userAnnotation1.age());
            for (Field field : fields) {
                if (field.isAnnotationPresent(UserAnnotation.class)) {
                    System.out.println("the name is:" + field.getName());
                    UserAnnotation annotation = field.getAnnotation(UserAnnotation.class);
                    if (annotation != null) {
                        System.out.println("the name is:" + annotation.name() + "the age is:" + annotation.age());
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public Object getProperty(Object owner, String fieldName) throws Exception {
        Class ownerClass = owner.getClass();

        Field field = ownerClass.getField(fieldName);

        Object property = field.get(owner);

        return property;
    }

    public Object getStaticProperty(String className, String fieldName)
            throws Exception {
        Class ownerClass = Class.forName(className);

        Field field = ownerClass.getField(fieldName);

        Object property = field.get(ownerClass);

        return property;
    }


    public Object invokeMethod(Object owner, String methodName, Object[] args) throws Exception {

        Class ownerClass = owner.getClass();

        Class[] argsClass = new Class[args.length];

        for (int i = 0, j = args.length; i < j; i++) {
            argsClass[i] = args[i].getClass();
        }

        Method method = ownerClass.getMethod(methodName, argsClass);

        return method.invoke(owner, args);
    }

    public Object invokeStaticMethod(String className, String methodName,
                                     Object[] args) throws Exception {
        Class ownerClass = Class.forName(className);

        Class[] argsClass = new Class[args.length];

        for (int i = 0, j = args.length; i < j; i++) {
            argsClass[i] = args[i].getClass();
        }

        Method method = ownerClass.getMethod(methodName, argsClass);

        return method.invoke(null, args);
    }
}