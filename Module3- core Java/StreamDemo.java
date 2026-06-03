import java.util.Arrays;
import java.util.List;

public class StreamDemo {

    public static void main(String[] args) {

        List<Integer> numbers =
                Arrays.asList(10,11,12,13,14,15,16);

        numbers.stream()
               .filter(n -> n % 2 == 0)
               .forEach(System.out::println);
    }
}

/*
10
12
14
16
*/