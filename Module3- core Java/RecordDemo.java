import java.util.List;

record Person(String name, int age) {}

public class RecordDemo {

    public static void main(String[] args) {

        List<Person> people = List.of(
                new Person("Ram",20),
                new Person("Ravi",17),
                new Person("Kumar",25)
        );

        people.stream()
              .filter(p -> p.age() >= 18)
              .forEach(System.out::println);
    }
}

/*
Person[name=Ram, age=20]
Person[name=Kumar, age=25]
*/