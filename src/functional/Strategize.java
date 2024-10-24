package functional;

interface Strategy{
    String approach(String msg);
}

class Soft implements Strategy{
    @Override
    public String approach(String msg) {
        return msg.toLowerCase() + "?";
    }
}

class Unrelated {
    static String twice(String msg) {
        return msg + " " + msg;
    }
}

public class Strategize {
    Strategy strategy;
    String msg;
    Strategize(String msg) {
        strategy = new Soft();
        this.msg = msg;
    }

    void communicate() {
        System.out.println(strategy.approach(msg));
    }

    void changeStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public static void main(String[] args) {
        Strategy[] strategies = {
                new Strategy() {        // [2] Inner Class
                    @Override
                    public String approach(String msg) {
                        return msg.toUpperCase() + "!";
                    }}, msg -> msg.substring(0, 5),             // [3] Lambda Expressions
        Unrelated::twice
        };
        Strategize s = new Strategize("Hello there");
        s.communicate();
        for (Strategy strategy : strategies) {
            s.changeStrategy(strategy);
            s.communicate();
        }
    }
}
