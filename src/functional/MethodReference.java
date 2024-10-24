package functional;

import sun.security.krb5.internal.crypto.Des;

interface Callable{
    void call(String s);
}

class Descirbe {
    void show(String msg) {
        System.out.println(msg);
    }
}

public class MethodReference {
    static void hello(String name){
        System.out.println("Hello, " + name);
    }

    static class Description {
        String about;
        Description(String desc) {
            about = desc;
        }
        void help(String msg){
            System.out.println(about + " " + msg);
        }
    }
    static class Helper{
        static void assist(String msg){
            System.out.println(msg);
        }
    }

    public static void main(String[] args) {
        Descirbe d = new Descirbe();
        Callable c = d::show;
        c.call("call()");

        c = MethodReference::hello;
        c.call("Bob");

        c = new Description("valuable")::help;
        c.call("information");

        c = Helper::assist;
        c.call("Help!");
    }
}
