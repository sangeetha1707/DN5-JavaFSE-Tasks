public class TypeCasting {
    public static void main(String[] args) {

        double d = 15.75;
        int i = (int)d;

        System.out.println("Double Value = " + d);
        System.out.println("Converted Int = " + i);

        int num = 25;
        double value = num;

        System.out.println("Int Value = " + num);
        System.out.println("Converted Double = " + value);
    }
}
/*
Double Value = 15.75
Converted Int = 15
Int Value = 25
Converted Double = 25.0
*/