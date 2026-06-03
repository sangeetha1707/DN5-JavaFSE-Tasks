public class BytecodeDemo {

    public void display() {

        System.out.println("Hello Java");
    }

    public static void main(String[] args) {

        BytecodeDemo obj =
                new BytecodeDemo();

        obj.display();
    }
}

/*
Compile:
javac BytecodeDemo.java

Inspect Bytecode:
javap -c BytecodeDemo
*/