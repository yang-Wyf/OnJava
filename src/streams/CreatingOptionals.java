package streams;
/*
@param:
    empty():
               return a null Optional
    of(value):
               if you are already known this value is not null.
               use this function can let it include in an Optional.
    ofNullable(value):
                if value is null, return Optional.empty.
                otherwise,it will put value into an Optional.
*/

import java.util.*;
import java.util.stream.*;
import java.util.function.*;

public class CreatingOptionals {
    static void test(String testName, Optional<String> opt){
        System.out.println(" === " + testName + " ===");
        System.out.println(opt.orElse("Null"));
    }

    public static void main(String[] args) {
        test("empty", Optional.empty());
        test("of", Optional.of("Howdy"));
        try{
            test("of", Optional.of(null));
        } catch (Exception e){
            System.out.println(e);
        }
        test("ofNullable", Optional.ofNullable("Hi"));
        test("ofNullable", Optional.ofNullable(null));
    }
}
