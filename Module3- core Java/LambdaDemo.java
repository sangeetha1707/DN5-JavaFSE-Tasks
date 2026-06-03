import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LambdaDemo {

    public static void main(String[] args) {

        List<String> names = new ArrayList<>();

        names.add("Kumar");
        names.add("Arun");
        names.add("Bala");
        names.add("David");

        Collections.sort(names, (a, b) -> a.compareTo(b));

        System.out.println(names);
    }
}

/*
[Arun, Bala, David, Kumar]
*/