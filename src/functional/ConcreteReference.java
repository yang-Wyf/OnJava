package functional;

class Dog {
    String name;
    int age = -1;
    Dog() {name = "money";}
    Dog(String nm) {this.name = nm;}
    Dog(String nm2, int yrs) {this.name = nm2; this.age = yrs;}
}

interface MakeNoArgs{
    Dog make();
}

interface MakeOneArgs{
    Dog make(String nm);
}

interface MakeTwoArgs{
    Dog make(String nm, int yrs);
}

public class ConcreteReference {
    public static void main(String[] args) {
        MakeNoArgs mna = Dog::new;
        MakeOneArgs mna2 = Dog::new;
        MakeTwoArgs mna3 = Dog::new;

        Dog dn = mna.make();
        Dog dn2 = mna2.make("Fido");
        Dog dn3 = mna3.make("Jimmy", 10);
    }
}
