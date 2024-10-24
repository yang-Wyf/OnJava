package streams;

import java.util.stream.*;

public class Fibonacci {
    int x = 1;
    Stream<Integer> numbers() {
        return Stream.iterate(0, i -> {
            int result = x + i;
            x = i;
            return result;
        });
    }

    public static void main(String[] args){
        new Fibonacci().numbers().
                limit(20).
                forEach(System.out::println);
    }
}
