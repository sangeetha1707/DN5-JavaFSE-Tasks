import java.lang.reflect.Method;

class Student {

    public void show() {

        System.out.println("Student Method Called");
    }
}

public class ReflectionDemo {

    public static void main(String[] args) {

        try {

            Class<?> c =
                    Class.forName("Student");

            Method[] methods =
                    c.getDeclaredMethods();

            for(Method m : methods) {

                System.out.println(
                        m.getName());
            }

            Object obj =
                    c.getDeclaredConstructor()
                            .newInstance();

            Method method =
                    c.getMethod("show");

            method.invoke(obj);

        } catch(Exception e) {

            System.out.println(e);
        }
    }
}

/*
show
Student Method Called
*/