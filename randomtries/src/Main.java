import java.util.BitSet;
import java.util.Optional;

public class Main {
    private static void test1() {
        var bitSet = new BitSet(16);
        for (int i = 0; i < bitSet.size(); ++i) {
            if (i % 2 == 0) {
                bitSet.set(i);
            }
        }
        System.out.println("bitSet:");
        System.out.println(bitSet);

        Optional<String> str1 = Optional.empty();
        Optional<String> str2 = Optional.of("12e3");

        System.out.println(str1.map(s -> s + "@gmail.com"));
        System.out.println(str2.map(s -> s + "@gmail.com"));
    }

    public static void main(String[] args) {

    }
}
