package functional;

public class RecursiveFactorial {
    static IntCall fact;

    public static void main(String[] args) {
        fact = n -> n == 0 ? 1 : n * fact.call(n - 1);
        for (int i = 1; i <= 10; i++){
            System.out.println(fact.call(i));
        }
    }
}
