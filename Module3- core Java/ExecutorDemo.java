import java.util.concurrent.*;

public class ExecutorDemo {

    public static void main(String[] args)
            throws Exception {

        ExecutorService service =
                Executors.newFixedThreadPool(3);

        Callable<String> task1 =
                () -> "Task 1 Completed";

        Callable<String> task2 =
                () -> "Task 2 Completed";

        Callable<String> task3 =
                () -> "Task 3 Completed";

        Future<String> result1 =
                service.submit(task1);

        Future<String> result2 =
                service.submit(task2);

        Future<String> result3 =
                service.submit(task3);

        System.out.println(result1.get());
        System.out.println(result2.get());
        System.out.println(result3.get());

        service.shutdown();
    }
}

/*
Task 1 Completed
Task 2 Completed
Task 3 Completed
*/