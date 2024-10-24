package streams;

import java.util.*;
import java.util.stream.*;

public class OptionalBasics {
    static void test(Optional<String> optString){
        if(optString.isPresent()){
            System.out.println(optString.get());
        }else {
            System.out.println("Nothings");
        }
    }

    public static void main(String[] args) {
        test(Stream.of("Epithests").findFirst());
        test(Stream.<String>empty().findFirst());
    }
}
