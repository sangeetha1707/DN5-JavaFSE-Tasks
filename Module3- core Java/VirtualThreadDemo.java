public class VirtualThreadDemo {

    public static void main(String[] args) {

        for(int i = 1; i <= 100000; i++) {

            int num = i;

            Thread.startVirtualThread(() -> {

                System.out.println(
                        "Virtual Thread " + num);
            });
        }
    }
}

/*
Virtual Thread 1
Virtual Thread 2
Virtual Thread 3
...
Virtual Thread 100000
*/