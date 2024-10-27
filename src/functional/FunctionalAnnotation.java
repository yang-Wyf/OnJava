package functional;

@FunctionalInterface
interface Functional {
    String goodbye(String age);
}

interface FunctionalNoAnn {
    String goodbye(String age);
}

public class FunctionalAnnotation {
    public  String goodbye(String age) {
        return "Goodbye " + age;
    }

    public static void main(String[] args) {
        FunctionalAnnotation fa = new FunctionalAnnotation();
        Functional f = fa::goodbye;
        FunctionalNoAnn fna = fa::goodbye;
        Functional f1 = a -> "Goodbye " + a;
        FunctionalNoAnn fna1 = a -> "Goodbye " + a;
    }
}