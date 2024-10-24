package functional;

interface Description {
    String brief();}

interface Body {
    String detailed(String head);}

interface Multi {
    String twoArg(String head, Double d);}

public class LambdaExpressions {
    static Body body = a -> a + " Nope !";
    static Body body2 = (h) -> h + " More detail.";
    static Description desc = () -> "Short info.";
    // wrong number of parameters: expected 0 but found 1
   /* static Description desc2 = si -> si + "test"; */
    static Multi mult = (a, b) -> a + b;

    static Description moreLines = () -> {
        System.out.println("moreLines()");
        return "from moreLines()";
    };

    public static void main(String[] args) {
        System.out.println(body.detailed("Hello !"));
        System.out.println(body2.detailed("Yeah !"));
        System.out.println(desc.brief());
        System.out.println(mult.twoArg("Pi", 3.1415));
        System.out.println(moreLines.brief());
    }
}
