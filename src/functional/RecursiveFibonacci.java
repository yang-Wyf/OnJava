package functional;

public class RecursiveFibonacci {
    IntCall fib;
    RecursiveFibonacci(){
        fib = n -> n == 0 ? 0 :
                n == 1 ? 1 :
                        fib.call(n - 1) + fib.call(n - 2);
    }
    int fibonacci(int n){ return fib.call(n);}

    public static void main(String[] args) {
        RecursiveFibonacci fib = new RecursiveFibonacci();
        for (int i = 0; i <= 10; i++){
            System.out.println(fib.fibonacci(i));
        }
    }
}